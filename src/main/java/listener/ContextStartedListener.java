package listener;

import model.DataBase.DbFileHandlerImpl;
import model.FileHandler;
import model.FileLogger;
import model.FileLoggerImpl;
import model.FilesHandlerImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContextStartedListener implements ServletContextListener {
    private Connection connectionForClosing;
    private static final String TIMEZONE_CONF = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String path = servletContextEvent.getServletContext().getInitParameter("loggerPath");
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileLogger logger = new FileLoggerImpl(path);
        servletContextEvent.getServletContext().setAttribute("logger", logger);

        initDBSystemRepo(servletContextEvent);
    }

    private void initFileSystemRepo(ServletContextEvent servletContextEvent) {
        String path = servletContextEvent.getServletContext().getInitParameter("filesRepoPath");
        FileHandler fileHandler = new FilesHandlerImpl(path);

        servletContextEvent.getServletContext().setAttribute("fileHandler", fileHandler);
    }

    private void initDBSystemRepo(ServletContextEvent servletContextEvent) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ftp_db" + TIMEZONE_CONF, "root", "root");
//            servletContextEvent.getServletContext().setAttribute("connection", connection);
//            connectionForClosing = connection;
            FileHandler fileHandler = new DbFileHandlerImpl(connection);
            servletContextEvent.getServletContext().setAttribute("fileHandler", fileHandler);
            System.out.println("Connected to db successful");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (connectionForClosing != null) {
            try {
                connectionForClosing.close();
                System.out.println("Connection to db closed successful");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
