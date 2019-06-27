package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();
        if (uri.contains("Login/jsp") ||uri.contains("/LoginServlet") || uri.contains("/CheckCode")||uri.contains("/js/")||uri.contains("/fonts/")||uri.contains("/css/")){
            chain.doFilter(req, resp);
        }else{
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                chain.doFilter(req, resp);
            }else{
                request.setAttribute("login_msg","您还未登录，请登录");
                request.getRequestDispatcher("/Login.jsp").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
