package controller;

import model.FileHandler;
import model.FileLogger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteFileServlet extends HttpServlet {
    private FileHandler model;
    private FileLogger logger;

    @Override
    public void init() throws ServletException {
        model = (FileHandler) getServletContext().getAttribute("fileHandler");
        logger = (FileLogger) getServletContext().getAttribute("logger");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = (String) getServletContext().getAttribute("fileName");
        boolean isRemovedSuccess = model.deleteFile(fileName);
        logger.log("file removed: " + isRemovedSuccess);

        resp.sendRedirect(resp.encodeRedirectURL("./list"));
    }
}
