import java.sql.*;

/**
 * Q3ii: JDBC Update Operation
 * Updates the password for an existing user record.
 */
public class TestUpdate {
    public static void main(String args[]) throws Exception {
        String id = "20211cse001";
        String pwd = "Forest#321";
        String newPwd = "Afroz123";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/userinfo", "root", "your_password");

        Statement stmt = con.createStatement();
        String q1 = "UPDATE userid set pwd = ' " + newPwd +
                " ' WHERE id = ' " + id + " ' AND pwd = ' " + pwd + " '";
        int x = stmt.executeUpdate(q1);

        if (x > 0)
            System.out.println("Password Successfully Updated");
        else
            System.out.println("ERROR OCCURRED :(");

        con.close();
    }
}
