package servlets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createjobservlet")
public class CreateJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateJobServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter() ;
		String job_name = request.getParameter("job_name");
		String job_type = request.getParameter("job_type");
		String client = request.getParameter("client");
		String storage = request.getParameter("storage");
		String message_type = request.getParameter("message_type");
		String location = request.getParameter("location");

		String fileset_conf_path = "/etc/bacula/conf.d/jobs.conf" ;
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileset_conf_path, true));
		
		bw.newLine();
		bw.write("Job {");
		bw.newLine();
		bw.write("  Name = \""+job_name+"\"");
		bw.newLine();
		bw.write("  Type = "+job_type);
		bw.newLine();
		bw.write("  Client = "+client);
		bw.newLine();
		bw.write("  Storage = "+storage);
		bw.newLine();
		bw.write("  Messages = "+message_type);
		bw.newLine();
		if(!location.isEmpty()){
			bw.write("  Where = "+location);
			bw.newLine();
		}
		bw.write("}");
		bw.newLine();
		bw.close();
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}