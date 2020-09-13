# chapter 3: テーブル作成の確認 (java.sql.ResultSet の使用)

## 前提

- このコンテンツは chapter 0 前提のもとに書かれています。
- Chapter02.java が実行済みで、テーブルが作成済みであること。

## この chapter の内容

この chapter では、テーブル作成が成功したことを ([java.sql.ResultSet](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/ResultSet.html)) を用いて確認します。

Connection インスタンスの getMetaData() メソッドを呼び出すことにより得られる DatabaseMetaData インスタンスの getTables メソッドを呼び出すことによって得られる[java.sql.ResultSet](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/ResultSet.html) インスタンスを利用することにより、データベースのなかのテーブルの一覧を取得できます。
なお、DatabaseMetaData の説明は chapter1 で実施済みですので、不明な場合は chapter1 を参照してください。

ResultSet インスタンスからは、テーブル一覧の情報を取得できます。
conn オブジェクトから
結果セット、カーソル、
