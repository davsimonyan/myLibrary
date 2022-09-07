package servlet;

import manager.AuthorManager;
import model.Author;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add-author")
public class AddAuthorServlet extends HttpServlet {
    AuthorManager authorManager = new AuthorManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Author author = new Author();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");
        String email = req.getParameter("email");

        author.setName(name);
        author.setAge(Integer.parseInt(age));
        author.setEmail(email);
        author.setSurname(surname);
        authorManager.add(author);
        resp.sendRedirect("/author");
    }
}
