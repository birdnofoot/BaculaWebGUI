package database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.*;

/**
 * Servlet implementation class TestDatabase
 */
@WebServlet("/TestDatabase")
public class TestDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDatabase() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		DatabaseManager m = new DatabaseManager();
		try {
			m.connectoDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		LinkedList<FileSet> fs = new LinkedList<FileSet>();
		fs = m.getFileSet();
		int i = 0 ;
		System.out.println("size = " + fs.size());
		for(i=0;i<fs.size();i++){
			writer.println(fs.get(i).getFileSetName());
		}
		m.closeConnection();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
