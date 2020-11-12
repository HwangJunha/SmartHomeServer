<%@page import= "java.sql.Connection"%>
<%@page import="vo.Admin"%>
<%@page import="svc.LoginService"%>
<%@page import="vo.Room" %>
<%@page import="svc.RoomListService" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//ProfessorAttendanceService service=new ProfessorAttendanceService();
	
	RoomListService service=new RoomListService();
	
	request.setCharacterEncoding("UTF-8");
	LoginService loginService= new LoginService();
	String code = request.getParameter("code");
	loginService.getUserCode(code); //코드 저장
	
	String room = request.getParameter("room");
	
	ArrayList<Room> list = new ArrayList<>();
    
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