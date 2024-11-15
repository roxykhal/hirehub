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
    //inserts a new candidate record into database
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
                } else {
                    throw new SQLException("Creatin=g candidate failed, no ID obtained.");
                }
            }

        }
        catch(SQLException e) {
            e.printStackTrace();
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

        @Override
        public List<Candidates> getAll() {
            List<Candidates>candidates = new ArrayList<>();
            String sql = "SELECT * FROM candidates ORDER BY regristration_date DESC";

            try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

                    while(rs.next()) {
                        candidates.add(extractCandidatesFromResultSet(rs));
                    } 
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                    return candidates;
            }

            @Override
            
            

       //helper method to create entity from result set
       
        private Candidates extractCandidatesFromResultSet(ResultSet rs) throws SQLException {
            Candidates candidates = new Candidates();
            candidates.setId(rs.getInt("id"));
            candidates.setfirstName(rs.getString("first_name"));
            candidates.setlastName((rs.getString("last_name")));
            candidates.setemailAddress(rs.getString("email_address"));
            candidates.setphoneNumber(rs.getInt("phone_number"));
            candidates.setresumeURL(rs.getString("resume_url"));
            candidates.setregistrationDate(rs.getDate("registration_date"));
            return candidates;

        }


}

