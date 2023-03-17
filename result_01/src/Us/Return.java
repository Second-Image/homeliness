package Us;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Return", value = "/Return")
public class Return extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s=request.getSession();
        s.removeAttribute("Ids");
        s.removeAttribute("Nums");
        response.sendRedirect(request.getContextPath()+"/pages/User.jsp");
    }
}
