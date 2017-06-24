package controller;

import model.FileHandler;
import model.FileLogger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFileServlet extends HttpServlet {
    private FileHandler model;
    private FileLogger logger;

    @Override
    public void init() throws ServletException {
        super.init();
        model = (FileHandler) getServletContext().getAttribute("fileHandler");
        logger = (FileLogger) getServletContext().getAttribute("logger");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = getFileName(filePart);
        InputStream fileContent = filePart.getInputStream();

        model.addFile(fileName, fileContent);
        fileContent.close();

        resp.sendRedirect(resp.encodeRedirectURL("./list"));
    }

    private String getFileName(Part p){
        String GUIDwithext = Paths.get(p.getSubmittedFileName()).getFileName().toString();
        String GUID = GUIDwithext.substring(0, GUIDwithext.lastIndexOf('.'));
        return GUID;
    }
}
