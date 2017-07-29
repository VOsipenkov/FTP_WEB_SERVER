package controller;

import model.NameConverter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LoginServlet extends HttpServlet {
    private NameConverter nameConverter = new NameConverter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name != null) {
            byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);//fix from https://stackoverflow.com/questions/16527576/httpservletrequest-utf-8-encoding
            name = new String(bytes, StandardCharsets.UTF_8);
        }

        if (name == null || name.equals("")) {
            req.getSession().setAttribute("userName", "anonimous");
        } else {
            name = nameConverter.doCheck(name);
            req.getSession().setAttribute("userName", name);
        }

        resp.sendRedirect(resp.encodeRedirectURL("./list"));
    }
}
