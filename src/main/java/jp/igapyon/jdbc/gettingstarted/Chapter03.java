package jp.igapyon.jdbc.gettingstarted;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 前提: Chapter02 が実行済みで、テーブルが作成済みであること。
 */
public class Chapter03 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.err.println("Hello List Table: Begin.");

        try (var conn = DriverManager.getConnection("jdbc:h2:./target/test")) {
            doListTable01(conn);
        }

        System.err.println("Hello List Table: End.");
    }

    /**
     * @throws SQLException
     */
    public static void doListTable01(Connection conn) throws SQLException {
        System.err.println("trace: List Table.");
        var dbmeta = conn.getMetaData();
        try (ResultSet rs = dbmeta.getTables(null, null, null, new String[] { "TABLE" })) {
            while (rs.next()) {
                System.err.println(rs.getString("TABLE_NAME"));
            }
        }
    }
}
