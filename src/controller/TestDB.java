package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDB {

	public static void main(String[] args) throws SQLException {
		DatabaseController db_controller = new DatabaseController();
		String name = db_controller.getClientNameById("1");
		System.out.println(name);
		}
	}