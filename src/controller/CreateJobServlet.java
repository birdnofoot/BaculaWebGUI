package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.*;

@WebServlet("/createjobservlet")
public class CreateJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateJobServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String job_name = request.getParameter("job_name");
		String jobdefs = request.getParameter("jobdefs");
		String job_type = request.getParameter("job_type");
		String client = request.getParameter("client");
		String pool = request.getParameter("pool");
		String storage = request.getParameter("storage");
		String fileset = request.getParameter("fileset");
		String schedule = request.getParameter("schedule");
		
		FileIO.createJobToConfig(job_name,jobdefs,job_type,client,pool,storage,fileset,schedule);
		response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}