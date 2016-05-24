package com.jkxy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jkxy.model.stuInfo;
import com.jkxy.service.stuInfoService;

/**
 *  把表单数据写入到数据库
 */

public class inputStuInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 5553472170988504126L;

	public inputStuInfoServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取表单数据
		request.setCharacterEncoding("utf-8"); //强制编码
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
		stu.setNicheng(nicheng);
		stu.setTruename(truename);
		stu.setXb(xb);
		stu.setCsrq(csrq);
		if (csrq.equals("")) {
			stu.setCsrq(null);
		}
		stu.setZy(zy);
		if(kcs != null){
			stu.setKc(kcs);
		}
		if (xqs != null) {
			stu.setXq(xqs);
		}		
		stu.setBz(bz);
		if(new stuInfoService().addStu(stu)){
			response.sendRedirect("../inputStuInfo_success.jsp");
		}else{
			response.sendRedirect("../inputstuinfo.jsp");
		}	

	}

}
