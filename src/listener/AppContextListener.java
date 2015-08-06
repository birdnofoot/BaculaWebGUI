package listener;

import java.sql.*;
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
		try {
			ServletContext servletContext = servletContextEvent.getServletContext();
			DatabaseController db_controller = new DatabaseController();
			db_controller.connectoDatabase();
			servletContext.setAttribute("db_controller", db_controller);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent)  { 
        ServletContext servletContext = servletContextEvent.getServletContext();
        DatabaseController db_controller = (DatabaseController) servletContext.getAttribute("db_controller");
        db_controller.closeConnection();
    }
}