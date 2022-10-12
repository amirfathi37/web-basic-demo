package servlet;

import model.UserInfo;
import service.MyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            MyService service = new MyService();
            UserInfo userInfo = service.fetchUserData(req.getParameter("username"), req.getParameter("password"));
            if (userInfo != null) {
                req.getSession().setAttribute("userInfo", userInfo);
                String welcomMessage = createWelcomMessage(req.getParameter("username"));
                req.setAttribute("wlcMess", welcomMessage);
                req.getRequestDispatcher("/first.j" +
                        "sp").forward(req, resp);
            } else {
                req.setAttribute("loginMessage", "username or password is invalid!!!");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String createWelcomMessage(String username) {
        return "welcome dear " + username;
    }


}
