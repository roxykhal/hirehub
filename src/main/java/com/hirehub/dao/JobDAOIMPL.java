//provides actual implementations of methods declared in jobDAO file.

package com.hirehub.dao;
import com.hirehub.model.Job;
import com.hirehub.util.DatabaseConnection;
import java.sql.*;
//will import all sql classes 
import java.util.ArrayList;
import java.util.List;
//store and return list of job objects


public class JobDAOIMPL implements JobDAO {
    private Connection connection; //create instance of connection

     public void jobDAOimpl() {
        this.connection = DatabaseConnection.getConnection();
    }


    @Override //

    public void add(Job job) {
        String sql = "INSERT INTO jobs (title, description, requirements, posting_date, closing_date, status, id) VALUES (?, ?, ?, ?, ?, ?, ?)"; //placeholder for those values as it cannot be hardcoded.
        try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, job.getTitle());
            pstmt.setString(2, job.getDescription());
            pstmt.setString(3, job.getRequirements());
            pstmt.setDate(4, new java.sql.Date(job.getPostingDate().getTime()));
            pstmt.setDate(5, new java.sql.Date(job.getClosingDate().getTime()));
            pstmt.setString(6, job.getStatus().name());
            pstmt.setInt(7, job.getId());

            pstmt.executeUpdate();

        }
        catch(SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void update(Job job) {
       String sql = "UPDATE jobs SET title = ?, description = ?, requirements = ?, posting_date = ?, closing_date = ?, id = ?";

       try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, job.getTitle());
        pstmt.setString(2, job.getDescription());
        pstmt.setString(3, job.getRequirements());
        pstmt.setString(4, job.getStatus());
        pstmt.setInt(5, job.getId());
        //pstmt.setDate(1, job.getPostingDate());
        //pstmt.setDate(1, job.getClosingDate());

        pstmt.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        String sql = "DELETE FROM CANDIDATES WHERE job_id = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Job getId(int id) {
        String sql = "SELECT * FROM jobs WHERE JOB_ID = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractJobFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
        return null;
        }
    

    @Override
    public List<Job> getAll() {

        List<Job>job = new ArrayList<>();

        String sql = "SELECT * FROM job ORDER BY registration_date DESC";

        try (Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                job.add(extractJobFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return job;
    }

    private Job extractJobFromResultSet(ResultSet rs) throws SQLException {

        Job job = new Job();

        job.setId(rs.getInt("job_id"));
        job.setTitle(rs.getString("title"));
        job.setStatus(rs.getString("status"));
        job.setDescription((rs.getString("description")));
        job.setRequirements(rs.getString("requirements"));
        job.setPostingDate(rs.getDate("posting_date"));
        job.setClosingDate(rs.getDate("closing_date"));


        return job;
    }


    }




