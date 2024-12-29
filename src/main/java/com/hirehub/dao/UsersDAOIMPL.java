package com.hirehub.dao;
import com.hirehub.model.Users;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import com.hirehub.util.DatabaseConnection;


public class UsersDAOIMPL implements UsersDAO {

    private Connection connection; 

    public UsersDAOIMPL() {
        this.connection = DatabaseConnection.getConnection();
    
    }

    @Override
    public void add(Users users) {
        String sql = "INSERT INTO USERS (userName, password, role, email) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, users.getuserName());
            pstmt.setString(2, users.getpassword());
            pstmt.setString(3, users.getrole());
            pstmt.setString(4, users.getemail());

            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                //if key was generated
                if (generatedKeys.next()) {
                    //sets the generated ID onto entity object, candidate object now has id populated
                    users.setuserId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void update(Users users) {
        String sql = "UPDATE users SET userName = ?, password = ?, role = ?, email = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, users.getuserId());
            pstmt.setString(2, users.getuserName());
            pstmt.setString(3, users.getpassword());
            pstmt.setString(4, users.getrole());
            pstmt.setString(5, users.getemail());

            pstmt.executeUpdate(); 

        } catch (SQLException e) {
            e.printStackTrace();

        }

        }
    

    @Override
    public void delete(int userId) {
        String sql = "DELETE from USERS where user_id = ? ";
       
       try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setInt(1, userId);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }


}

    @Override
    public List<Users> getAll() {
        List <Users>users = new ArrayList<>();

        String sql = "SELECT * FROM users ";

        try (Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()) {
                users.add(extractUsersFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


                return users;
    }

    @Override
    public Users getuserId(int id) {
        String sql = "SELECT * FROM users WHERE user_id = ? ";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractUsersFromResultSet(rs);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                
                    }
                    return null;
                }
            

    //Helper method used to Convert ResultSet row into a users object
    private Users extractUsersFromResultSet(ResultSet rs) throws SQLException {
        // Create a new users object
            Users users = new Users();
            
            // Populate the user object with values from the ResultSet
            users.setuserId(rs.getInt("user_id"));
            users.setuserName(rs.getString("user_name"));
            users.setpassword(rs.getString("password"));
            users.setrole(rs.getString("role"));
            users.setemail(rs.getString("email"));
            
            return users;  // Return the populated user object
        }
    }



