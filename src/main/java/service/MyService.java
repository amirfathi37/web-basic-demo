package service;

import dataAccess.MyDAO;
import model.UserInfo;

import java.sql.SQLException;

public class MyService {
    private static MyDAO myDAO = new MyDAO();

    public UserInfo fetchUserData(String username, String password) throws SQLException, ClassNotFoundException {
        return myDAO.fetchUserData(username, password);
    }

    public UserInfo fetchUserData(String username) throws SQLException, ClassNotFoundException {
        return myDAO.fetchUserData(username);
    }
}
