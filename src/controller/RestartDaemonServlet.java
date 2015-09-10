package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.*;

@WebServlet("/restartdaemonservlet")
public class RestartDaemonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RestartDaemonServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fd_value = "0" ;
		String sd_value = "0";
		String director_value = "0" ;
		if(request.getParameter("bacula_fd")!=null){
			fd_value = "1" ;
		}
		if(request.getParameter("bacula_sd")!=null){
			sd_value = "2" ;
		}
		if(request.getParameter("bacula_director")!=null){
			director_value = "3";
		}
		String param = fd_value + " "+ sd_value + " "+ director_value;
		System.out.println(param);
		ArrayList<String>[] cmd_output = AppUtils.runShell(Constant.getBash(), Constant.getRestartDaemonScritpt(),param);
    	request.setAttribute("cmd_output", cmd_output);
    	request.getRequestDispatcher("RestartDaemon.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}