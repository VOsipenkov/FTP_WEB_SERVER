package controller;

import model.FileHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 21cmPC on 14.03.2017.
 */
public class ListFilesServlet extends HttpServlet {
    FileHandler model;

    @Override
    public void init() throws ServletException {
        super.init();
        model = (FileHandler) getServletContext().getAttribute("fileHandler");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> files = model.getFilesNames();
        resp.setContentType("text/html");

        req.setAttribute("list", files);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
