package com.sde.passwordmanager;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class myDB{
    private Connection conn;
    public myDB() {
        this.conn = null;
    }

    public static void main(String[] args) throws SQLException{
        //mydb.ConnectDb();
        //Authinticate("lll@hotmail.com","256488Lk");         //Wrong credentials, should return 0 or -1
       // Authinticate("mmmk@gmail.com","12345678");        //Correct credentials, should return userID>0
        //stmt.close();
    }

    //Connect to DB
    public void ConnectDb() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        conn = DriverManager.getConnection("jdbc:mysql://145.14.151.101:3306/u230725563_SDE", "u230725563_SDE", "Ahmadhamd2022");
            //Making sure DB is connected
                //System.out.println("Opened database successfully");
               // Statement stmt = conn.createStatement();

               /*String query = "select * from Users";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getString("Username"));
                    System.out.println(rs.getString("Password"));
                }*/
    }

    public int Authinticate(String username, String password) throws SQLException {
        int validity = 0;
        String queryUn = "SELECT Username, Password, UserID FROM Users\nWHERE Username = '" + username + "';";
        conn.setAutoCommit(false);
        Statement stmt = null;
        stmt = conn.createStatement();
        try (ResultSet rs = stmt.executeQuery(queryUn)) {
            while (rs.next()) {
                //System.out.println(rs.getString("Username"));
                if (rs.getString("Password").equals(password)) {
                    //validity is userID for correct credentials
                    validity = rs.getInt("UserID");
                } else {
                    //Wrong Password
                    validity = -1;
                }
            }
        }catch (SQLException E){
            throw new RuntimeException(E);
        }
        return validity;
    }

    public boolean Register(String username, String password, String pin) throws  SQLException{
        String query = "INSERT INTO u230725563_SDE.Users(Username, Password, pin) " +
                "VALUES ('" + username + "', '" + password + "', '" + pin + "');";
        Statement stmt = conn.createStatement();
        boolean registeringState = stmt.execute(query);
        return registeringState;
    }
}
