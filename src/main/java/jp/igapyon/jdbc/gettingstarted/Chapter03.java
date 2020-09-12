package jp.igapyon.jdbc.gettingstarted;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 前提
 * 
 * Chapter01 が完了していること。
 */
public class Chapter03 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.err.println("Hello insert: Begin.");

        proc01();

        System.err.println("Hello insert: End.");
    }

    /**
     * @throws SQLException
     */
    public static void proc01() throws SQLException {
        try (var conn = DriverManager.getConnection("jdbc:h2:./target/test")) {
            System.err.println("trace: Insert record.");
            try (var stmt = conn.prepareStatement( //
                    "INSERT INTO MyAddressBook"//
                            + " (EMail, Name) VALUES (?, ?)")) {
                stmt.setString(1, "igapyon@gmail.com.example.org");
                stmt.setString(2, "Toshiki Iga");
                stmt.executeUpdate();
            }
        }
    }
}
