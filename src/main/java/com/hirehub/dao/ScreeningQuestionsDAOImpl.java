//provides actual implementations of methods declared in screeningQuestionsDAO file.
package com.hirehub.dao;
import com.hirehub.model.ScreeningQuestions;
import com.hirehub.util.DatabaseConnection;
import java.sql.*;


public class ScreeningQuestionsDAOImpl implements ScreeningQuestionsDAO{

    private Connection connection;

    public ScreeningQuestionsDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void add(ScreeningQuestions screeningQuestions) {
        String sql = "INSERT INTO screening questions (job_id, screening_questions) VALUES (?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, screeningQuestions.getjobID());
            pstmt.setString(2, screeningQuestions.gettext());
    
    pstmt.executeUpdate();

    }

    catch(SQLException e) {
        e.printStackTrace();
    }

     }
        

    @Override
    public void update(ScreeningQuestions screeningQuestions) {
        String sql = "UPDATE screening_questions SET jod_id = ?, screening_questions = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, screeningQuestions.getjobID());
            pstmt.setString(2, screeningQuestions.gettext());

            pstmt.executeUpdate();

    }
    catch(SQLException e) {
        e.printStackTrace();
    }

     }
        

    @Override
    public void delete(ScreeningQuestions screeningQuestions) {
        String sql = "DELETE FROM screening_questions WHERE job_id = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, screeningQuestions.getjobID());
            pstmt.setString(2, screeningQuestions.gettext());

            pstmt.executeUpdate();

    }
    catch(SQLException e) {
        e.printStackTrace();
    }
    }

    @Override
    public getByID(int id) {
        String sql = "SELECT * FROM screening_questions WHERE job_id = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractScreeningQuestionsFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
        return null;
        }
    }

    

    
     

        
    

    
    



