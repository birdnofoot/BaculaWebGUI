package database;

import java.sql.SQLException;
import java.util.LinkedList;
import table.* ;

public class TestDB {

	public static void main(String[] args) throws SQLException {
		DatabaseManager m = new DatabaseManager();
		m.connectoDatabase();
		LinkedList<FileSet> fs = new LinkedList<FileSet>();
		fs = m.getFileSet();
		System.out.println("The fileset name is :"+fs.getFirst().getFileSetName());
		m.closeConnection();
	}
}