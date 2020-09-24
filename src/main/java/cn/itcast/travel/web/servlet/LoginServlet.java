package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String check = request.getParameter("check");
        if(((String)request.getSession().getAttribute("check1")).equalsIgnoreCase(check)){
            if (userService.loginUser(username,password) != null){
                System.out.println("登录成功！！");
                request.getRequestDispatcher("index.html").forward(request,response);
            }else{
                System.out.println("用户名或者密码出错");
                request.getRequestDispatcher("name_false.html").forward(request,response);
            }
        }else{
            System.out.println("验证码错误");
            request.getRequestDispatcher("check1_false.html").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
