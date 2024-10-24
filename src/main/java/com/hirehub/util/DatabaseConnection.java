//contains helper classes, code to connect to database. 

import java.sql.Connection;
import java.sql.DriveManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection = null;

    //check connection is established
    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream(name: "database.properties");
                prop.load(inputStream);

                String dbDriver = "com.mysql.cj.jdbc.Driver";
                String dbURL = prop.getProperty(key:"db.url"); 
                String dbUser = prop.getProperty(key:"db.user");
                String dbPassword = prop.getProperty(key:"db.password");

                Class.forName(dbDriver); //loads class with name specified in dbdriver

                connection = DriverManager.getConnection(dbURL, dbUser, dbPassword); //connecting to database

            } catch(SQLException) {
                e.printStackTrace();

            }
            return connection;

        }
        
    }

}