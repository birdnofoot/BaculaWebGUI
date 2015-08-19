package controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Constant;

@WebServlet("/createpoolservlet")
public class CreatePoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreatePoolServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

	try {
		String pool_name ;
		String pool_type ;
		String label_format ;
		String volume_retention ;
		String maximum_volume_bytes ;
		String maximum_volumes ;
		String recycle ;
		String autoprune ;
		
		pool_name = request.getParameter("pool_name");
		pool_type = request.getParameter("pool_type");
		
		if(request.getParameter("label_format").length()!=0){
			label_format = request.getParameter("label_format") ;
		}
		else{
			label_format = pool_name + "-${Year}${Month:p/2/0/r}${Day:p/2/0/r}";
		}
		
		if(request.getParameter("volume_retention").length()!=0){
			volume_retention = request.getParameter("volume_retention") ;
		}
		else{
			volume_retention = "365 days";
		}
		
		if(request.getParameter("maximum_volume_bytes").length()!=0){
			maximum_volume_bytes = request.getParameter("maximum_volume_bytes") ;
		}
		else{
			maximum_volume_bytes = "50G";
		}
		
		if(request.getParameter("maximum_volumes").length()!=0){
			maximum_volumes = request.getParameter("maximum_volumes") ;
		}
		else{
			maximum_volumes = "100";
		}
		
		recycle = request.getParameter("recycle");
		autoprune = request.getParameter("autoprune");

		BufferedWriter bw = new BufferedWriter(new FileWriter(Constant.getPools(), true));
		
		bw.newLine();
		bw.write("Pool {");
		bw.newLine();
		bw.write("  Name = "+pool_name);
		bw.newLine();
		bw.write("  Pool Type = "+pool_type);
		bw.newLine();
		bw.write("  Label format = \""+label_format+"\"");
		bw.newLine();
		bw.write("  Recycle = "+recycle);
		bw.newLine();
		bw.write("  AutoPrune = "+autoprune);
		bw.newLine();
		bw.write("  Volume Retention = "+volume_retention);
		bw.newLine();
		bw.write("  Maximum Volume Bytes = "+maximum_volume_bytes);
		bw.newLine();
		bw.write("  Maximum Volumes = "+maximum_volumes);
		bw.newLine();
		bw.write("}");
		bw.newLine();
		bw.close();
		response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
	} catch(IOException e){
		
	}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}