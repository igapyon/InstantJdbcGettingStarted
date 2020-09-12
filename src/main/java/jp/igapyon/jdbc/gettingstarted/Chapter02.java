package jp.igapyon.jdbc.gettingstarted;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 前提
 * 
 * Chapter01 が完了していること。
 */
public class Chapter02 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.err.println("Hello Table: Begin.");

        proc01();
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
     * @throws SQLException
     */
    public static void proc02() throws SQLException {
        try (var conn = DriverManager.getConnection("jdbc:h2:./target/test")) {
            System.err.println("trace: List Table.");
            var dbmeta = conn.getMetaData();
            try (ResultSet rs = dbmeta.getTables(null, null, null, new String[] { "TABLE" })) {
                while (rs.next()) {
                    System.err.println(rs.getString("TABLE_NAME"));
                }
            }
        }
    }
}
