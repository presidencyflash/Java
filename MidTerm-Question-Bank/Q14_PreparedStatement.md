# Q14. Explain PreparedStatement in JDBC with an Example

## What is PreparedStatement?

`PreparedStatement` is a sub-interface of `Statement` that allows you to execute **parameterized SQL queries**. The SQL is **pre-compiled** by the database, and parameters (represented by `?`) are set before execution.

## Why Use PreparedStatement over Statement?

| Feature | `Statement` | `PreparedStatement` |
|---------|-------------|---------------------|
| SQL Injection | Vulnerable | ✅ Protected |
| Performance | Re-compiled every time | ✅ Pre-compiled once |
| Readability | String concatenation | ✅ Clean parameter binding |
| Reusability | Cannot reuse | ✅ Can reuse with different params |

## Setter Methods

| Method | Used For |
|--------|----------|
| `setString(index, value)` | String / VARCHAR |
| `setInt(index, value)` | Integer |
| `setDouble(index, value)` | Double / DECIMAL |
| `setFloat(index, value)` | Float |
| `setBoolean(index, value)` | Boolean |
| `setDate(index, value)` | java.sql.Date |

> Parameter index starts from **1** (not 0).

## Example: CRUD with PreparedStatement

```java
import java.sql.*;

public class PreparedStmtDemo {
    static Connection con;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/userinfo", "root", "your_password");

        insertUser("20211cse010", "Pass@123", "Priya Sharma", "priya@pu.in");
        updatePassword("20211cse010", "Pass@123", "NewPass@456");
        selectUser("20211cse010", "NewPass@456");
        deleteUser("20211cse010");

        con.close();
    }

    // INSERT using PreparedStatement
    static void insertUser(String id, String pwd, String name, String email) throws Exception {
        String sql = "INSERT INTO userid VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, pwd);
        pstmt.setString(3, name);
        pstmt.setString(4, email);
        int rows = pstmt.executeUpdate();
        System.out.println(rows > 0 ? "Inserted successfully" : "Insert failed");
        pstmt.close();
    }

    // UPDATE using PreparedStatement
    static void updatePassword(String id, String oldPwd, String newPwd) throws Exception {
        String sql = "UPDATE userid SET pwd = ? WHERE id = ? AND pwd = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, newPwd);
        pstmt.setString(2, id);
        pstmt.setString(3, oldPwd);
        int rows = pstmt.executeUpdate();
        System.out.println(rows > 0 ? "Password updated" : "Update failed");
        pstmt.close();
    }

    // SELECT using PreparedStatement
    static void selectUser(String id, String pwd) throws Exception {
        String sql = "SELECT * FROM userid WHERE id = ? AND pwd = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, pwd);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println("User: " + rs.getString(3) + " | Email: " + rs.getString(4));
        }
        rs.close();
        pstmt.close();
    }

    // DELETE using PreparedStatement
    static void deleteUser(String id) throws Exception {
        String sql = "DELETE FROM userid WHERE id = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, id);
        int rows = pstmt.executeUpdate();
        System.out.println(rows > 0 ? "User deleted" : "Delete failed");
        pstmt.close();
    }
}
```

**Expected Output:**
```
Inserted successfully
Password updated
User: Priya Sharma | Email: priya@pu.in
User deleted
```
