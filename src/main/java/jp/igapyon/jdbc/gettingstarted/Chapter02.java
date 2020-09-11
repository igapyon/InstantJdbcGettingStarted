package jp.igapyon.jdbc.gettingstarted;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 前提
 * 
 * Chapter01 が完了していること。
 */
public class Chapter02 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.err.println("Hello Table: Begin.");

        // proc01();
        proc02();

        System.err.println("Hello Table: End.");
    }

    /**
     * Connection は Chapter01 で学習済みなので var で受けるよう変更します。
     * 
     * @throws SQLException
     */
    public static void proc01() throws SQLException {
        try (var conn = DriverManager.getConnection("jdbc:h2:./target/test")) {
            System.err.println("trace: Create Table.");
            try (PreparedStatement stmt = conn.prepareStatement("CREATE TABLE IF NOT EXISTS " //
                    + "MyAddressBook (" //
                    + "EMail VARCHAR(255) NOT NULL" //
                    + ",Name VARCHAR(80) NOT NULL" //
                    + ",PRIMARY KEY(EMail)" //
                    + ")")) {
                stmt.executeUpdate();
            }
        }
    }

    /**
     * このまま動作させると、１回目は成功して、２回目が失敗します。
     * @throws SQLException
     */
    public static void proc02() throws SQLException {
        try (var conn = DriverManager.getConnection("jdbc:h2:./target/test")) {
            System.err.println("trace: Create Table.");
            try (var stmt = conn.prepareStatement("CREATE TABLE IF NOT EXISTS " //
                    + "MyAddressBook (" //
                    + "EMail VARCHAR(255) NOT NULL" //
                    + ",Name VARCHAR(80) NOT NULL" //
                    + ",PRIMARY KEY(EMail)" //
                    + ")")) {
                stmt.executeUpdate();
            }

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
