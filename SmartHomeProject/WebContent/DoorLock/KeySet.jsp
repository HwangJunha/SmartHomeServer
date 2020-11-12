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
	String retunrs="";
	request.setCharacterEncoding("UTF-8");
	LoginService loginService= new LoginService();
	String code = request.getParameter("code");
	loginService.getUserCode(code); //코드 저장
	String cmd = request.getParameter("cmd");
	String model = request.getParameter("model");
	String msg= model+"/"+cmd;
	
	
	boolean result=doorService.registArticle(cmd, code); //키 등록
	
	if(result){ //값이 성공적으로 저장 했을시
		msg=comService.doorActivity(model+"/reset",code); //도어락 키 reset
	}
    
	
   // 안드로이드로 전송
   out.println(msg);
%>