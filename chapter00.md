# Chapter 0 : はじめに

『即席 JDBC 入門』へようこそ。
この入門は、Java、SQL、プログラミングなど基本一式をご存じの方が、即席に JDBC を入門するためのコンテンツです。

## 前提

内容を即席に進めるために、前提を以下のようにします。

### 環境的な前提

説明を簡素にするために、以下の環境を前提にコンテンツを記述します。

- Java Version: [Java 11](https://docs.oracle.com/en/java/javase/11/docs/api/index.html) or later
- Database: [h2 database](https://www.h2database.com/)
- Build system: [Apache Maven](https://maven.apache.org/) (pom.xml + Maven repository)
- Env: Java の main から開始

### 技術的な前提

以下のような技術的な前提を満たしているものと仮定してコンテンツを記述します。

- プログラミング経験を持っていること。
    - 一般的なオペレーティングシステムの基本操作一式を理解していること。
    - コマンドラインからの各種操作ができること。
    - 標準エラー出力を利用できて理解していること。
    - 高等教育レベル相当の英語読解能力。
- Java 経験と知識を持っていること。
    - Java ソースコードを記述および理解できること。
    - Java ソースコードをコンパイルして実行できること。
    - Java コンパイルのエラーを自己解決できること。
    - main メソッドからの実行を理解していること。
    - クラス、インスタンス、クラスパス、変数、例外処理、コネクションプール、インスタンスのクローズなどを理解していること。
- データベース経験と知識を持っていること。
    - SQL ソースコードを記述および理解できること。
    - SQL 解釈のエラーを自己解決できること。
    - SQL、DDL、DML、テーブル、レコード、列、型、トランザクション、コミット、ロールバックなどを理解していること。
    - リレーショナルデータベース、一意キー、一意制約違反、結果セット、カーソルなどを理解していること。
- Apache Maven 経験と知識を持っていること。
    - Maven の pom.xml を読み書き実行できること。
    - Maven Central Repository に接続できること。

## ソースコード

このコンテンツに対応するための [Java + JDBC ソースコード](https://github.com/igapyon/InstantJdbcGettingStarted)が公開されています。

- https://github.com/igapyon/InstantJdbcGettingStarted

実際に動かしてみると、理解を深めやすいことが期待できます。

## 進め方

- chapter 1: データベースに接続 (java.sql.Connection の取得)
    - なにはともあれ java.sql.Connection を取得しないと JDBC は話がはじまりません。
    - とりあえず h2 database で話をはじめられるので手っ取り早い。
    - 単純 JDBC Connection の取得のみ話題とし、コネクションプールや JDBC Driver の Type などは端折ります。
- chapter 2: テーブルの作成 (java.sql.PreparedStatement の使用)
    - 次にテーブルを作成します。テーブルがないとそれ以降の説明がしづらいためです。
- chapter 3: テーブルの確認 (...)
- chapter 4: DB接続文字列の変更 (...)
- chapter 5: レコードの追加 (...)
    - 次にテーブルにレコードを追加します。テーブルにレコードがないと検索の説明がしづらいためです。
- chapter 6: レコードの検索 (...)
- chapter 7: レコードの更新 (...)
- chapter 8: レコードの削除 (...)
- chapter 9: トランザクション
- 