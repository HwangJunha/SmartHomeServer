<%@page import= "java.sql.Connection"%>
<%@page import="svc.LoginService"%>

<%@page import="svc.FlowerPotService" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	FlowerPotService flowerService = new FlowerPotService();
	
	request.setCharacterEncoding("UTF-8");
	LoginService loginService= new LoginService();
	String code = request.getParameter("code");
	loginService.getUserCode(code); //코드 저장
	
	String cmd = request.getParameter("cmd");
	String model = request.getParameter("model");
	String msg= model+"/"+cmd;
	System.out.println(msg);
	
	String result=flowerService.flowerActivity(msg, code);
	System.out.println("socekt"+result);
	result=result.substring(0,1);
	System.out.println("result"+result);
	String returns="";
	
   // 안드로이드로 전송
   out.println(result);
%>