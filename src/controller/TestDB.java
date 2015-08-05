package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDB {

	public static void main(String[] args) throws SQLException {
		DatabaseController m = new DatabaseController();
		m.connectoDatabase();
		String nameExistCheckQuery = "SELECT * FROM Pool WHERE NAME = \"Defaueelt\" ; " ;
		ResultSet a = m.query(nameExistCheckQuery);
		
		System.out.println("Pool id is :"+a.next());
		m.closeConnection();
	}
}