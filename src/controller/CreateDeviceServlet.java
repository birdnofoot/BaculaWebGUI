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
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(Constant.getDevices(), true));
		
		bw.newLine();
		bw.write("Device {");
		bw.newLine();
		bw.write("  Name = "+device_name);
		bw.newLine();
		bw.write("  Media Type = File");
		bw.newLine();
		bw.write("  Archive Device = "+archive_device);
		bw.newLine();
		bw.write("  LabelMedia = "+label_media);
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
		response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}