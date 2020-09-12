package jp.igapyon.jdbc.gettingstarted;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * chapter 2: テーブルの作成 (java.sql.PreparedStatement の使用)
 */
public class Chapter02 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.err.println("Hello Table: Begin.");

        try (var conn = DriverManager.getConnection("jdbc:h2:./target/test")) {
            proc01(conn);
        }

        System.err.println("Hello Table: End.");
    }

    /**
     * Connection は Chapter01 で学習済みなので var で受けるよう変更します。
     * 
     * @param conn データベース接続。
     * @throws SQLException
     */
    public static void proc01(Connection conn) throws SQLException {
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
