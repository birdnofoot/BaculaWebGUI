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

@WebServlet("/searchfileservlet")
public class SearchFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchFileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<FileRecord> fileList = new ArrayList<FileRecord>();
		String file_name = request.getParameter("file_name");
		String query = "SELECT DISTINCT Filename.name, Client.Name, Path.Path, Job.JobId, Job.Name, Job.StartTime, Job.EndTime FROM Client JOIN Job ON Client.ClientId = Job.ClientId JOIN File ON Job.JobId = File.JobId JOIN Filename ON Filename.FilenameId = File.FilenameId JOIN Path ON File.PathId = Path.PathId WHERE Filename.Name LIKE \'%"+file_name+"%\';";
		DatabaseController m = new DatabaseController();
		try {
			m.connectoDatabase();

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
    	request.getRequestDispatcher("SearchFile.jsp").forward(request, response);
    	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}