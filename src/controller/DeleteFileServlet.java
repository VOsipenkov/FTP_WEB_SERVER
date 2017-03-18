package controller;

import model.FileHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 21cmPC on 15.03.2017.
 */
public class DeleteFileServlet extends HttpServlet {
    FileHandler model;

    @Override
    public void init() throws ServletException {
        super.init();
        model = (FileHandler) getServletContext().getAttribute("fileHandler");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = (String)getServletContext().getAttribute("fileName");
        boolean isRemovedSuccess = model.deleteFile(fileName);

        resp.sendRedirect("http://localhost:8080/list");
    }
}
