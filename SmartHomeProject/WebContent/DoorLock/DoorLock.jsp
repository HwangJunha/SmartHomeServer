<%@page import= "java.sql.Connection"%>
<%@page import="vo.Admin"%>
<%@page import="svc.LoginService"%>

<%@page import="svc.DoorLockService" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DoorLockService doorService = new DoorLockService();
	
	request.setCharacterEncoding("UTF-8");
	LoginService loginService= new LoginService();
	String code = request.getParameter("code");
	loginService.getUserCode(code); //코드 저장
	
	String cmd = request.getParameter("cmd");
	String model = request.getParameter("model");
	String msg= model+"/"+cmd;
	
	
	String result=doorService.doorActivity(msg,code); //도어락 실행
    
	String returns="";
	
   // 안드로이드로 전송
   out.println(result);
%>