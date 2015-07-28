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

@WebServlet("/createfilesetservlet.do")
public class CreateFilesetServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateFilesetServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter() ;
		String fileset_name = request.getParameter("fileset_name");
		String backup_folder_path = request.getParameter("backup_folder_path");
		String exclude_folder_path = request.getParameter("exclude_folder_path");
		String signature = request.getParameter("signature");

		String fileset_conf_path = "/etc/bacula/conf.d/fileSets-Test.conf" ;
		writer.println("The fileset \""+fileset_name+"\" has been created with succes. ");
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileset_conf_path, true));
		
		bw.newLine();
		bw.write("FileSet {");
		bw.newLine();
		bw.write(" Name = \""+fileset_name+"\"");
		bw.newLine();
		bw.write(" Include {");
		bw.newLine();
		bw.write("   Options {");
		bw.newLine();
		bw.write("     signature = "+signature);
		bw.newLine();
		bw.write("   }");
		bw.newLine();
		bw.write("   File = "+backup_folder_path);
		bw.newLine();
		bw.write(" }");
		bw.newLine();
		bw.write("}");
		bw.newLine();
		bw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
