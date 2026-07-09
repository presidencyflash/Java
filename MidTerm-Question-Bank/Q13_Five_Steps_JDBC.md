# Q13. Explain in Detail the Five Steps of Java Database Connectivity

## The 5 Steps of JDBC

---

### Step 1: Load / Register the Driver

Load the JDBC driver class into memory using `Class.forName()`.

```java
// For MySQL version < 8
Class.forName("com.mysql.jdbc.Driver");

// For MySQL version >= 8
Class.forName("com.mysql.cj.jdbc.Driver");
```

> This step registers the driver with `DriverManager`. In modern JDBC (4.0+), this step is **automatic** if the driver JAR is in the classpath, but it’s good practice to include it explicitly.

---

### Step 2: Establish Connection

Use `DriverManager.getConnection()` with the **JDBC URL**, **username**, and **password**.

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/userinfo",  // URL
    "root",                                   // username
    "your_password"                           // password
);
```

JDBC URL format for MySQL:
```
jdbc:mysql://<host>:<port>/<database_name>
```

---

### Step 3: Create a Statement

Create a SQL execution object from the connection.

```java
// For static queries:
Statement stmt = con.createStatement();

// For dynamic/parameterized queries:
PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE id = ?");
```

---

### Step 4: Execute the Query

Run the SQL command using the appropriate method:

| Method | Use For | Returns |
|--------|---------|--------|
| `executeQuery(sql)` | SELECT | `ResultSet` |
| `executeUpdate(sql)` | INSERT / UPDATE / DELETE | `int` (rows affected) |
| `execute(sql)` | Any SQL | `boolean` |

```java
// DQL - SELECT
ResultSet rs = stmt.executeQuery("SELECT * FROM user");

// DML - INSERT, UPDATE, DELETE
int rows = stmt.executeUpdate("INSERT INTO user VALUES('id1','pwd1','Name','email')");
```

---

### Step 5: Process Results and Close Connection

Iterate over `ResultSet` if it’s a SELECT, then close all resources.

```java
while (rs.next()) {
    System.out.println("ID: " + rs.getString(1));
    System.out.println("Name: " + rs.getString(3));
}

// Always close in reverse order
rs.close();
stmt.close();
con.close();
```

## Complete Working Example

```java
import java.sql.*;

public class FiveStepsDemo {
    public static void main(String[] args) throws Exception {

        // Step 1: Load Driver
        Class.forName("com.mysql.jdbc.Driver");

        // Step 2: Get Connection
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/userinfo", "root", "your_password");

        // Step 3: Create Statement
        Statement stmt = con.createStatement();

        // Step 4: Execute Query
        ResultSet rs = stmt.executeQuery("SELECT * FROM userid");

        // Step 5: Process Results
        while (rs.next()) {
            System.out.println(rs.getString(1) + " | " + rs.getString(3));
        }

        rs.close();
        stmt.close();
        con.close();
    }
}
```
