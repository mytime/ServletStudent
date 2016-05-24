package com.jkxy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jkxy.model.stuInfo;
import com.jkxy.service.stuInfoService;

/**
 * 查询所有学生信息
 */

public class queryAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public queryAllServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//获取url中的参数
		String osid = request.getParameter("osid");
		
		List<stuInfo> stus = new stuInfoService().queryAllStu();
		HttpSession session = request.getSession();
		//写出到session对象里
		session.setAttribute("stus", stus);
		
		if(osid.equals("query")){
			response.sendRedirect("../displaystuinfo.jsp");		
		}else if(osid.equals("delete")){			
			response.sendRedirect("../deleteStuInfo.jsp");
		}else if (osid.equals("modify")) {
			response.sendRedirect("../modifyStuInfo.jsp");
		}
		
		
	
	}

}
