package controller;

import java.sql.*;

public class DatabaseController {

    private Connection connexion;
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