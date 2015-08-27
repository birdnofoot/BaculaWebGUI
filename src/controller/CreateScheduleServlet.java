package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.*;

@WebServlet("/createscheduleservlet")
public class CreateScheduleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public CreateScheduleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String schedule_name = request.getParameter("schedule_name");
		String run = request.getParameter("run");
		FileIO.createScheduleToConfig(schedule_name,run);
		response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
