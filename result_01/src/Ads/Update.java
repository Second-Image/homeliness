package Ads;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "Update", value = "/Update")
public class Update extends HttpServlet {
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
            String sql="update goods set good_name=?,good_price=?,good_num=? where good_id=?";
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,price);
            ps.setString(3,num);
            ps.setString(4,id);

            ps.executeUpdate();


            ps.close();
            c.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/pages/AdminMain.jsp");
    }

}
