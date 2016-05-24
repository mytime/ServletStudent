<%@page import="com.jkxy.model.userTable"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%-- 如果session里有user信息，用户则不用登陆--%>

<%
	userTable user = (userTable) session.getAttribute("user");
	if (user == null) {
%>
		<jsp:forward page="index.jsp"></jsp:forward>
<%
	}
%>
