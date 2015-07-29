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

/**
 * Servlet implementation class CreateJobServlet
 */
@WebServlet("/CreateJobServlet")
public class CreateJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateJobServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter() ;
		String job_name = request.getParameter("job_name");
		String backup_folder_path = request.getParameter("backup_folder_path");
		String exclude_folder_path = request.getParameter("exclude_folder_path");
		String signature = request.getParameter("signature");
		String compression = request.getParameter("compression");
		String fileset_conf_path = "/etc/bacula/conf.d/fileSets-Test.conf" ;
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileset_conf_path, true));
		
		bw.newLine();
		bw.write("FileSet {");
		bw.newLine();
		bw.write("  Name = \""+job_name+"\"");
		bw.newLine();
		bw.write("  Include {");
		bw.newLine();
		bw.write("    Options {");
		bw.newLine();
		bw.write("      signature = "+signature);
		bw.newLine();
		if (!compression.equals("no compression")){
			bw.write("      compression = "+compression);
			bw.newLine();
		}
		bw.write("    }");
		bw.newLine();
		bw.write("    File = "+backup_folder_path);
		bw.newLine();
		bw.write("  }");
		if(!exclude_folder_path.isEmpty()){
			bw.write("    Exclude = "+exclude_folder_path);
			bw.newLine();
		}
		bw.newLine();
		bw.write("}");
		bw.newLine();
		bw.close();
		writer.println("The fileset \""+job_name+"\" has been created with succes. ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
