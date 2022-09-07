package servlet;


import manager.BookManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteBook")

public class DeleteBookServlet extends HttpServlet {

    BookManager bookManager = new BookManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        bookManager.deletedById(Integer.parseInt(id));
        resp.sendRedirect("/books");
    }
}

