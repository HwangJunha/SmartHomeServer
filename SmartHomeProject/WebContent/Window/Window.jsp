<%@page import= "java.sql.Connection"%>
<%@page import="vo.Admin"%>
<%@page import="svc.LoginService"%>
<%@page import="svc.WindowService" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	WindowService windowService = new WindowService();
	
	request.setCharacterEncoding("UTF-8");
	LoginService loginService= new LoginService();
	String code = request.getParameter("code");
	loginService.getUserCode(code); //코드 저장
	String cmd = request.getParameter("cmd");
	String model = request.getParameter("model");
	String msg= model+"/"+cmd;
	
	System.out.println("msg"+msg);
	String result=windowService.current(msg,code); //전원 실행
	System.out.println("socket"+result);
	String returns="";
	result=result.substring(0,1);
    
	System.out.println("result"+result);
	
   // 안드로이드로 전송
   out.println(result);
%>