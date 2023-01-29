package Ads;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "Add", value = "/Add")
public class Add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String name=request.getParameter("name");
        String price=request.getParameter("price");
        String num=request.getParameter("num");

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
            String sql="INSERT INTO goods (good_id, good_name, good_num, good_price) VALUES (?,?,?,?)";
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setString(3,price);
            ps.setString(4,num);

            ps.executeUpdate();


            ps.close();
            c.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        response.sendRedirect(request.getContextPath()+"/pages/AdminMain.jsp");
    }
}
