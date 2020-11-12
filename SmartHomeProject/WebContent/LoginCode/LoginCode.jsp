<%@page import= "java.sql.Connection"%>
<%@page import="vo.Admin"%>
<%@page import="svc.LoginService"%>

<%@page import="svc.LoginCodeService" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	LoginCodeService loginCodeService = new LoginCodeService();
	String returns="";
	request.setCharacterEncoding("UTF-8");
	LoginService loginService= new LoginService();
	String code = request.getParameter("code");
	String pwd = request.getParameter("pwd");
	
	boolean isUser=loginCodeService.getLoginAdmin(code, pwd);
	if(isUser){ //성공했을 경우
		loginService.getUserCode(code); //코드 저장
		returns="success";
	}else{
		returns="false";
	}
	
	
	System.out.println(isUser+"/"+"code="+code+"pwd="+pwd);
	
	
   // 안드로이드로 전송
   out.println(returns);
%>