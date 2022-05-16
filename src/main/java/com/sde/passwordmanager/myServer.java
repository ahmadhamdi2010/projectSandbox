package com.sde.passwordmanager;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.DriverManager.*;

public class myServer {
    static Connection conn;
    public static void ConnectDb() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager
                    .getConnection("jdbc:mysql://145.14.151.101:3306/u230725563_SDE", "u230725563_SDE", "Ahmadhamd2022");

            //Making sure DB is connected
            if (conn != null) {
                System.out.println("Opened database successfully");
                Statement stmt = null;
                stmt = conn.createStatement();

                String query = "select * from Users";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getString("Username"));
                    System.out.println(rs.getString("Password"));
                }
            }
        }catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            }
         catch (ClassNotFoundException ex) {
            Logger.getLogger(myServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws SQLException {
        ConnectDb();


    }
}