package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 21cmPC on 29.03.2017.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null || name.equals("")) {
            req.getSession().setAttribute("userName", "anonimous");
        } else {
            req.getSession().setAttribute("userName", name);
        }

        resp.sendRedirect("http://localhost:8080/list");
    }
}
