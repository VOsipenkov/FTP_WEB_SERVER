package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 21cmPC on 15.03.2017.
 */
public class PreprocessingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String fileName = req.getParameter("file");
        String action = req.getParameter("action");

        getServletContext().setAttribute("fileName", fileName);

        if (action == null) {
            resp.sendRedirect("http://localhost:8080/list");
            return;
        }

        switch (action) {
            case "delete":
                resp.sendRedirect("http://localhost:8080/delete");
                break;
            case "download":
                resp.sendRedirect("http://localhost:8080/download");
                break;
            case "upload":
                resp.sendRedirect("http://localhost:8080/UploadPage.jsp");
                break;
            default:
                resp.sendRedirect("http://localhost:8080/list");
        }
    }
}
