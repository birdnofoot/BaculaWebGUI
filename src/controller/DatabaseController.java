package controller;

import java.sql.*;
import java.util.*;
import model.*;

public class DatabaseController {

    private Connection connexion;
    private Statement statement;
	private static final String url = "jdbc:mysql://localhost:3306/bacula" ;
	private static final String user = "bacula" ;
	private static final String pw = "root" ;
	
	public DatabaseController(){
	}

	public void connectoDatabase() throws SQLException{
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

    
    public LinkedList<FileSet> getFileSet(){
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
    
    public ResultSet getClients(){
		String query = "SELECT * FROM Client; " ;
		ResultSet resultSet = this.query(query);
		return resultSet ;
    }
    
    public ResultSet getJobs(){
		String query = "SELECT * FROM Job; " ;
		ResultSet resultSet = this.query(query);
		return resultSet ;
    }
    
    public ResultSet getLogs(){
		String query = "SELECT * FROM Log ; " ;
		ResultSet resultSet = this.query(query);
		return resultSet ;
    }
    
    public ResultSet getFilesets(){
		String query = "SELECT * FROM FileSet ; " ;
		ResultSet resultSet = this.query(query);
		return resultSet ;
    }
    
    public ResultSet getPools(){
		String query = "SELECT * FROM Pool ; " ;
		ResultSet resultSet = this.query(query);
		return resultSet ;
    }
    
    public ResultSet getSchedules(){
		String query = "SELECT * FROM Pool ; " ;
		ResultSet resultSet = this.query(query);
		return resultSet ;
    }
       
    public ResultSet getStorages() throws SQLException{
    	String query = "SELECT * FROM Storage ; " ;
		ResultSet resultSet = this.query(query);
    	return resultSet;
    }
    

    public int getClientNumber() throws SQLException{
    	String query = "SELECT COUNT(*) FROM Client ; " ;
		Statement statement = this.getConnexion().createStatement();
		ResultSet resultset = statement.executeQuery(query);
		resultset.next();
		int nb = resultset.getInt("Count(*)");
		resultset.close();
		statement.close();
    	return nb;
    }
    
    public int getJobNumber() throws SQLException{
    	String query = "SELECT COUNT(*) FROM Job ; " ;
		Statement statement = this.getConnexion().createStatement();
		ResultSet resultset = statement.executeQuery(query);
		resultset.next();
		int nb = resultset.getInt("Count(*)");
		resultset.close();
		statement.close();
    	return nb;
    }
    
    public ResultSet getRunningJobs() throws SQLException{
    	String query = "SELECT * FROM Job WHERE JobStatus = \"R\" ; " ;
		ResultSet resultSet = this.query(query);
    	return resultSet;
    }
    
    public int getRunningJobNumber() throws SQLException{
    	String query = "SELECT COUNT(*) FROM Job WHERE JobStatus = \"R\" ; " ;
		Statement statement = this.getConnexion().createStatement();
		ResultSet resultset = statement.executeQuery(query);
		resultset.next();
		int nb = resultset.getInt("Count(*)");
		resultset.close();
		statement.close();
    	return nb;
    }
    
    public String getClientNameById (String id) throws SQLException {
    	String query = "SELECT name FROM Client WHERE ClientId = \""+id+"\" LIMIT 1;" ;
		Statement statement = this.getConnexion().createStatement();
		ResultSet resultset = statement.executeQuery(query);
		resultset.next();
		String name = resultset.getString("name");
		resultset.close();
		statement.close();
    	return name ;
    }

	public Connection getConnexion() {
		return connexion;
	}

	public void setConnexion(Connection connexion) {
		this.connexion = connexion;
	}
}