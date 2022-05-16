package com.sde.passwordmanager;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class myDB{




    public static void main(String[] args) throws SQLException{
        ConnectDb();
        //Authinticate("lll@htmail.com","25648Lk");         //Wrong credentials, should return 0 or -1
        //Authinticate("mmmk@gmail.com","12345678");        //Correct credentials, should return userID>0
     }

    //Connect to DB
    public static Connection ConnectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = null;
            Connection conn = DriverManager
                    .getConnection("jdbc:mysql://145.14.151.101:3306/u230725563_SDE", "u230725563_SDE", "Ahmadhamd2022");

            //Making sure DB is connected
            if (conn != null) {
                System.out.println("Opened database successfully");
                //stmt = conn.createStatement();
                return conn;

               /* String query = "select * from Users";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getString("Username"));
                    System.out.println(rs.getString("Password"));
                    */
            }else{
                System.out.println("Opened database Failed");
                return null;

            }
            } catch (SQLException exception) {
            throw new RuntimeException(exception);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static int Authinticate(String username, String password) throws SQLException {
        int validity = 0;
        Statement stmt = null;
        String queryUn = "SELECT Username, Password, UserID FROM Users WHERE Username = '" + username + "';";
        stmt = ConnectDb().createStatement();


        ResultSet rs = stmt.executeQuery(queryUn);

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
        System.out.println(validity);

        return validity;
    }

}