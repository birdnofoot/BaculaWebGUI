package controller;

import java.sql.*;
import java.util.*;
import model.*;

public class DatabaseController {

    private Connection connexion;
	private static final String url = "jdbc:mysql://localhost:3306/bacula" ;
	private static final String user = "bacula" ;
	private static final String pw = "root" ;
	
	public DatabaseController(){
	}

	public void openConnection() throws SQLException{
    	try {
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		connexion = DriverManager.getConnection(url, user, pw);
    		}
    	catch (InstantiationException | IllegalAccessException | ClassNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public void closeConnection(){
        try {
             if (connexion !=null){
            	 connexion.close();
             }
        } catch (Exception e){
                e.printStackTrace();
        }
    }

	public ResultSet query(String request) throws SQLException{
		ResultSet rs;
		try{
    		Statement statement = connexion.createStatement();
			rs = statement.executeQuery(request);
			statement.close();
			return rs;
			} catch (Exception e){
				e.printStackTrace();
			}
		return null;
	}
	
    public LinkedList<FileSet> getFileSet() throws SQLException{
    	String sql = "SELECT * FROM FileSet;";
        LinkedList<FileSet> fileSet = new LinkedList<FileSet>();
        ResultSet rs = query(sql);
        try{
        	while(rs.next()){
        		fileSet.add(new FileSet(rs.getInt("FileSetId"),rs.getString("FileSet"), rs.getString("MD5"), rs.getString("CreateTime")));
        		}
        	return fileSet;
        } catch (Exception e){
                e.printStackTrace();
        }
        return null;
    }
    
    public ResultSet getClients() throws SQLException{
		String query = "SELECT * FROM Client; " ;
		ResultSet resultSet = this.query(query);
		return resultSet ;
    }
    
    public ResultSet getJobs() throws SQLException{
		String query = "SELECT * FROM Job; " ;
		ResultSet resultSet = this.query(query);
		return resultSet ;
    }
    
    public ResultSet getLogs() throws SQLException{
		String query = "SELECT * FROM Log ; " ;
		ResultSet resultSet = this.query(query);
		return resultSet ;
    }
    
    public ResultSet getFilesets() throws SQLException{
		String query = "SELECT * FROM FileSet ; " ;
		ResultSet resultSet = this.query(query);
		return resultSet ;
    }
    
    public ResultSet getPools() throws SQLException{
		String query = "SELECT * FROM Pool ; " ;
		ResultSet resultSet = this.query(query);
		return resultSet ;
    }
    
    public ResultSet getSchedules() throws SQLException{
		String query = "SELECT * FROM Pool ; " ;
		ResultSet resultSet = this.query(query);
		return resultSet ;
    }
    
    public int getClientNumber() throws SQLException{
    	String query = "SELECT COUNT(*) FROM Client ; " ;
		ResultSet resultSet = this.query(query);
		resultSet.next();
		int nb = resultSet.getInt("Count(*)");
    	return nb;
    }
    
    public ResultSet getStorages() throws SQLException{
    	String query = "SELECT * FROM Storage ; " ;
		ResultSet resultSet = this.query(query);
    	return resultSet;
    }
    
    public int getJobNumber() throws SQLException{
    	String query = "SELECT COUNT(*) FROM Job ; " ;
		ResultSet resultSet = this.query(query);
		resultSet.next();
		int nb = resultSet.getInt("Count(*)");
    	return nb;
    }
    
    public ResultSet getRunningJobs() throws SQLException{
    	String query = "SELECT * FROM Job WHERE JobStatus = \"R\" ; " ;
		ResultSet resultSet = this.query(query);
    	return resultSet;
    }
    
    public int getRunningJobNumber() throws SQLException{
    	String query = "SELECT COUNT(*) FROM Job WHERE JobStatus = \"R\" ; " ;
		ResultSet resultSet = this.query(query);
		resultSet.next();
		int nb = resultSet.getInt("Count(*)");
    	return nb;
    }
    
    public String getClientNameById (String id) throws SQLException {
    	String query = "SELECT name FROM Client WHERE ClientId = \""+id+"\" LIMIT 1;" ;
		ResultSet resultSet = this.query(query);
		resultSet.next();
		String name = resultSet.getString("name");
    	return name ;
    }
}