

## proc01

```java
package jp.igapyon.jdbc.gettingstarted;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Chapter01 {
	public static void main(String[] args) throws SQLException {
		proc01();
	}

	public static void proc01() throws SQLException {
		System.err.println("Hello JDBC.");

		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test")) {
			conn.close();
		}
	}
}
```

### 実行結果

```sh
Hello JDBC.
Exception in thread "main" java.sql.SQLException: No suitable driver found for jdbc:h2:~/test
	at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:702)
	at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:251)
	at jp.igapyon.jdbc.gettingstarted.Chapter01.proc01(Chapter01.java:15)
	at jp.igapyon.jdbc.gettingstarted.Chapter01.main(Chapter01.java:9)
```