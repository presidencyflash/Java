import java.sql.*;

/**
 * Q3i: JDBC Insert Operation
 * Inserts a new user record into the 'userid' table.
 * 
 * Prerequisites:
 *  - MySQL running on localhost:3306
 *  - Database 'userinfo' with table 'userid' created
 *  - MySQL JDBC connector JAR in classpath
 * 
 * Compile: javac -cp .;mysql-connector-java.jar TestInsert.java
 * Run:     java  -cp .;mysql-connector-java.jar TestInsert
 */
public class TestInsert {
    public static void main(String args[]) throws Exception {
        String id = "20211cse001";
        String pwd = "Forest#321";
        String fullname = "Rama Krishna K";
        String email = "ramakrishna@pu.in";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/userinfo", "root", "your_password");

        Statement stmt = con.createStatement();
        String q1 = "insert into userid values('" + id + "', '" + pwd +
                "', '" + fullname + "', '" + email + "')";
        int x = stmt.executeUpdate(q1);

        if (x > 0)
            System.out.println("Successfully Inserted");
        else
            System.out.println("Insert Failed");

        con.close();
    }
}
