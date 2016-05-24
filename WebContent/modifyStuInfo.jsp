<%@page import="com.jkxy.model.stuInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生信息修改列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <jsp:include page="islogin.jsp"></jsp:include>
<body>

	<%
		List<stuInfo> stus = (List)session.getAttribute("stus");
		Iterator iter = stus.iterator(); //迭代器
	%>
	<table border="1">
		<tr>
			<td>id</td>
			<td>昵称</td>
			<td>姓名</td>
			<td>性别</td>
			<td>出生日期</td>
			<td>所在专业</td>
			<td>所选课程</td>
			<td>兴趣</td>
			<td>备注</td>
			<td> </td>
		</tr>
		<%
			//使用迭代器遍历出学生信息
			int i = 0;
			while (iter.hasNext()) {
				stuInfo student = (stuInfo) iter.next();
		%>
		<tr <%if(i%2==0){ %> bgcolor="#FOF8FF"<% }%>>
			<td><%=student.getId()%></td>
			<td><%=student.getNicheng()%></td>
			<td><%=student.getTruename()%></td>
			<td>
				<%
					if (student.getXb() == 1) {
							out.print("男");
						} else {
							out.print("女");
						}
				%>
			</td>
			<td><%=student.getCsrq()%></td>
			<td><%=student.getZy()%></td>
			<td><%=student.getKcs() %></td>
			<td><%=student.getXqs()%></td>
			<td><%=student.getBz()%></td>
			<td><a href="student/modifyOneStuServlet?id=<%=student.getId()%>">修改</a></td>
		</tr>
		<%
			i++;
			}
		%>
	</table>

</body>
</html>
