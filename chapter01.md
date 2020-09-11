# Chapter 01

## 前提

- Java 11 or later
- h2 database based
- maven based

## proc01

```java
package jp.igapyon.jdbc.gettingstarted;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Chapter01 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.err.println("Hello JDBC: Begin.");

		proc01();

		System.err.println("Hello JDBC: End.");
	}

	public static void proc01() throws SQLException, ClassNotFoundException {
		System.err.println("trace: Connecting JDBC...");
		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/target/test")) {
			System.err.println("trace: JDBC Connected.");

		}
	}
}
```

### 実行結果

```sh
Hello JDBC: Begin.
trace: Connecting JDBC...
Exception in thread "main" java.sql.SQLException: No suitable driver found for jdbc:h2:~/test
	at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:702)
	at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:251)
	at jp.igapyon.jdbc.gettingstarted.Chapter01.proc01(Chapter01.java:18)
	at jp.igapyon.jdbc.gettingstarted.Chapter01.main(Chapter01.java:11)
```