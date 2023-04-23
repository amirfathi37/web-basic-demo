package servlet;

import model.UserInfo;
import service.MyService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DataServlet extends HttpServlet {
    MyService service = new MyService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserInfo userInfo = service.fetchUserData(req.getParameter("uname"));
            req
                    .setAttribute("userLoginedInfo" , userInfo);
            req.getRequestDispatcher("showUser.jsp").forward(req , resp);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
