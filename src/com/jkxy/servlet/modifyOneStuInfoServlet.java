package com.jkxy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jkxy.model.stuInfo;
import com.jkxy.service.stuInfoService;

/**
 * 提交修改后的学生信息
 */

public class modifyOneStuInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取表单数据
		request.setCharacterEncoding("utf-8"); // 强制编码
		int id = Integer.parseInt(request.getParameter("id"));
		String nicheng = request.getParameter("nicheng");
		String truename = request.getParameter("truename");
		byte xb = Byte.parseByte(request.getParameter("xb"));
		String csrq = request.getParameter("csrq");
		String zy = request.getParameter("zy");
		String kcs[] = request.getParameterValues("kc"); // 数组
		String xqs[] = request.getParameterValues("xq"); // 数组
		String bz = request.getParameter("bz");

		// 给学生信息对象赋值
		stuInfo stu = new stuInfo();
		stu.setId(id);
		stu.setNicheng(nicheng);
		stu.setTruename(truename);
		stu.setXb(xb);
		stu.setCsrq(csrq);
		if (csrq.equals("")) {
			stu.setCsrq(null);
		}
		stu.setZy(zy);
		if (kcs != null) {
			stu.setKc(kcs);
		}
		if (xqs != null) {
			stu.setXq(xqs);
		}
		stu.setBz(bz);
		//执行修改
		if (new stuInfoService().updateStu(stu)) {
			response.sendRedirect("../modifyOneStu_success.jsp");
		} else {
			response.sendRedirect("../modifyOneStu.jsp");
		}

	}

}
