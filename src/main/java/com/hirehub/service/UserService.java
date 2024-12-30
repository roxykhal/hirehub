package com.hirehub.service;
import com.hirehub.dao.UsersDAO;
import com.hirehub.dao.UsersDAOIMPL;
import com.hirehub.model.Users;
import java.util.List;

public class UserService {
    private UsersDAO usersDAO;

    public UserService() {
        this.usersDAO = new UsersDAOIMPL();

    }

    public void CreateUsers(Users users) {
        usersDAO.add(users);
    }

    public void UpdateUsers(Users users) {
        usersDAO.update(users);
    }

    public void DeleteUsers(Users users) {
        usersDAO.delete(0);
    }

    public void getUsersID(Users users) {
        usersDAO.getuserId(0);
    }

    public List<Users>getAllUsers() {
        return usersDAO.getAll();
    }












    
}
