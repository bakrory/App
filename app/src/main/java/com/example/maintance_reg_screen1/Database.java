package com.example.maintance_reg_screen1;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    Connection conn=null;
    public Connection ConnectDB()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:jtds:sqlserver://sql5002.site4now.net/DB_A4AD6A_AppAndroid","DB_A4AD6A_AppAndroid_admin","abc@1234");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }


    // Using for insert or update or delete
    public String RunDML(String st)
    {
        Statement omar= null;
        try {
            omar = conn.createStatement();
            omar.executeUpdate(st);
            return  "Ok";

        } catch (SQLException e) {
            return e.getMessage();

        }




    }


    public ResultSet RunSearch(String st)
    {
        ResultSet rs=null;
        try {
            Statement statement=conn.createStatement();
            rs=statement.executeQuery(st);


        } catch (SQLException e) {
            e.printStackTrace();
        }
            return rs;

    }
}
