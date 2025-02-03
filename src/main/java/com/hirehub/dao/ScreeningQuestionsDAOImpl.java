//provides actual implementations of methods declared in screeningQuestionsDAO file.
package com.hirehub.dao;
import com.hirehub.util.DatabaseConnection;
import java.sql.*;


public class ScreeningQuestionsDAOImpl implements ScreeningQuestionsDAO{

    private Connection connection;

    public ScreeningQuestionsDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void add(ScreeningQuestions screeningQuestions) {
        String sql = "INSERT INTO screening questions (job_id, )"
    }
    
}


