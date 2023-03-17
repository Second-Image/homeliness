package Us;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "toMian", value = "/toMian")
public class toMian extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s=request.getSession();
        s.removeAttribute("Ids");
        s.removeAttribute("Nums");
        s.removeAttribute("ids");
        s.removeAttribute("nums");
        response.sendRedirect(request.getContextPath()+"/pages/Main.jsp");
    }
}
