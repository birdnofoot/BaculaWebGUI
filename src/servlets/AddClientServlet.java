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
 * Servlet implementation class AddClientServlet
 */
@WebServlet("/addclientservlet.do")
public class AddClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClientServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter() ;
		String client_name = request.getParameter("client_name");
		String address = request.getParameter("address");
		String fdPort = request.getParameter("fdPort");
		String catalog = request.getParameter("catalog");
		String password = request.getParameter("password");
		String fileRetention = request.getParameter("fileRetention");
		String jobRetention = request.getParameter("jobRetention");
		String autoPrune = request.getParameter("autoPrune");
		String fileset_conf_path = "/etc/bacula/conf.d/clients2.conf" ;
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileset_conf_path, true));
		
		bw.newLine();
		bw.write("Client {");
		bw.newLine();
		bw.write("  Name = "+client_name);
		bw.newLine();
		bw.write("  Address = "+address);
		bw.newLine();
		bw.write("  FDPort = "+fdPort);
		bw.newLine();
		bw.write("  Catalog = "+catalog);
		bw.newLine();
		bw.write("  Password = "+password);
		bw.newLine();
		bw.write("  File Retention = "+fileRetention);
		bw.newLine();
		bw.write("  Job Retention = "+jobRetention);
		bw.newLine();
		if(autoPrune == null){
			bw.write("  AutoPrune = no");
		}
		else{
			bw.write("  AutoPrune = yes");
		}
		bw.newLine();
		bw.write("}");
		bw.newLine();
		bw.close();
		writer.println("The client \""+client_name+"\" has been created with succes. ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
