package cn.itcast.travel.web.servlet;


import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //读取注册的数据并加入至数据库
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String check = request.getParameter("check");
//		User user = new User(username,password,name,birthday,sex,telephone,email);
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setTelephone(telephone);
		user.setSex(sex);
		user.setBirthday(birthday);
		user.setEmail(email);
		System.out.println(sex);

			if(((String)request.getSession().getAttribute("check1")).equalsIgnoreCase(check)){
				if (userService.regist(user)){
					request.getRequestDispatcher("register_ok.html").forward(request,response);
				}else{
					request.getRequestDispatcher("name_occupy.html").forward(request,response);
				}

			}else{
				request.getRequestDispatcher("check_false.html").forward(request,response);
			}

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
		response.setCharacterEncoding("UTF-8");
    }
}
