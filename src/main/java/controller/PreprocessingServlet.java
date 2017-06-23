package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PreprocessingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");

        String fileName = req.getParameter("file");
        String action = req.getParameter("action");

        getServletContext().setAttribute("fileName", fileName);

        if (action == null) {
            resp.sendRedirect(resp.encodeRedirectURL("./list"));
            return;
        }

        switch (action) {
            case "delete":
                resp.sendRedirect(resp.encodeRedirectURL("/FTP_WEB_SERVER/delete"));
                break;
            case "download":
                resp.sendRedirect(resp.encodeRedirectURL("./download"));
                break;
            case "upload":
                resp.sendRedirect(resp.encodeRedirectURL("./UploadPage.jsp"));
                break;
            default:
                resp.sendRedirect(resp.encodeRedirectURL("./list"));
        }
    }
}
