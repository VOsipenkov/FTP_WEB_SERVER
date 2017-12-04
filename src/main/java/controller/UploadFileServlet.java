package controller;

import model.FileHandler;
import model.FileLogger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
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

        String fileName = getSubmittedFileName(filePart);
        Long size = getSize(filePart);
        String author = (String)req.getSession().getAttribute("userName");
        InputStream fileContent = filePart.getInputStream();

        boolean success = model.addFile(fileName, fileContent, size, author);
        fileContent.close();

        resp.sendRedirect(resp.encodeRedirectURL("./list"));
    }

    // https://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet
    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    private static long getSize(Part part){
        return part.getSize();
    }
}
