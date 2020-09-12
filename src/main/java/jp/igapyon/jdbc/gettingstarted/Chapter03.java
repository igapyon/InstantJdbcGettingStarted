package jp.igapyon.jdbc.gettingstarted;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 前提
 * 
 * Chapter01 が完了していること。
 */
public class Chapter03 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.err.println("Hello Table: Begin.");

        try (var conn = DriverManager.getConnection("jdbc:h2:./target/test")) {
            proc01(conn);
        }

        System.err.println("Hello Table: End.");
    }

    /**
     * @throws SQLException
     */
    public static void proc01(Connection conn) throws SQLException {
        System.err.println("trace: List Table.");
        var dbmeta = conn.getMetaData();
        try (ResultSet rs = dbmeta.getTables(null, null, null, new String[] { "TABLE" })) {
            while (rs.next()) {
                System.err.println(rs.getString("TABLE_NAME"));
            }
        }
    }
}
