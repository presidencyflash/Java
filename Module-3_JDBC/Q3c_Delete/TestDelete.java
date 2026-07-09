import java.sql.*;

/**
 * Q3iii: JDBC Delete Operation
 * Deletes a user record from the database.
 */
public class TestDelete {
    public static void main(String args[]) throws Exception {
        String id = "20211cse003";
        String pwd = "Forest#321";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/userinfo", "root", "your_password");

        Statement stmt = con.createStatement();
        String q1 = "DELETE from userid WHERE id = '" + id +
                "' AND pwd = '" + pwd + "'";
        int x = stmt.executeUpdate(q1);

        if (x > 0)
            System.out.println("One User Successfully Deleted");
        else
            System.out.println("ERROR OCCURRED :(");

        con.close();
    }
}
