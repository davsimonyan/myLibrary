package manager;

import db.DBConnectionProvider;
import model.Book;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class BookManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void add(Book book) {
        String sql = "insert into book(title,description,price,author_id) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getDescription());
            ps.setInt(3, book.getPrice());
            ps.setInt(4, book.getAuthor_id());

            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                book.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAll() {
        String sql = "select * from book";
        List<Book> books = new ArrayList<>();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                books.add(getBookFromResultSet(resultSet));
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book getById(int id) {
        String sql = "select * from book where id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return getBookFromResultSet(resultSet);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Book getBookFromResultSet(ResultSet resultSet) throws SQLException, ParseException {

        return Book.builder()
                .id(resultSet.getInt("id"))
                .title(resultSet.getString("title"))
                .description(resultSet.getString("description"))
                .price(resultSet.getInt("price"))
                .author_id(resultSet.getInt("author_id"))
                .build();
    }

    public void deletedById(int id) {
        String sql = "delete from book where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

