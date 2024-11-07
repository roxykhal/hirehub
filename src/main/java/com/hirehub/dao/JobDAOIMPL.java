//provides actual implementations of methods declared in jobDAO file.

package com.hirehub.dao;
import com.hirehub.model.Job;
import com.hirehub.util.DatabaseConnection;
import java.sql.*;
//will import all sql classes 

import java.util.List;
//store and return list of job objects


public class JobDAOIMPL implements JobDAO {
    private Connection connection; //create instance of connection
    
    public JobDAOIMPL() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override //
    public void add(Job job) {
        String sql = "INSERT INTO jobs (title, description, requirements, posting_date, closing_date, status) VALUES (?, ?, ?, ?, ?, ?)"; //placeholder for those values as it cannot be hardcoded.
        try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, job.getTitle());
            pstmt.setString(2, job.getDescription());
            pstmt.setString(3, job.getRequirements());
            pstmt.setDate(4, new java.sql.Date(job.getPostingDate().getTime()));
            pstmt.setDate(5, new java.sql.Date(job.getClosingDate().getTime()));
            pstmt.setString(6, job.getStatus());

            pstmt.executeUpdate();

        }
        catch(SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Job job) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Job getByID(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByID'");
    }

    @Override
    public List<Job> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }


}