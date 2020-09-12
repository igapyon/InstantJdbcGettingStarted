package jp.igapyon.jdbc.gettingstarted;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 前提
 * 
 * Chapter01 が完了していること。
 */
public class Chapter05 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.err.println("Hello insert: Begin.");

        try (var conn = DriverManager.getConnection("jdbc:h2:./target/test")) {
            proc01(conn);
        }

        System.err.println("Hello insert: End.");
    }

    /**
     * @throws SQLException
     */
    public static void proc01(Connection conn) throws SQLException {
        System.err.println("trace: Insert record.");
        try (var stmt = conn.prepareStatement( //
                "INSERT INTO MyAddressBook"//
                        + " (EMail, Name) VALUES (?, ?)")) {
            stmt.setString(1, "tyamada01@example.org");
            stmt.setString(2, "Taro Yamada");
            stmt.executeUpdate();
        }

        try (var stmt = conn.prepareStatement( //
                "INSERT INTO MyAddressBook"//
                        + " (EMail, Name) VALUES (?, ?)")) {
            stmt.setString(1, "htanaka01@example.org");
            stmt.setString(2, "Hanako Tanaka");
            stmt.executeUpdate();
        }
    }
}
