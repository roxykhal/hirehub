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

    @Override
    public void add(Applications applications) {
        String sql = "INSERT INTO applications (job_id, candidate_id, application_date, status) VALUES (?, ?, ?, ?)";

        try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, applications.getjobID());
            pstmt.setInt(2, applications.getcandidateID());
            pstmt.setTimestamp(3, new Timestamp(applications.getapplicationDate().getTime())); //convert Date to Timestamp for sql
            pstmt.setString(4, applications.getStatus().name()); //convert enum to string

            pstmt.executeUpdate();

            try ResultSet
        }
    }
    
}int jobID, int candidateID, Date applicationDate, String stat