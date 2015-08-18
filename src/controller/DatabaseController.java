package controller;

import java.sql.*;

import utils.Constant;

public class DatabaseController {

    private Connection connexion;
	private static String url = "jdbc:mysql://"+Constant.getDb_url()+":"+Constant.getDb_port()+"/"+Constant.getDb_name() ;
	
	public DatabaseController(){
	}

	public void openConnection() throws SQLException{
    	try {
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		connexion = DriverManager.getConnection(url, Constant.getDb_user(), Constant.getDb_password());
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
    
    public String getClientNameById (String id) {
    	try {
	    	String query = "SELECT name FROM Client WHERE ClientId = \""+id+"\" LIMIT 1;" ;
			Statement statement = this.getConnexion().createStatement();
			ResultSet resultset = statement.executeQuery(query);
			resultset.next();
			String name = resultset.getString("name");
			resultset.close();
			statement.close();
			return name ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null ;
    }

	public Connection getConnexion() {
		return connexion;
	}

	public void setConnexion(Connection connexion) {
		this.connexion = connexion;
	}
}