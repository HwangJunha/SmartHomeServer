<%@page import= "java.sql.Connection"%>
<%@page import="vo.Admin"%>
<%@page import="svc.LoginService"%>
<%@page import="svc.InsertKeyService" %>
<%@page import="svc.DoorLockService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	InsertKeyService doorService = new InsertKeyService();
	DoorLockService comService = new DoorLockService();
	String retuns="";
	request.setCharacterEncoding("UTF-8");
	LoginService loginService= new LoginService();
	String code = request.getParameter("code");
	loginService.getUserCode(code); //코드 저장
	String cmd = request.getParameter("cmd");
	String model = request.getParameter("model");
	String msg= model+"/"+cmd;
	
	retuns=comService.doorActivity(msg,code);
	
   // 안드로이드로 전송
   out.println(retuns);
%>