# Chapter 00 はじめに

『即席 JDBC 入門』へようこそ。
この入門は、Java、SQL、プログラミングなど基本一式をご存じの方が、即席に JDBC を入門するためのコンテンツです。

## 前提

内容を即席に進めるために、前提を以下のようにします。

- Java Version: Java 11 or later
- Database: h2 database
- Build system: Apache Maven (pom.xml + Maven repository)
- Env: Java の main から開始

## ソースコード

このコンテンツに対応するための [Java + JDBC ソースコード](https://github.com/igapyon/InstantJdbcGettingStarted)が公開されています。

- https://github.com/igapyon/InstantJdbcGettingStarted

実際に動かしてみると、理解を深めやすいことが期待できます。

## 進め方

- chapter 1: java.sql.Connection の取得
    - なにはともあれ java.sql.Connection を取得しないと JDBC は話がはじまりません。
    - とりあえず h2 database で話をはじめられるので手っ取り早い。
    - 単純 JDBC Connection の取得のみ話題とし、コネクションプールや JDBC Driver の Type などは端折ります。
- chapter 2: 
