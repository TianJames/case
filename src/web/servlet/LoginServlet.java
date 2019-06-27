package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String checkcode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        //验证验证码是否正确
        if (!checkcode.equalsIgnoreCase(checkCode)){
            //验证码错误
            request.setAttribute("login_msg","验证码输入有误！");
            request.getRequestDispatcher("/Login.jsp").forward(request,response);
            return;
        }else {
            //验证码正确
            User user= new User();
            Map<String, String[]> map = request.getParameterMap();
            try {
                BeanUtils.populate(user,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            UserService us = new UserServiceImpl();
            User login = us.Login(user);
            if (login==null){
                //用户名或密码错误
                request.setAttribute("login_msg","用户名或密码输入有误！");
                request.getRequestDispatcher("/Login.jsp").forward(request,response);
                return;
            }else {
                //输入成功
                session.setAttribute("user",login);
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
