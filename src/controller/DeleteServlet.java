package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.AppUtils;
import utils.BaculaParser;

@WebServlet("/deleteservlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String deleteType = request.getParameter("deleteType");
		String path = AppUtils.getConfigPathByType(deleteType);
		
		if(deleteType.equals("Job")|| deleteType.equals("Schedule")||deleteType.equals("JobDefs")){
			name = "\""+name+"\"";
		}
		
		Integer[] startEndMapMatched = new Integer[2];
		File f = new File(path);
		startEndMapMatched = BaculaParser.getStartEndLineNumberByName(f,deleteType,"Name",name);
		BaculaParser.deleteLinesFromFile(path,startEndMapMatched[0],1+startEndMapMatched[1]-startEndMapMatched[0]);
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
