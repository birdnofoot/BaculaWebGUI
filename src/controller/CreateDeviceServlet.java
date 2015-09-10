package controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.* ;

@WebServlet("/createdeviceservlet")
public class CreateDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateDeviceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String device_name = request.getParameter("device_name");
		String label_media = request.getParameter("label_media");
		String archive_device = request.getParameter("archive_device");
		
		FileIO.createDeviceToConfig(device_name, label_media, archive_device);

		response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}