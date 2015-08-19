package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.*;

@WebServlet("/createjobdefservlet")
public class CreateJobDefServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateJobDefServlet() {
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
		String priority = null ;
		if(request.getParameter("priority").length()!=0){
			priority = request.getParameter("priority");
		}
		else{
			priority = "10";
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(Constant.getJobdefs(), true));
		
		bw.newLine();
		bw.write("JobDefs {");
		bw.newLine();
		bw.write("  Name = \""+jobdef_name+"\"");
		bw.newLine();
		bw.write("  Type = "+jobdef_type);
		bw.newLine();
		bw.write("  Level = "+level);
		bw.newLine();
		bw.write("  Client = "+client);
		bw.newLine();
		bw.write("  FileSet = \""+fileset+"\"");
		bw.newLine();
		bw.write("  Schedule = \""+schedule+"\"");
		bw.newLine();
		bw.write("  Storage = "+storage);
		bw.newLine();
		bw.write("  Pool = "+pool);
		bw.newLine();
		bw.write("  Priority = "+priority);
		bw.newLine();
		bw.write("}");
		bw.newLine();
		bw.close();
		response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}