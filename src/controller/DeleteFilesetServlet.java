package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.* ;

@WebServlet("/deletefilesetservlet")
public class DeleteFilesetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteFilesetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileset_name = request.getParameter("fileset_name");
		System.out.println("Here :   "+fileset_name);
		Integer[] startEndMapMatched = new Integer[2];
		File f = new File(Constant.getFilesets());
		startEndMapMatched = AppUtils.getStartEndLineNumberByName(f,"FileSet","Name","\""+fileset_name+"\"");
		System.out.println("start : "+startEndMapMatched[0]+" end : "+startEndMapMatched[1]);
		AppUtils.deleteLinesFromFile(Constant.getFilesets(),startEndMapMatched[0],1+startEndMapMatched[1]-startEndMapMatched[0]);
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}