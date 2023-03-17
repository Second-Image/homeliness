package Ads;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "Delete", value = "/Delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("good_id");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/autoseller";
        String user="root";
        String passwd="root";
        try {
            Connection c = DriverManager.getConnection(url,user,passwd);
            String sql="delete from goods where good_id=?";
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1,id);

            ps.executeUpdate();

            ps.close();
            c.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        response.sendRedirect(request.getContextPath()+"pages/AdminMain.jsp");

    }
}
