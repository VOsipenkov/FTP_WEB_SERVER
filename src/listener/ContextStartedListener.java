package listener;

import model.FileHandler;
import model.FilesHandlerImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by 21cmPC on 18.03.2017.
 */
public class ContextStartedListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String path = servletContextEvent.getServletContext().getInitParameter("filesRepoPath");
        FileHandler fileHandler = new FilesHandlerImpl(path);

        servletContextEvent.getServletContext().setAttribute("fileHandler", fileHandler);
        System.err.println("context initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
