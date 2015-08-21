package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FileRecord;

@WebServlet("/searchservlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<FileRecord> fileList = new ArrayList<FileRecord>();
		String file_name = request.getParameter("file_name");
		String client = request.getParameter("client");
		System.out.println("I got client as : "+client);
		String query = null ;
		if(client.equals("All")){
			query = "SELECT DISTINCT Filename.name, Client.Name, Path.Path, Job.JobId, Job.Name, Job.StartTime, Job.EndTime FROM Client JOIN Job ON Client.ClientId = Job.ClientId JOIN File ON Job.JobId = File.JobId JOIN Filename ON Filename.FilenameId = File.FilenameId JOIN Path ON File.PathId = Path.PathId WHERE Filename.Name LIKE \'%"+file_name+"%\';";
		}
		else{
			query = "SELECT DISTINCT Filename.name, Client.Name, Path.Path, Job.JobId, Job.Name, Job.StartTime, Job.EndTime FROM Client JOIN Job ON Client.ClientId = Job.ClientId JOIN File ON Job.JobId = File.JobId JOIN Filename ON Filename.FilenameId = File.FilenameId JOIN Path ON File.PathId = Path.PathId WHERE Filename.Name LIKE \'%"+file_name+"%\' AND Client.Name = \""+client+"\" ;";
		}
		DatabaseController m = new DatabaseController();
		try {
			m.openConnection();

		Statement statement = m.getConnexion().createStatement();
		ResultSet resultset = statement.executeQuery(query);
		
		while(resultset.next()){
			fileList.add(new FileRecord(resultset.getString(1),resultset.getString(2),
					resultset.getString(3),resultset.getString(4),
					resultset.getString(5),resultset.getString(6),
					resultset.getString(7)));
		}
    	resultset.close();
    	statement.close();
    	m.closeConnection();
    	request.setAttribute("fileList", fileList);
    	request.getRequestDispatcher("Search.jsp").forward(request, response);
    	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}