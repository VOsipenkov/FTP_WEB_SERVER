package listener;

import model.FileHandler;
import model.FileLogger;
import model.FileLoggerImpl;
import model.FilesHandlerImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.IOException;

public class ContextStartedListener implements ServletContextListener {
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

        path = servletContextEvent.getServletContext().getInitParameter("filesRepoPath");
        FileHandler fileHandler = new FilesHandlerImpl(path);

        servletContextEvent.getServletContext().setAttribute("fileHandler", fileHandler);
        logger.log("context initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
