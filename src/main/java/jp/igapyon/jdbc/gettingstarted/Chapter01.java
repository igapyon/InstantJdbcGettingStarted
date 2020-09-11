package jp.igapyon.jdbc.gettingstarted;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Chapter01 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.err.println("Hello JDBC: Begin.");

		proc01();

		System.err.println("Hello JDBC: End.");
	}

	public static void proc01() throws SQLException, ClassNotFoundException {
		System.err.println("trace: Connecting JDBC...");
		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/target/test")) {
			System.err.println("trace: JDBC Connected.");

		}
	}
}
