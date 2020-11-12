<%@page import= "java.sql.Connection"%>
<%@page import="vo.Admin"%>
<%@page import="svc.LoginService"%>

<%@page import="vo.Device" %>
<%@page import="svc.DeviceListService" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//ProfessorAttendanceService service=new ProfessorAttendanceService();
	
	DeviceListService service=new DeviceListService();
	
	request.setCharacterEncoding("UTF-8");
	String code = request.getParameter("code");
	LoginService loginService= new LoginService();	
	
	loginService.getUserCode(code); //코드 저장
	
	ArrayList<Device> list = new ArrayList<>();
    
	String returns="";
    String temp="";
	
    list=service.getArticleList(code);
    
	for(int i=0; i<list.size(); i++){
		temp=list.get(i).toString();
		returns+=temp;
	} 
	
    System.out.println(returns);
   // 안드로이드로 전송
   out.println(returns);
%>