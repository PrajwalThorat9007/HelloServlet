import java.io.*;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/userdb",
                    "root",
                    "Root@123"
            );

            PreparedStatement ps = con.prepareStatement(
                    "select * from users where email=? and password=?"
            );

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                out.println("<h2>Login Successful</h2>");
                out.println("Welcome " + rs.getString("name"));

            } else {

                out.println("<h2>Invalid Email or Password</h2>");

            }

            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}