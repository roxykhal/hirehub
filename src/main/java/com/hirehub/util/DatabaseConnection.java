package com.hirehub.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



//contains helper classes, code to connect to database. 

public class DatabaseConnection {
    private static Connection connection = null;

    //check connection is established
    public static Connection getConnection() { //static so we can directly access the class without creating an object
        if (connection != null) {
            return connection;
        } else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream( "database.properties");
                prop.load(inputStream);

                String dbDriver = "com.mysql.cj.jdbc.Driver";
                String dbURL = prop.getProperty("db.url"); 
                String dbUser = prop.getProperty("db.user");
                String dbPassword = prop.getProperty("db.password");

                Class.forName(dbDriver); //loads class with name specified in dbdriver

                  connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            } catch (ClassNotFoundException | SQLException | IOException e) {
                e.printStackTrace();
            }
            return connection;

        }
        
    }
}

