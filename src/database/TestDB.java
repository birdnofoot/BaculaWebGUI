package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import table.* ;

public class TestDB {

	public static void main(String[] args) throws SQLException {
		DatabaseManager m = new DatabaseManager();
		m.connectoDatabase();
		String nameExistCheckQuery = "SELECT * FROM Pool WHERE NAME = \"Defaueelt\" ; " ;
		ResultSet a = m.query(nameExistCheckQuery);
		
		System.out.println("Pool id is :"+a.next());
		m.closeConnection();
	}
}