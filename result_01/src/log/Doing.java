package log;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Doing", value = "/Doing")
public class Doing extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids=request.getParameterValues("ids");
        String[] nums=request.getParameterValues("nums");
        HttpSession s=request.getSession();
        s.setAttribute("ids",ids);
        s.setAttribute("nums",nums);

        PrintWriter out= response.getWriter();
        ArrayList<String> Ids=new ArrayList<>();
        ArrayList<Integer> Nums=new ArrayList<>();
        for(int i=0;i< ids.length;i++){
            int tmp;
            tmp=Integer.parseInt(nums[i]);
            if(tmp>0) {
                Ids.add(ids[i]);
                Nums.add(tmp);
            }
        }
        s.setAttribute("Ids",Ids);
        s.setAttribute("Nums",Nums);

        /*for(int i=0;i<Ids.size();i++){
            out.println(Ids.get(i)+"\t"+Nums.get(i));
        }
        out.println("end");*/
        response.sendRedirect(request.getContextPath()+"/pages/Paying.jsp");
    }
}
