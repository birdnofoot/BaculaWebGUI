package controller;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createpoolservlet")
public class CreatePoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreatePoolServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter() ;
		String pool_name = request.getParameter("pool_name");
		boolean isNameExist = false ;
		DatabaseController m = new DatabaseController();
		try {
			m.connectoDatabase();
			String nameExistCheckQuery = "SELECT * FROM Pool WHERE NAME = \""+pool_name+"\" ; " ;
			ResultSet a = m.query(nameExistCheckQuery);
			if(a.next()){
				isNameExist = true ;
			};
			m.closeConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(!isNameExist){
		String pool_type = request.getParameter("pool_type");
		String recycle = request.getParameter("recycle");
		String autoprune = request.getParameter("autoprune");
		String volume_retention = request.getParameter("volume_retention");
		String maximum_volume_bytes = request.getParameter("maximum_volume_bytes");
		String maximum_volumes = request.getParameter("maximum_volumes");
		String pools_conf_path = "/etc/bacula/conf.d/pools.conf" ;
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(pools_conf_path, true));
		
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
		writer.println("The pool \""+pool_name+"\" has been created with succes. ");
		}
		else{
			writer.println("The pool name \""+pool_name+"\" is in use, please choose another name.");
		}
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}