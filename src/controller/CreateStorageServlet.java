package controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.AppUtils;
import utils.Constant;

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
		if(ip_address.length()==0){
			ip_address = Constant.getLocalhost_ip();
		}
		BufferedWriter bw;

		bw = new BufferedWriter(new FileWriter(Constant.getStorages(), true));
		bw.newLine();
		bw.write("Storage {");
		bw.newLine();
		bw.write("  Name = "+storage_name);
		bw.newLine();
		bw.write("  Address = "+ip_address);
		bw.newLine();
		bw.write("  SDPort = "+Constant.getSd_port());
		bw.newLine();
		bw.write("  Password = \""+Constant.getConfig_password()+"\"");
		bw.newLine();
		bw.write("  Device = "+device);
		bw.newLine();
		bw.write("  Media Type = File");
		bw.newLine();
		bw.write("}");
		bw.newLine();
		bw.close();
		response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}