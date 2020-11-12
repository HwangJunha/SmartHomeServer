<%@page import= "java.sql.Connection"%>
<%@page import="vo.Admin"%>
<%@page import="svc.LoginService"%>
<%@page import="vo.DeviceData" %>
<%@page import="svc.DeviceDataService" %>
<%@page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//ProfessorAttendanceService service=new ProfessorAttendanceService();
	
	DeviceDataService service=new DeviceDataService();
	
	DeviceData data= new DeviceData();
	
	request.setCharacterEncoding("UTF-8");
	LoginService loginService= new LoginService();
	String code = request.getParameter("code");
	loginService.getUserCode(code); //코드 저장
	
	String room = request.getParameter("room");
	
	

	System.out.println("room:"+room);
	
    
	String returns="";
    String temp="";
	
    data=service.getLatestData(room,code);
    
	temp=data.toString();
	returns+=temp;
	
	
    System.out.println(returns);
   // 안드로이드로 전송
   out.println(returns);
%>