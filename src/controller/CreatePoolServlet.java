package controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Constant;
import utils.FileIO;

@WebServlet("/createpoolservlet")
public class CreatePoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreatePoolServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

	try {
		String pool_name = request.getParameter("pool_name");
		String pool_type = request.getParameter("pool_type");
		String recycle = request.getParameter("recycle");
		String autoprune = request.getParameter("autoprune");
		String volume_retention = request.getParameter("volume_retention");
		String maximum_volume_bytes = request.getParameter("maximum_volume_bytes");
		String maximum_volumes = request.getParameter("maximum_volumes");
		String maximum_volume_jobs = request.getParameter("maximum_volume_jobs");
		String label_format = request.getParameter("label_format");
		FileIO.createPoolToConfig(pool_name, pool_type, recycle, autoprune, volume_retention, 
				maximum_volume_bytes, maximum_volumes, maximum_volume_jobs,label_format);
		response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
	} catch(IOException e){
		
	}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}