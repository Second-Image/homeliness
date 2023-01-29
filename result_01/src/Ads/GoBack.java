package Ads;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GoBack", value = "/GoBack")
public class GoBack extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession s=request.getSession();
            s.removeAttribute("aid");
            response.sendRedirect(request.getContextPath()+"/pages/Main.jsp");
    }
}
