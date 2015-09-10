package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.*;

@WebServlet("/createfilesetservlet")
public class CreateFilesetServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public CreateFilesetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileset_name = request.getParameter("fileset_name");
		String backup_folder_path = request.getParameter("backup_folder_path");
		String exclude_folder_path = request.getParameter("exclude_folder_path");
		String signature = request.getParameter("signature");
		String compression = request.getParameter("compression");
		FileIO.createFilesetToConfig(fileset_name, backup_folder_path, exclude_folder_path, signature, compression);
		response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
