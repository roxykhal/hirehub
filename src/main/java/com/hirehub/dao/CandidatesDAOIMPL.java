//provides actual implementations of methods declared in candidatesDAO file.
package com.hirehub.dao;
import com.hirehub.model.Candidates;
import com.hirehub.util.DatabaseConnection;
import java.util.ArrayList;
import java.sql.*;
//will import all sql classes 

import java.util.List;
//store and return list of job objects


public class CandidatesDAOimpl implements CandidatesDAO {
    private Connection connection; //create instance of connection
    
    public CandidatesDAOimpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void add(Candidates candidates) {
        String sql = "INSERT INTO candidates (firstName, lastName, emailAddress, phoneNumber, resumeURL, registrationDate) VALUES (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, candidates.getfirstName());
            pstmt.setString(2, candidates.getlastName());
            pstmt.setString(3, candidates.getemailAddress());
            pstmt.setInt(4, candidates.getphoneNumber());
            pstmt.setString(5, candidates.getresumeURL());
            pstmt.setDate(6, new java.sql.Date(candidates.getregistrationDate().getTime()));

            
            //insert statement, db generates key for new inserted row
            pstmt.executeUpdate();

            //get generated ID using try with resources - ensures resultSet is closed auto once block is done

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                //if key was generated
                if (generatedKeys.next()) {
                    //sets the generated ID onto entity object, candidate object now has id populated
                    candidates.setId(generatedKeys.getInt(1));
                }

        }

        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    }

    @Override
    public Candidates getId(int id) {
        String sql = "SELECT * FROM candidates WHERE id = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractCandidatesFromResultSet (rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
        return null;
        }

        private Candidates extractCandidatesFromResultSet(ResultSet rs) throws SQLException {
            Candidates candidates = new Candidates();
            candidates.setId(rs.getInt("id"));



    
        
        
        
        
        }












}
}
