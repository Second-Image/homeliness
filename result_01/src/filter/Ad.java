package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Ad")
public class Ad implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse res=(HttpServletResponse)response;
        HttpSession s=req.getSession();

        String s1="";
        if (null!=s.getAttribute("aid")){
            s1=(String) s.getAttribute("aid");
        }

        if(s1.equals("")){
            ((HttpServletResponse) response).sendRedirect("/pages/AdminLogin.jsp");
        }else {
            chain.doFilter(request,response);
        }
    }
}
