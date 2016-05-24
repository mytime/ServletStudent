package com.jkxy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jkxy.model.stuInfo;
import com.jkxy.service.stuInfoService;
/**
 * 显示一个学生的信息在Form表单中
 */
public class modifyOneStuServlet extends HttpServlet {

	private static final long serialVersionUID = 4699485474847288721L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		stuInfo stu = new stuInfoService().queryStuById(id);
		HttpSession session = request.getSession();
		session.setAttribute("stu", stu);
		response.sendRedirect("../modifyOneStu.jsp");
	}

}
