# Chapter 01

## 前提

このコンテンツは chapter 0 前提のもとに書かれています。

## この chapter の内容

この chapter では、とにかくさっさと java.sql.Connection インスタンスの取得を目指します。

- java.sql.Connection は JDBC を操作するために最初に必要になるものであるためです。
- 前提にあるように、h2 database の java.sql.Connection を取得します。
- h2 database ではローカル DB のパスを指定するだけでリレーショナルデータベースがすばやく利用できる機能があり、これが実用的であると同時に JDBC 入門にも好適なのです。
- ここでは、単純 JDBC Connection の取得のみ話題とし、コネクションプールや JDBC Driver の Type などの話題は端折ります。



## proc01

```java
    public static void proc01() throws SQLException, ClassNotFoundException {
        System.err.println("trace: Connecting JDBC...");
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/target/test")) {
            System.err.println("trace: JDBC Connected.");

        }
    }
```

### Execute (without JDBC Driver)

```sh
Hello JDBC: Begin.
trace: Connecting JDBC...
Exception in thread "main" java.sql.SQLException: No suitable driver found for jdbc:h2:~/test
	at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:702)
	at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:251)
	at jp.igapyon.jdbc.gettingstarted.Chapter01.proc01(Chapter01.java:18)
	at jp.igapyon.jdbc.gettingstarted.Chapter01.main(Chapter01.java:11)
```

### Execute (with JDBC Driver)

```xml
	<dependencies>

		<!-- https://mvnrepository.com/artifact/com.h2database/h2 -->
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<version>1.4.200</version>
			<scope>runtime</scope>
		</dependency>
	</dependencies>
```

```sh
Hello JDBC: Begin.
trace: Connecting JDBC...
trace: JDBC Connected.
Hello JDBC: End.
```

## proc02

```java
    public static void proc02() throws SQLException, ClassNotFoundException {
        System.err.println("trace: Connecting JDBC...");
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/target/test")) {
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
```

```sh
Hello JDBC: Begin.
trace: Connecting JDBC...
trace: JDBC Connected.
trace: Show JDBC meta.
    DriverName: H2 JDBC Driver
    DatabaseMajorVersion: 1
    DatabaseMinorVersion: 4
    JDBCMajorVersion: 4
    JDBCMinorVersion: 1
Hello JDBC: End.
```