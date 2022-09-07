package servlet;

import manager.AuthorManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteAuthorServlet extends HttpServlet {

    AuthorManager authorManager = new AuthorManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        authorManager.deletedById(Integer.parseInt(id));
        resp.sendRedirect("/author");
    }
}
