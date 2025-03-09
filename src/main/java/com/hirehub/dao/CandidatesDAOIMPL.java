//The DAO Impl class implements the methods from the DAO interface and provides the concrete logic for data access.
package com.hirehub.dao;
import com.hirehub.model.Candidates;
import com.hirehub.model.Enums;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import com.hirehub.util.DatabaseConnection;
import org.springframework.jdbc.core.RowMapper;
//store and return list of job objects


public class CandidatesDAOimpl implements CandidatesDAO {
    private Connection connection; //create instance of connection

    public CandidatesDAOimpl() {
        this.connection = DatabaseConnection.getConnection();
    }
    

    @Override
    //inserts a new candidate record into database
    public void add(Candidates candidates) {
        String sql = "INSERT INTO candidates (first_name, last_name, email, phone, resume_url, registration_date, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, candidates.getfirstName());
            pstmt.setString(2, candidates.getlastName());
            pstmt.setString(3, candidates.getemailAddress());
            pstmt.setString(4, candidates.getphoneNumber());
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
                return candidateRowMapper.mapRow(rs, 1);
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
                        candidates.add(candidateRowMapper.mapRow(rs, rs.getRow()));
                    } 
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                    return candidates;
            }

            @Override
            public void update(Candidates candidates){
                String sql = "UPDATE candidates SET first_name = ?, last_name = ?, email_address = ?, phone_number = ?, resume_url = ?, status = ?" + "WHERE candidate_id = ? ";

                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setString(1, candidates.getfirstName());
                    pstmt.setString(2, candidates.getlastName());
                    pstmt.setString(3, candidates.getemailAddress());
                    pstmt.setString(4, candidates.getresumeURL());
                    pstmt.setInt(5, candidates.getId());
                    pstmt.setString(6, candidates.getStatus());
                    pstmt.setString(7, candidates.getphoneNumber());
                    
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
                        return candidateRowMapper.mapRow(rs, rs.getRow());
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
                        return candidateRowMapper.mapRow(rs, rs.getRow());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
        
            }

            private RowMapper<Candidates> candidateRowMapper = new RowMapper<Candidates>() {
                @Override
                public Candidates mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Candidates candidates = new Candidates();
                    candidates.setId(rs.getInt("candidate_id"));
                    candidates.setfirstName("first_name");
                    candidates.setlastName("last_name");
                    candidates.setemailAddress("email_address");
                    candidates.setresumeURL("resume_url");
                    candidates.setphoneNumber("phone_number");
                    candidates.setStatus("candidate_status");
                    
                    return candidates;
                               
                }
            };

            
         }
    


