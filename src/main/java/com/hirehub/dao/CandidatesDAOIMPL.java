//provides actual implementations of methods declared in candidatesDAO file.
package com.hirehub.dao;
import com.hirehub.model.Candidates;
import com.hirehub.util.DatabaseConnection;

import java.sql.*;
//will import all sql classes 

import java.util.List;
//store and return list of job objects


public class CandidatesDAOIMPL implements CandidatesDAO{
    private Connection connection;

    public CandidatesDAOIMPL() {
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

            pstmt.executeUpdate();

        }

        catch(SQLException e) {
            e.printStackTrace();
        }
    }

}


