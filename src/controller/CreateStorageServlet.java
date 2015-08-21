package controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Constant;
import utils.FileIO;

@WebServlet("/createstorageservlet")
public class CreateStorageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateStorageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
		String storage_name = request.getParameter("storage_name");
		String device = request.getParameter("device");
		String ip_address = request.getParameter("ip_address");
		FileIO.createStorageToConfig(storage_name, device, ip_address);
		response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}