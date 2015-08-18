package controller;

import java.io.*;
import java.sql.*;
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
			PrintWriter writer = response.getWriter() ;
			String pool_name = request.getParameter("pool_name");
			boolean isNameExist = false ;
			DatabaseController db_controller = new DatabaseController();
			db_controller.openConnection();	
			
			String nameExistCheckQuery = "SELECT * FROM Pool WHERE NAME = \""+pool_name+"\" ; " ;
			Statement st = db_controller.getConnexion().createStatement();
			ResultSet a = st.executeQuery(nameExistCheckQuery);

			if(a.next()){
				isNameExist = true ;
			};
			a.close();
			st.close();
			db_controller.closeConnection();
			
		if(!isNameExist){
		String pool_type = request.getParameter("pool_type");
		String recycle = request.getParameter("recycle");
		String autoprune = request.getParameter("autoprune");
		String volume_retention = request.getParameter("volume_retention");
		String maximum_volume_bytes = request.getParameter("maximum_volume_bytes");
		String maximum_volumes = request.getParameter("maximum_volumes");
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(Constant.getPools(), true));
		
		bw.newLine();
		bw.write("Pool {");
		bw.newLine();
		bw.write("  Name = "+pool_name);
		bw.newLine();
		bw.write("  Pool Type = "+pool_type);
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
		}
		else{
			writer.println("The pool name \""+pool_name+"\" is in use, please choose another name.");
		}
		response.sendRedirect(request.getContextPath() + "/"+Constant.getIndexPage());
	} catch (SQLException | IOException e) {
		e.printStackTrace();
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}