package com.hirehub.dao;
import com.hirehub.model.Communications;
import java.util.ArrayList;
import java.sql.*;
import java.sql.ResultSet;
import java.util.List;
import com.hirehub.util.DatabaseConnection;
import java.sql.Connection;


//provides actual implementations of methods declared in communicationsDAO file.

    public class CommunicationsDAOImpl implements CommunicationsDAO {
    private Connection connection; //create instance of connection

    public CommunicationsDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }
    
}
