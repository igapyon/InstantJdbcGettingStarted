# chapter 2: テーブルの作成 (java.sql.PreparedStatement の使用)

## 前提

このコンテンツは chapter 0 前提のもとに書かれています。

## この chapter の内容

この chapter では、テーブルの作成 ([java.sql.PreparedStatement](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/PreparedStatement.html) の使用) をおこないます。
なにより、テーブルがないとそれ以降の説明がしづらいためです。

## Connection の取得と、その後のデータベース処理を分離

この chapter 以降は、Connection の取得と、その後のデータベース処理とを以下のように分けて記述して、Connection の取得は基本的に説明から省きます。

### Connection の取得

```java
        try (var conn = DriverManager.getConnection("jdbc:h2:./target/test")) {
            doCreateTable01(conn);
        }
```

### その後のデータベース処理の例

```java
    public static void doCreateTable01(Connection conn) throws SQLException {
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
```

## テーブルの作成

テーブルの作成は、このコンテンツでは [java.sql.PreparedStatement](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/PreparedStatement.html) を利用します。
この例では [java.sql.Connection](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/Connection.html) の prepareStatement メソッドの引数に DDL の SQL を与えることによって PreparedStatement インスタンスを作成します。この PreparedStatement インスタンスの executeUpdate メソッドを呼び出すことにより、この DDL の SQL を実行します。

```java
    public static void doCreateTable01(Connection conn) throws SQLException {
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
```

この DDL の実行により、h2 database にテーブルが作成されました。ほんとうにテーブルが作成されたかは、次の chapter で確認します。
なお、[java.sql.PreparedStatement](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/PreparedStatement.html) はテーブル作成以外にも、様々な DDL, DML の実行のために利用される JDBC にとって重要な API です。
