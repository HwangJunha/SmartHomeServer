<%@page import= "java.sql.Connection"%>
<%@page import="vo.Admin"%>
<%@page import="svc.LoginService"%>
<%@page import="vo.Room" %>
<%@page import="svc.ACLService" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ACLService ACL= new ACLService();
	
	request.setCharacterEncoding("UTF-8");
	
	

	LoginService loginService= new LoginService();
	String code = request.getParameter("code");
	String cmd = request.getParameter("cmd");
	String model = request.getParameter("model");
	String msg= model+"/"+cmd;
	
	loginService.getUserCode(code); //코드 저장
	System.out.println("msg"+msg);
	
	String result=ACL.current(msg, code); // mode 실행
	System.out.println("socket"+result);
	result=result.substring(0,1);
	
    System.out.println("result"+result);
   // 안드로이드로 전송
   out.println(result);
%>