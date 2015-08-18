package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import model.Status;
import utils.AppUtils;

public class TestDB {

	public static void main(String[] args) throws SQLException {
		int i = 1 ;
		String file_name = "bacula";
		String query = "SELECT Filename.name, Client.Name, Path.Path, Job.JobId, Job.Name, Job.StartTime, Job.EndTime FROM Client JOIN Job ON Client.ClientId = Job.ClientId JOIN File ON Job.JobId = File.JobId JOIN Filename ON Filename.FilenameId = File.FilenameId JOIN Path ON File.PathId = Path.PathId WHERE Filename.Name RLIKE \'"+file_name+"\';";
		DatabaseController m = new DatabaseController();
		m.connectoDatabase();
		Statement statement = m.getConnexion().createStatement();
		ResultSet resultset = statement.executeQuery(query);
		
		while(resultset.next()){
			System.out.println(resultset.getString(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getString(3));
			System.out.println(resultset.getString(4));
			System.out.println(resultset.getString(5));
			System.out.println(resultset.getString(6));
			System.out.println(resultset.getString(7));
		}
    	resultset.close();
    	statement.close();
    	m.closeConnection();
		}
	}