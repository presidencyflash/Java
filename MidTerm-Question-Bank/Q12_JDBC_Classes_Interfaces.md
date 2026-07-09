# Q12. Explain Briefly the Important Classes and Interfaces of JDBC

## JDBC Package: `java.sql.*`

All JDBC core classes and interfaces are available under `java.sql` package. Here are the most important ones:

---

### 1. `DriverManager` (Class)
- Manages a list of database drivers
- Used to **establish a connection** to the database
```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/dbname", "username", "password");
```

### 2. `Connection` (Interface)
- Represents an **active session** with the database
- Used to create statements
```java
Statement stmt = con.createStatement();
PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE id=?");
con.close(); // always close after use
```

### 3. `Statement` (Interface)
- Executes **static SQL** queries
```java
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM user");
int rows = stmt.executeUpdate("INSERT INTO user VALUES(...)");
```

### 4. `PreparedStatement` (Interface)
- Extends `Statement`; executes **parameterized/dynamic SQL**
- **Prevents SQL Injection**
- Pre-compiled → faster for repeated execution
```java
PreparedStatement pstmt = con.prepareStatement("INSERT INTO user VALUES(?,?,?,?)");
pstmt.setString(1, "20211cse001");
pstmt.setString(2, "pass123");
pstmt.setString(3, "Ravi");
pstmt.setString(4, "ravi@pu.in");
int x = pstmt.executeUpdate();
```

### 5. `ResultSet` (Interface)
- Holds the **rows returned by a SELECT** query
- Acts like a cursor; use `next()` to iterate
```java
ResultSet rs = stmt.executeQuery("SELECT * FROM user");
while (rs.next()) {
    System.out.println(rs.getString(1)); // column 1
    System.out.println(rs.getString("email")); // by column name
}
```

### 6. `SQLException` (Class)
- Checked exception thrown by all JDBC methods
- Must be caught or declared with `throws`
```java
try {
    Connection con = DriverManager.getConnection(url, user, pwd);
} catch (SQLException e) {
    System.out.println("Error: " + e.getMessage());
}
```

### 7. `Class.forName()` (Method)
- Dynamically loads the JDBC driver class at runtime
```java
Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8+
```

## Summary Table

| Component | Type | Key Method(s) |
|-----------|------|---------------|
| `DriverManager` | Class | `getConnection()` |
| `Connection` | Interface | `createStatement()`, `prepareStatement()`, `close()` |
| `Statement` | Interface | `executeQuery()`, `executeUpdate()`, `execute()` |
| `PreparedStatement` | Interface | `setString()`, `setInt()`, `executeUpdate()` |
| `ResultSet` | Interface | `next()`, `getString()`, `getInt()` |
| `SQLException` | Class | `getMessage()`, `getSQLState()` |
