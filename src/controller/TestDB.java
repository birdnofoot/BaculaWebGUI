package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDB {

	public static void main(String[] args) throws SQLException {
		DatabaseController db_controller = new DatabaseController();
		db_controller.openConnection();
		//db_controller.closeConnection();
		db_controller.getPools();
		System.out.println("fff");
		
		}
	}