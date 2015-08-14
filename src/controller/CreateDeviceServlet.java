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
		String media_type = request.getParameter("media_type");
		String labelmedia = request.getParameter("labelmedia");
		String archieve_device = request.getParameter("archieve_device");
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(Constant.getDevices(), true));
		
		bw.newLine();
		bw.write("Device {");
		bw.newLine();
		bw.write("  Name = "+device_name);
		bw.newLine();
		bw.write("  Media Type = "+media_type);
		bw.newLine();
		bw.write("  Archive Device = "+archieve_device);
		bw.newLine();
		bw.write("  LabelMedia = "+labelmedia);
		bw.newLine();
		bw.write("  Random Access = yes;");
		bw.newLine();
		bw.write("  AutomaticMount = yes;");
		bw.newLine();
		bw.write("  RemovableMedia = no;");
		bw.newLine();
		bw.write("  AlwaysOpen = no;");
		bw.newLine();
		bw.write("}");
		bw.newLine();
		bw.close();
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}