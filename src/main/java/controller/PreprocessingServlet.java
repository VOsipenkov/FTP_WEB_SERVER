package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class PreprocessingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("file");
        if (fileName != null) {
            byte[] bytes = fileName.getBytes(StandardCharsets.ISO_8859_1);//fix from https://stackoverflow.com/questions/16527576/httpservletrequest-utf-8-encoding
            fileName = new String(bytes, StandardCharsets.UTF_8);
        }

        String action = req.getParameter("action");
        getServletContext().setAttribute("fileName", fileName);

        if (action == null) {
            resp.sendRedirect(resp.encodeRedirectURL("./list"));
            return;
        }

        switch (action) {
            case "delete":
                resp.sendRedirect(resp.encodeRedirectURL("./delete"));
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
