package com.hirehub.dao;
import com.hirehub.model.Communications;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import com.hirehub.util.DatabaseConnection;


//provides actual implementations of methods declared in communicationsDAO file.

    public class CommunicationsDAOImpl implements CommunicationsDAO {
    private Connection connection; //create instance of connection

    public CommunicationsDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

     @Override
    public void add(Communications communications) {
        String sql = "INSERT INTO communications (application_id, sender_id, recipient_id, type, message, sent_date) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, communications.getapplicationID());
            pstmt.setInt(2, communications.getsenderID());
            pstmt.setInt(3, communications.getrecipientID());
            pstmt.setString(4, communications.getmessage());
            pstmt.setTimestamp(5, new Timestamp(communications.getsentDate().getTime()));
            pstmt.setString(6, communications.gettype());

            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    communications.setapplicationID(generatedKeys.getInt(1));  // Set the generated ID
                } else {
                    throw new SQLException("Creating communication failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Communications communications) {
        String sql = "UPDATE communications SET application_id = ?, sender_id = ?, recipient_id = ?, message = ?, sent_date = ?, type = ? WHERE application_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, communications.getapplicationID());
            pstmt.setInt(2, communications.getsenderID());
            pstmt.setInt(3, communications.getrecipientID());
            pstmt.setString(4, communications.getmessage());
            pstmt.setTimestamp(5, new Timestamp(communications.getsentDate().getTime()));
            pstmt.setString(6, communications.gettype());
            pstmt.setInt(7, communications.getapplicationID());  // using application_id for the WHERE clause

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Communications communications) {
        String sql = "DELETE FROM communications WHERE comunication_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, communications.getapplicationID());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Communications getByID(int applicationID) {
        String sql = "SELECT * FROM communications WHERE application_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, applicationID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return extractCommunicationsFromResultSet(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Communications> getAll() {
        List<Communications> communicationsList = new ArrayList<>();
        String sql = "SELECT * FROM communications";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                communicationsList.add(extractCommunicationsFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return communicationsList;
    }

    // Helper method to convert a ResultSet row into a Communications object
    private Communications extractCommunicationsFromResultSet(ResultSet rs) throws SQLException {
        Communications communications = new Communications();

        communications.setapplicationID(rs.getInt("application_id"));
        communications.setsenderID(rs.getInt("sender_id"));
        communications.setrecipientID(rs.getInt("recipient_id"));
        communications.setmessage(rs.getString("message"));
        communications.setsendDate(rs.getTimestamp("sent_date"));
        communications.settype(rs.getString("type"));

        return communications;
    }
}
    

