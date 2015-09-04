package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.*;

@WebServlet("/runjobservlet")
public class RunJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RunJobServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String job_name = request.getParameter("job_name");
		ArrayList<String>[] cmd_output = AppUtils.runShell(Constant.getBash(), Constant.getRunJobScritpt(),job_name);
    	request.setAttribute("cmd_output", cmd_output);
    	request.getRequestDispatcher("RunJob.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}