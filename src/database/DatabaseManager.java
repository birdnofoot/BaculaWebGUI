package database;

import java.sql.*;
import java.util.*;
import table.* ;

public class DatabaseManager {
	
    private Connection connexion;
    private Statement statement;
	private static final String url = "jdbc:mysql://localhost:3306/bacula" ;
	private static final String user = "bacula" ;
	private static final String pw = "root" ;
	
	public DatabaseManager(){
		
	}

	protected void connectoDatabase() throws SQLException{
    	try {
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		connexion = DriverManager.getConnection(url, user, pw);
    		statement = connexion.createStatement();
    		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e)
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

    // method to run database query
	public ResultSet query(String request){
		ResultSet rs;
		try{
			connectoDatabase();
			rs = statement.executeQuery(request);
			return rs;
			} catch (Exception e){
				e.printStackTrace();
				}
		return null;
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
}