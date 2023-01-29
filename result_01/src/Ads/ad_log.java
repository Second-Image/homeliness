package Ads;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ad_log", value = "/ad_log")
public class ad_log extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("aid");
        String pwd = request.getParameter("pwd");

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
            String sql="select * from admin where admin_id=?";
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1,id);

            ResultSet rs= ps.executeQuery();

            if(rs.next()){
                if(rs.getString("admin_pwd").equals(pwd)){

                    HttpSession s= request.getSession();
                    s.setAttribute("aid",id);

                    response.sendRedirect(request.getContextPath()+"/pages/AdminMain.jsp");//登入成功
                }else{
                    request.setAttribute("errorMessage","用户或密码错误");
                    request.getRequestDispatcher(request.getContextPath()+"/pages/AdminLogin.jsp").forward(request,response);//返回
                }
            }else {
                request.setAttribute("errorMessage","用户或密码错误");
                request.getRequestDispatcher(request.getContextPath()+"/pages/AdminLogin.jsp").forward(request,response);//返回
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
