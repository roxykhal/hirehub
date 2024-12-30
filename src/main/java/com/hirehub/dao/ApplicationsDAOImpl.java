//provides actual implementations of methods declared in applicationsDAO file.
package com.hirehub.dao;
import com.hirehub.model.Applications;
import java.util.ArrayList;
import java.sql.*;
import java.sql.ResultSet;
import java.util.List;
import com.hirehub.util.DatabaseConnection;
import java.sql.Connection;


public class ApplicationsDAOImpl implements ApplicationsDAO {
    private Connection connection; //create instance of connection

    public ApplicationsDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }
    
}