package dataAccess;

import model.UserInfo;

import java.sql.*;

public class MyDAO {
    public UserInfo fetchUserData(String username, String password) throws ClassNotFoundException, SQLException {
        UserInfo userInfo = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@172.30.65.93:1521:testdb", "cid_glass", "cid_glass");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from TEST_USER t where t.USERNAME = '" + username + "' and t.PASSWORD = '" + password + "'");
        while (rs.next()) {
            userInfo = new UserInfo(rs.getString(2), rs.getString(2));
        }
        return userInfo;
    }
}
