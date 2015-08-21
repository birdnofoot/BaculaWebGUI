package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.* ;

@WebServlet("/createclientservlet")
public class CreateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CreateClientServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String client_name = request.getParameter("client_name");
		String client_ip_address = request.getParameter("client_ip_address");
		String catalog = request.getParameter("catalog");
		String file_retention = request.getParameter("file_retention");
		String autoprune = request.getParameter("autoprune");

		FileIO.createClientToConfig(client_name, client_ip_address, catalog, file_retention, autoprune);
		response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
