package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDB {

	public static void main(String[] args) throws SQLException {
		DatabaseController db_controller = new DatabaseController();
		ResultSet job_rs = db_controller.getJobs();
		job_rs.next();
		String time = job_rs.getString("StartTime") ;
		String[] parts = time.split("\\.");
		System.out.println(parts[0]);
		}
	}