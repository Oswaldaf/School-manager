package com.app.briefi.sclool_manager.IDBCongig;

import java.sql.Connection;
import java.sql.DriverManager;

import static javafx.scene.input.DataFormat.URL;

public interface IDBConfig {
    static  String host = "localhost";
    static String port = "3306";
    static String username = "root";
    static String password = "";
    static String database = "school_manager";
    static String URL = "jdbc:mysql://"+host+":"+port+"/"+database;

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, username, password);
        } catch (Exception e){
            return null;
        }
    }

}

