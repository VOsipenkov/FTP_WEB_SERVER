package controller;

import model.FileHandler;
import model.FileLogger;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 21cmPC on 14.03.2017.
 */
public class ListFilesServlet extends HttpServlet {
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
        List<String> files = model.getFilesNames();

//        resp.setContentType("text/html");

        req.setAttribute("list", files);

        Cookie cookie = new Cookie("userName", (String) req.getSession().getAttribute("userName"));
        cookie.setMaxAge(2 * 60);
//        resp.addCookie(cookie);//todo fix issue

        req.getRequestDispatcher(resp.encodeRedirectURL("./list.jsp")).forward(req, resp);
    }
}
