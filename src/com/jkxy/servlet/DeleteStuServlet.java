package com.jkxy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jkxy.service.stuInfoService;

/**
 * 删除学生信息
 *
 */
public class DeleteStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id")) ;
		
		if(new stuInfoService().deleteStu(id)){
			response.sendRedirect("../delete_stu_success.jsp");
		}else{ 
			response.sendRedirect("../deleteStuInfo.jsp");
		}
	}
}
