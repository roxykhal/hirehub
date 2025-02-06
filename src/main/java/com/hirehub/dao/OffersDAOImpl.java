
package com.hirehub.dao;
import com.hirehub.model.Offers;
import com.hirehub.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OffersDAOImpl implements OffersDAO {

    private Connection connection;

    public OffersDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }


    @Override
    public void add(Offers offers) {
        String sql = "INSERT INTO offers (offer_id, application_id, salary, start_date, status) VALUES (?, ?, ?, ?, ?)  ";
        try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, offers.getofferID());
            pstmt.setString(2, offers.getstatus());
            pstmt.setInt(3, offers.getapplicationID());
            pstmt.setDate(4, new java.sql.Date(offers.getstartDate().getTime()));
            pstmt.setBoolean(5, offers.getsalary());

    pstmt.executeUpdate();

    }

    catch(SQLException e) {
        e.printStackTrace();
    }

     }
        
    

    @Override
    public void update(Offers offers) {
        String sql = "UPDATE offers SET offer_id = ?, application_id = ?, salary = ?, start_date = ?, status = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, offers.getofferID());
            pstmt.setString(2, offers.getstatus());
            pstmt.setInt(3, offers.getapplicationID());
            pstmt.setDate(4, new java.sql.Date(offers.getstartDate().getTime()));
            pstmt.setBoolean(5, offers.getsalary());

    pstmt.executeUpdate();

    }
    catch(SQLException e) {
        e.printStackTrace();
    }


    }

    @Override
    public void delete(Offers offers) {
        String sql = "DELETE FROM offers WHERE offer_id = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        pstmt.setInt(1, offers.getofferID());

    pstmt.executeUpdate();

    }
    catch(SQLException e) {
        e.printStackTrace();
    }


       }

    @Override
    public Offers getByID(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByID'");
    }

    @Override
    public List<Offers> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }


    
    
}