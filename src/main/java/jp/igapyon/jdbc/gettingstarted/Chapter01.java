package jp.igapyon.jdbc.gettingstarted;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * chapter 1: データベースに接続 (java.sql.Connection の取得)
 */
public class Chapter01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.err.println("Hello JDBC: Begin.");

        // proc01();
        proc02();

        System.err.println("Hello JDBC: End.");
    }

    /**
     * JDBC 接続を最初に試みます。
     * 
     * <ul>
     * <li>JDBC はじめの一歩は、java.sql.Connection のインスタンスを取得することです。</li>
     * <li>この処理が失敗する場合は、JDBC にかかわる操作が一切できません。</li>
     * <li>この Getting Started では Maven の Dependency に h2 を追加することにより JDBC
     * 接続を可能にします。</li>
     * </ul>
     * 
     * @throws SQLException SQL例外が発生した場合.
     */
    public static void proc01() throws SQLException {
        System.err.println("trace: Connecting JDBC...");
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./target/test")) {
            System.err.println("trace: JDBC Connected.");

        }
    }

    /**
     * JDBC 接続に成功したので、JDBC の各種情報を取得します。
     * 
     * @throws SQLException SQL例外が発生した場合.
     */
    public static void proc02() throws SQLException {
        System.err.println("trace: Connecting JDBC...");
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./target/test")) {
            System.err.println("trace: JDBC Connected.");

            System.err.println("trace: Show JDBC meta.");
            DatabaseMetaData dbmeta = conn.getMetaData();
            System.err.println("    DriverName: " + dbmeta.getDriverName());
            System.err.println("    DatabaseMajorVersion: " + dbmeta.getDatabaseMajorVersion());
            System.err.println("    DatabaseMinorVersion: " + dbmeta.getDatabaseMinorVersion());
            System.err.println("    JDBCMajorVersion: " + dbmeta.getJDBCMajorVersion());
            System.err.println("    JDBCMinorVersion: " + dbmeta.getJDBCMinorVersion());
        }
    }
}
