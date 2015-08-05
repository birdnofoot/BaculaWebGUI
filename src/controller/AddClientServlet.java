package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addclientservlet")
public class AddClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddClientServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String client_name = request.getParameter("client_name");
		String client_ip_address = request.getParameter("client_ip_address");
		String fd_port = request.getParameter("fd_port");
		String catalog = request.getParameter("catalog");
		String password = request.getParameter("password");
		String file_retention = request.getParameter("file_retention");
		String autoprune = request.getParameter("autoprune");
		String fileset_conf_path = "/etc/bacula/conf.d/clients.conf" ;
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileset_conf_path, true));
		
		bw.newLine();
		bw.write("Client {");
		bw.newLine();
		bw.write("  Name = "+client_name);
		bw.newLine();
		bw.write("  Address = "+client_ip_address);
		bw.newLine();
		bw.write("  FDPort = "+fd_port);
		bw.newLine();
		bw.write("  Catalog = "+catalog);
		bw.newLine();
		bw.write("  Password = "+password);
		bw.newLine();
		bw.write("  File Retention = "+file_retention);
		bw.newLine();
		bw.write("  AutoPrune = "+autoprune);
		bw.newLine();
		bw.write("}");
		bw.newLine();
		bw.close();
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
