# chapter 3: テーブル作成の確認 (java.sql.ResultSet の使用)

## 前提

- このコンテンツは chapter 0 前提のもとに書かれています。
- Chapter02.java が実行済みで、テーブルが作成済みであること。

## この chapter の内容

この chapter では、テーブル作成が成功したことを ([java.sql.ResultSet](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/ResultSet.html)) を用いて確認します。

Connection インスタンスの getMetaData() メソッドを呼び出すことにより得られる DatabaseMetaData インスタンスの getTables メソッドを呼び出すことによって得られる[java.sql.ResultSet](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/ResultSet.html) インスタンスを利用することにより、データベースのなかのテーブルの一覧を取得できます。
なお、DatabaseMetaData の説明は chapter1 で実施済みですので、不明な場合は chapter1 を参照してください。

getTables メソッドで取得した ResultSet インスタンスを操作してテーブル一覧を見てみましょう。ResultSet インスタンスから、結果セットおよびカーソルの形式によりテーブル一覧を表示できます。

[getTables](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/DatabaseMetaData.html#getTables(java.lang.String,java.lang.String,java.lang.String,java.lang.String%5B%5D)) に記載あるように、この結果セットに含まれる列の一覧は以下のようになります。

- TABLE_CAT
- TABLE_SCHEM
- TABLE_NAME
- TABLE_TYPE
- REMARKS
- TYPE_CAT
- TYPE_SCHEM
- TYPE_NAME
- SELF_REFERENCING_COL_NAME
- REF_GENERATION

このうちテーブル名は TABLE_NAME に含まれます。
取得すぐの ResultSet (結果セット) のカーソルは最初のレコードより前にあります。

ResultSet の next() メソッドを呼び出すと、
- 結果セットにデータがあれば true を返却したうえで最初のレコードにカーソルが移動します。
- 結果セットにデータがない場合は false を返却します。

そのため、テーブル一覧を取得して標準エラー出力に表示するプログラムは以下のようになります。

```java
    public static void doListTable01(Connection conn) throws SQLException {
        System.err.println("trace: List Table.");
        var dbmeta = conn.getMetaData();
        try (ResultSet rs = dbmeta.getTables(null, null, null, new String[] { "TABLE" })) {
            while (rs.next()) {
                System.err.println(rs.getString("TABLE_NAME"));
            }
        }
    }
```

ResultSet インスタンスは close() する必要があるインスタンスであるので、try (ResultSet rs = ...) により自動クローズをしています。
