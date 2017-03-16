package controller;

import model.FileHandler;
import model.FilesHandlerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

/**
 * Created by 21cmPC on 15.03.2017.
 */
public class UploadFileServlet extends HttpServlet {
    FileHandler model = new FilesHandlerImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description"); // Retrieves <input type="text" name="description">
        Part filePart = req.getPart("file"); // Retrieves <input type="file" name="file">

        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();

        model.addFile(fileName, fileContent);

        resp.sendRedirect("http://localhost:8080/list");
    }
}
