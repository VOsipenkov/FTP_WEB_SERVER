package controller;

import model.FileHandler;
import model.FileLogger;
import model.Filter;
import utils.HttpUtils;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListFilesWithFilter extends HttpServlet {
    private FileHandler model;
    private FileLogger logger;

    @Override
    public void init() throws ServletException {
        super.init();
        model = (FileHandler) getServletContext().getAttribute("fileHandler");
        logger = (FileLogger) getServletContext().getAttribute("logger");
    }

    /*
    Params
    containsNumber boolean
    containsChar boolean
    containsWord String
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Filter filter = HttpUtils.extractFilter(req);
        List<String> fileNamesFiltered = model.getFilesNames(filter);

        req.setAttribute("list", fileNamesFiltered);
        Cookie cookie = new Cookie("userName", (String) req.getSession().getAttribute("userName"));
        cookie.setMaxAge(2 * 60);

        req.getRequestDispatcher(resp.encodeRedirectURL(".././list.jsp")).forward(req, resp);
    }
}
