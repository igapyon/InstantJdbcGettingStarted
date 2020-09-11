package jp.igapyon.jdbc.gettingstarted;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Chapter01 {
	public static void main(String[] args) throws SQLException {
		proc01();
	}

	public static void proc01() throws SQLException {
		System.err.println("Hello JDBC.");

		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test")) {
			conn.close();
		}
	}
}
