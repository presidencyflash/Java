# JDBC Overview – Key Interfaces and Classes (`java.sql.*`)

## Principal JDBC Components

| Component | Type | Purpose |
|-----------|------|---------|
| `Class.forName()` | Method | Loads the JDBC driver class at runtime |
| `DriverManager` | Class | Registers the driver and establishes connections via `getConnection()` |
| `Connection` | Interface | Represents an active DB session; used to create statements |
| `Statement` | Interface | Executes static SQL queries |
| `PreparedStatement` | Interface | Executes parameterized/dynamic SQL queries (extends Statement) |
| `ResultSet` | Interface | Holds rows returned by a SELECT query; iterate using `next()` |
| `SQLException` | Exception | Checked exception thrown by all JDBC methods |

## JDBC 5-Step Algorithm

```java
// Step 1: Load the driver
Class.forName("com.mysql.cj.jdbc.Driver");  // MySQL 8+

// Step 2: Get connection
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/dbname", "username", "password");

// Step 3: Create statement
Statement stmt = con.createStatement();           // static query
PreparedStatement pstmt = con.prepareStatement("DML query"); // dynamic query

// Step 4: Execute query
ResultSet rs = stmt.executeQuery("SELECT ...");   // DQL
int result  = stmt.executeUpdate("INSERT ...");   // DML

// Step 5: Process results
while (rs.next()) {
    System.out.println(rs.getString(1));
}
```

## MySQL Driver Class Names
- MySQL < 8: `com.mysql.jdbc.Driver`
- MySQL ≥ 8: `com.mysql.cj.jdbc.Driver`
