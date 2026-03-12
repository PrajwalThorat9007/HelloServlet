import java.io.*;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ViewUsersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>User List</h2>");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/userdb",
                    "root",
                    "Root@123"
            );

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from users");

            out.println("<table border=1>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Email</th>");
            out.println("<th>Gender</th>");
            out.println("<th>Country</th>");
            out.println("</tr>");

            while (rs.next()) {

                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("gender") + "</td>");
                out.println("<td>" + rs.getString("country") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}