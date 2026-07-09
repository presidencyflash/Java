import java.sql.*;

/**
 * Q3iv: JDBC Select Operation
 * Fetches and displays a user record from the database.
 * 
 * Expected Output:
 *   User-Id : 20211cse001
 *   Full Name : Rama Krishna K
 *   E-mail : ramakrishna@pu.in
 */
public class TestSelect {
    public static void main(String args[]) throws Exception {
        String id = "20211cse001";
        String pwd = "Afroz123";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/userinfo", "root", "your_password");

        Statement stmt = con.createStatement();
        String q1 = "select * from userid WHERE id = '" + id +
                "' AND pwd = '" + pwd + "'";
        ResultSet rs = stmt.executeQuery(q1);

        if (rs.next()) {
            System.out.println("User-Id : " + rs.getString(1));
            System.out.println("Full Name :" + rs.getString(3));
            System.out.println("E-mail :" + rs.getString(4));
        } else {
            System.out.println("No such user id is already registered");
        }

        con.close();
    }
}
