package controller;

import model.FileHandler;
import model.FileLogger;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created by 21cmPC on 15.03.2017.
 */
public class DownloadFileServlet extends HttpServlet {
    private FileHandler model;
    private FileLogger logger;

    @Override
    public void init() throws ServletException {
        super.init();
        model = (FileHandler) getServletContext().getAttribute("fileHandler");
        logger = (FileLogger) getServletContext().getAttribute("logger");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream out = resp.getOutputStream();

        String fileName = (String) getServletContext().getAttribute("fileName");
        if (fileName != null && !fileName.trim().equals("")) {
            byte[] fileAsBytes = model.getFile(fileName);
            out.write(fileAsBytes);
        } else {
            resp.sendRedirect("http://localhost:8080/list");
        }

    }
}
