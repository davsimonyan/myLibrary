package servlet;

import lombok.Builder;
import manager.BookManager;
import model.Author;
import model.Book;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add-book")
public class AddBookServlet extends HttpServlet {

    BookManager bookManager = new BookManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Book book = new Book();
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        String author_id = req.getParameter("author_id");

        book.setTitle(title);
        book.setDescription(description);
        book.setPrice(Integer.parseInt(price));
        book.setAuthor_id(Integer.parseInt(author_id));
        bookManager.add(book);
        resp.sendRedirect("/books");
    }
}
