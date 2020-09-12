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

この chapter では、とにかくさっさと java.sql.Connection インスタンスの取得を目指します。

- java.sql.Connection インスタンスは、java.sql.DriverManager#getConnection を用いて取得できます。
- `jdbc:h2:./target/test` は h2 database の JDBC ドライバを用いて `./target` ディレクトリに `test` という名前でデータベースファイルを作成してそのデータベース接続として java.sql.Connection を利用可能にする指定です。

```java
    public static void proc01() throws SQLException {
        System.err.println("trace: Connecting JDBC...");
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./target/test")) {
            System.err.println("trace: JDBC Connected.");

        }
    }
```

### Execute (without JDBC Driver)

h2 database の JDBC ドライバが利用可能ではない状態で、このプログラムを動かすと `java.sql.SQLException: No suitable driver found` という例外が発生して実行中断します。

```sh
Hello JDBC: Begin.
trace: Connecting JDBC...
Exception in thread "main" java.sql.SQLException: No suitable driver found for jdbc:h2:~/test
	at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:702)
	at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:251)
	at jp.igapyon.jdbc.gettingstarted.Chapter01.proc01(Chapter01.java:18)
	at jp.igapyon.jdbc.gettingstarted.Chapter01.main(Chapter01.java:11)
```

### Adding JDBC Driver

h2 database の JDBC ドライバを利用可能にするには `pom.xml` の `<dependencies>` 以下に h2 database のための記述を追加します。

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

### Execute (with JDBC Driver)

h2 database の JDBC ドライバが利用可能な状態で、このプログラムを動かすと、以下のような標準エラーメッセージが表示されて正常終了します。

```sh
Hello JDBC: Begin.
trace: Connecting JDBC...
trace: JDBC Connected.
Hello JDBC: End.
```

これで java.sql.Connection インスタンスの取得が成功しました。
なお java.sql.Connection は close() する必要のあるインスタンスであるため、try(Connection conn = ...) のように自動クローズの記述をしています。

## proc02

せっかく java.sql.Connection インスタンスを取得できたので、java.sql.Connection#getMetaData() のメソッドを呼び出してメタ情報を取得して JDBC 接続の情報を表示してみます。

- java.sql.DatabaseMetaData#getDriverName() : JDBC ドライバ名を取得します。
- java.sql.DatabaseMetaData#getDatabaseMajorVersion() : データベースの(ここでは h2 database) のメジャーバージョンを取得します。
- java.sql.DatabaseMetaData#getDatabaseMinorVersion() : データベースの(ここでは h2 database) のマイナーバージョンを取得します。
- java.sql.DatabaseMetaData#getJDBCMajorVersion() : JDBCドライバの(ここでは h2 database JDBC ドライバ) のメジャーバージョンを取得します。
- java.sql.DatabaseMetaData#getJDBCMinorVersion() : JDBCドライバの(ここでは h2 database JDBC ドライバ) のマイナーバージョンを取得します。

```java
    public static void proc02() throws SQLException, ClassNotFoundException {
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
```

これの実行結果は以下のようになります。

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

これ以外にも様々なメソッドが提供されており、必要に応じて データベースや JDBC ドライバの情報を確認する場面があり、そのようなときにこのメソッドが利用されます。
