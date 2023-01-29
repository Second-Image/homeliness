package log;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

@WebServlet(name = "log", value = "/log")
public class log extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s=request.getSession();
        ArrayList<String> Ids=(ArrayList<String>) s.getAttribute("Ids");
        ArrayList<Integer> Nums=(ArrayList<Integer>) s.getAttribute("Nums");
        //价格
        double sum=0;
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
            String update="UPDATE goods SET good_num = ? WHERE good_id = ?";
            String select="select good_num,good_price from goods where good_id=?";

            PreparedStatement ss=c.prepareStatement(select);
            PreparedStatement us=c.prepareStatement(update);

            ResultSet rs;

            for(int i=0;i<Ids.size();i++) {
                ss.setString(1,Ids.get(i));

                rs=ss.executeQuery();
                rs.next();

                int num=Integer.parseInt(rs.getString("good_num"));
                //计算总价格
                double tmp_price=Double.parseDouble(rs.getString("good_price"));
                sum+=Nums.get(i)*tmp_price;

                num=num-Nums.get(i);
                us.setString(1,""+num);
                us.setString(2,Ids.get(i));
                us.executeUpdate();
            }
            /* 生成id算法 ymdhm(共12位时间)+8位数字*/
            String id="";
            //时间
            Calendar cal=Calendar.getInstance();
            id +=cal.get(Calendar.YEAR);
            if((cal.get(Calendar.MONTH)+1)>9)
                id +=(cal.get(Calendar.MONTH)+1);
            else
                id +="0"+(cal.get(Calendar.MONTH)+1);
            if(cal.get(Calendar.DATE)>9)
                id +=(cal.get(Calendar.DATE));
            else
                id+="0"+cal.get(Calendar.DATE);
            if(cal.get(Calendar.HOUR_OF_DAY)>9) // 获取当前小时数（24 小时制）
                id +=cal.get(Calendar.HOUR_OF_DAY);
            else
                id+="0"+cal.get(Calendar.HOUR_OF_DAY);
            if(cal.get(Calendar.MINUTE)>9)  // 获取当前分钟
                id +=cal.get(Calendar.MINUTE);
            else
                id+="0"+cal.get(Calendar.MINUTE);
            //数字
            String nn="";
            select="select Order_Id from Log order by Order_Id Desc";
            ss=c.prepareStatement(select);
            rs=ss.executeQuery();
            //如果没数从1开始，否则从已有编号最大开始
            if(rs.next()){
                nn=rs.getString("Order_Id");
                nn=nn.substring(12);
                int tmp_int=Integer.parseInt("1"+nn);
                tmp_int++;
                nn=""+tmp_int;
                nn=nn.substring(1);
            }else{
                nn="00000001";
            }
            id=id+nn;
            /* info编码算法:内容 : id-num--id-num--...  */
            String info="";

            for(int i=0;i<Ids.size();i++){
                info +=Ids.get(i)+"-"+Nums.get(i);
                if((i+1)!=Ids.size())
                    info+="--";
            }
            /*价格*/
            String price=""+sum;
            //插入
            String insert="INSERT INTO log (`Order_Id`, `Order_Info`, `Price`) VALUES (?, ?, ?)";
            PreparedStatement ps=c.prepareStatement(insert);

            ps.setString(1,id);
            ps.setString(2,info);
            ps.setString(3,price);

            ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/pages/payed.jsp");
    }
}
