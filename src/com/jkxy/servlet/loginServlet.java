package com.jkxy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jkxy.model.userTable;
import com.jkxy.service.userService;


/**
 * 判断登陆用户合法性
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//实例化一个用户对象
		userTable user = new userTable();
		user.setUsername(username);
		user.setPassword(password);
		
		//验证用户和密码是否存在
		if (new userService().valiUser(user)) {
			//user信息写入session
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("../main.jsp");
		}else{
			response.sendRedirect("../index.jsp");
		}
		
	}

}
