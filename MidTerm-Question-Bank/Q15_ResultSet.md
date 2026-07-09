# Q15. What is ResultSet Interface? Explain with an Example

## What is ResultSet?

`ResultSet` is an interface in `java.sql` that represents the **result table** produced by executing a SELECT query. It acts like a **cursor** that points to rows in the result; initially, the cursor is positioned **before the first row**.

## ResultSet Cursor Navigation

```
Before First Row  <-- initial position
      Row 1
      Row 2
      Row 3
After Last Row
```

## Navigation Methods

| Method | Description |
|--------|-------------|
| `next()` | Moves cursor to next row; returns `false` when no more rows |
| `previous()` | Moves to previous row (needs SCROLL_INSENSITIVE type) |
| `first()` | Moves to first row |
| `last()` | Moves to last row |
| `absolute(n)` | Moves to row number n |
| `beforeFirst()` | Moves before first row |

## Data Retrieval Methods

| Method | Returns |
|--------|--------|
| `getString(index)` or `getString("colName")` | String |
| `getInt(index)` | int |
| `getDouble(index)` | double |
| `getFloat(index)` | float |
| `getBoolean(index)` | boolean |
| `getDate(index)` | java.sql.Date |

> Column index starts from **1**.

## Types of ResultSet

| Type | Description |
|------|-------------|
| `TYPE_FORWARD_ONLY` | Default; cursor moves only forward |
| `TYPE_SCROLL_INSENSITIVE` | Scroll in any direction; not sensitive to DB changes |
| `TYPE_SCROLL_SENSITIVE` | Scroll in any direction; reflects DB changes |

## Example

```java
import java.sql.*;

public class ResultSetDemo {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/userinfo", "root", "your_password");

        Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,   // scrollable
                ResultSet.CONCUR_READ_ONLY            // read-only
        );

        ResultSet rs = stmt.executeQuery("SELECT * FROM userid");

        // Forward iteration
        System.out.println("=== All Users ===");
        while (rs.next()) {
            System.out.println(
                "ID: "       + rs.getString(1) +
                " | Name: "  + rs.getString("fullname") +
                " | Email: " + rs.getString("email")
            );
        }

        // Scroll back to first row
        rs.first();
        System.out.println("\nFirst row again: " + rs.getString("fullname"));

        // Jump to specific row
        rs.absolute(2);
        System.out.println("Row 2: " + rs.getString("fullname"));

        rs.close();
        stmt.close();
        con.close();
    }
}
```

**Expected Output:**
```
=== All Users ===
ID: 20211cse001 | Name: Rama Krishna K | Email: ramakrishna@pu.in
ID: 20211cse002 | Name: Priya Sharma   | Email: priya@pu.in

First row again: Rama Krishna K
Row 2: Priya Sharma
```

## ResultSet Concurrency Types

| Constant | Description |
|----------|-------------|
| `CONCUR_READ_ONLY` | Cannot update the ResultSet |
| `CONCUR_UPDATABLE` | Can update rows in the ResultSet |
