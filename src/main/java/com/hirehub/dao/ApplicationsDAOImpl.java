//provides actual implementations of methods declared in applicationsDAO file.
package com.hirehub.dao;
import com.hirehub.model.Applications;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import com.hirehub.util.DatabaseConnection;


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

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if(generatedKeys.next()) {
                    applications.setjobID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating application failed, no ID obtained")
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int applicationID) {
        String sql = "DELETE FROM applications when application_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, applicationID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Applications applications) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Applications getByID(int applicationID) {
        String sql = "SELECT * FROM applications WHERE application_id = ?";

        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, applicationID);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                return extractApplicationFromResultSet(rs); 
            }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        
    }

    @Override
    public List<Applications> getAll() {
        
    }

    private Applications extractApplicationFromResultSet(ResultSet rs) throws SQLException {
        Applications application = new Applications();
    
        application.setjobID(rs.getInt("job_id"));
        application.setcandidateID(rs.getInt("candidate_id"));
        application.setapplicationDate(rs.getTimestamp("application_date"));
        application.setStatus(rs.getString("status")); 
    
        return application;
    }
    
