package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import controller.DatabaseController;

@WebListener
public class AppContextListener implements ServletContextListener {

    public AppContextListener() {
    }

    public void contextInitialized(ServletContextEvent servletContextEvent)  { 
		ServletContext servletContext = servletContextEvent.getServletContext();
		DatabaseController db_controller = new DatabaseController();
		servletContext.setAttribute("db_controller", db_controller);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent)  { 
    }
}