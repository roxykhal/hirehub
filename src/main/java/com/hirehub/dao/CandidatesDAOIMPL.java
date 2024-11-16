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
            pstmt.setString(6, candidates.getStatus());
            pstmt.setDate(7, new java.sql.Date(candidates.getregistrationDate().getTime()));

            
            //insert statement, db generates key for new inserted row
            pstmt.executeUpdate();

            //get generated ID using try with resources - ensures resultSet is closed auto once block is done

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                //if key was generated
                if (generatedKeys.next()) {
                    //sets the generated ID onto entity object, candidate object now has id populated
                    candidates.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating candidate failed, no ID obtained.");
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
                return extractCandidatesFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
        return null;
        }

        @Override
        //retrieves a list of all candidates
        public List<Candidates> getAll() {
            List<Candidates>candidates = new ArrayList<>();


           // List<Candidates>candidates = new ArrayList<>();
            String sql = "SELECT * FROM candidates ORDER BY registration_date DESC";

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
            public void update(Candidates candidates){
                String sql = "UPDATE candidates SET first_name = ?, last_name = ?, email_address = ?, phone_number = ?, resume_url = ?, status = ? " + "WHERE candidate_id = ? ";

                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setString(1, candidates.getfirstName());
                    pstmt.setString(2, candidates.getlastName());
                    pstmt.setString(3, candidates.getemailAddress());
                    pstmt.setString(4, candidates.getresumeURL());
                    pstmt.setInt(5, candidates.getId());
                    pstmt.setString(6, candidates.getStatus());
                    pstmt.setInt(7, candidates.getphoneNumber());

                    pstmt.executeUpdate();
                }catch(SQLException e) {
                    e.printStackTrace();
                } 
            }

            @Override
            public void delete(int id) {
                String sql = "DELETE FROM candidates where candidate_id = ?";

                try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setInt(1, id);
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public Candidates getByEmail(String email) {
                String sql = "SELECT * FROM candidates WHERE email = ?";

                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setString(1, email);
                    ResultSet rs = pstmt.executeQuery();
                    
                    if (rs.next()) {
                        return extractCandidatesFromResultSet(rs);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            public Candidates getByStatus(String status) {
                String sql = "SELECT * FROM candidates WHERE status = ?";

                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setString(1, status);
                    //executes sql query and returns the results as a ResultSet object (rs)
                    ResultSet rs = pstmt.executeQuery();

                    //if matching candidate found, it maps the results to a candidates object using the extract method
                    if (rs.next()) {
                        return extractCandidatesFromResultSet(rs);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
        
            }

            
            //Helper method used to Convert ResultSet row into a Candidates object
            private Candidates extractCandidatesFromResultSet(ResultSet rs) throws SQLException {
                // Create a new Candidates object
                    Candidates candidates = new Candidates();
                    
                    // Populate the Candidate object with values from the ResultSet
                    candidates.setId(rs.getInt("candidate_id"));
                    candidates.setfirstName(rs.getString("firstName"));
                    candidates.setlastName(rs.getString("lastName"));
                    candidates.setemailAddress(rs.getString("emailAddress"));
                    candidates.setphoneNumber(rs.getInt("phoneNumber")); 
                    candidates.setresumeURL(rs.getString("resumeURL"));
                    candidates.setStatus(rs.getString("status"));
                    candidates.setregistrationDate(rs.getDate("registrationDate")); 
                    
                    return candidates;  // Return the populated Candidates object
                }


        }
    


