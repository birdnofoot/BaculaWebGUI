package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.*;

@WebServlet("/createjobdefsservlet")
public class CreateJobDefsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateJobDefsServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String jobdef_name = request.getParameter("jobdef_name");
		String jobdef_type = request.getParameter("jobdef_type");
		String level = request.getParameter("level");
		String client = request.getParameter("client");
		String fileset = request.getParameter("fileset");
		String schedule = request.getParameter("schedule");
		String storage = request.getParameter("storage");
		String pool = request.getParameter("pool");
		String incremental_backup_pool = request.getParameter("incremental_backup_pool");
		String full_backup_pool = request.getParameter("full_backup_pool");
		String priority = request.getParameter("priority");
		
		FileIO.createJobDefsToConfig(jobdef_name, jobdef_type, level, client, fileset, schedule, 
				storage, pool, full_backup_pool, incremental_backup_pool, priority);
		
		response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}