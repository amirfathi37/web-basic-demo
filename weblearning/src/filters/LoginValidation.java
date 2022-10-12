package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebFilter("/login")
public class LoginValidation implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Connection connection = null;
        Statement statement = null;
        System.out.println();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@172.30.65.93:1521:testdb", "cid_glass", "cid_glass");
            statement = connection.createStatement();
            String username = request.getParameter("username");
            ResultSet rs = statement.executeQuery("select MAX(ll.PK_TEST_USER_LOG) from test_user_log ll ");
            rs.next();
            long pkValue = rs.getLong(1);
            statement.executeUpdate("insert into test_user_log l (PK_TEST_USER_LOG ,FK_TEST_USER) values (" + pkValue+1 + " ,'" + username + "' )");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/error.jsp");
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
