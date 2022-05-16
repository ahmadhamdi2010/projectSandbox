package com.sde.passwordmanager;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class myDB{
    static Connection conn;
    static Statement stmt = null;

    public static void main(String[] args) throws SQLException{
        ConnectDb();
        //Authinticate("lll@hotmail.com","256488Lk");         //Wrong credentials, should return 0 or -1
        //Authinticate("mmmk@gmail.com","12345678");        //Correct credentials, should return userID>0
        stmt.close();
    }

    //Connect to DB
    public static void ConnectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager
                    .getConnection("jdbc:mysql://145.14.151.101:3306/u230725563_SDE", "u230725563_SDE", "Ahmadhamd2022");

            //Making sure DB is connected
            if (conn != null) {
                System.out.println("Opened database successfully");
                stmt = conn.createStatement();

               /* String query = "select * from Users";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getString("Username"));
                    System.out.println(rs.getString("Password"));
                    */
                }
            } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static int Authinticate(String username, String password) throws SQLException {
        int validity = 0;
        String queryUn = "SELECT Username, Password, UserID FROM Users WHERE Username = '" + username + "';";
        try {
            try (ResultSet rs = stmt.executeQuery(queryUn)) {

                while (rs.next()) {
                    System.out.println(rs.getString("Username"));
                    if (rs.getString("Password").equals(password)) {
                        //validity is userID for correct credentials
                        validity = rs.getInt("UserID");
                    } else {
                        //Wrong Password
                        validity = -1;
                    }
                   // System.out.println(rs.getString("Password"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return validity;
    }

}