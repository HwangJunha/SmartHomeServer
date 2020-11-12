<%@page import= "java.sql.Connection"%>
<%@page import="vo.AISet"%>
<%@page import="svc.LoginService"%>
<%@page import="svc.AILoadService"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<AISet> aiList= new ArrayList<>();
	String result="";
	request.setCharacterEncoding("UTF-8");
	LoginService loginService= new LoginService();
	AILoadService aiService = new AILoadService();
	
	String code = request.getParameter("code");
	loginService.getUserCode(code); //코드 저장
	
	aiList=aiService.getArticleList(code);
	String temp="";
	
	for(int i=0; i<aiList.size(); i++){
		String room = aiList.get(i).getRoom();
		String model = aiList.get(i).getModel();
		String temperature = aiList.get(i).getTemperature();
		String dust = aiList.get(i).getDust();
		String humidity = aiList.get(i).getHumidity();
		String temperatureRule = aiList.get(i).getTemperatureRule();
		String dustRule = aiList.get(i).getDustRule();
		String humidityRule = aiList.get(i).getHumidityRule();
		String onoff = aiList.get(i).getOnoff();
		String day = aiList.get(i).getDay();
		String time = aiList.get(i).getTime();
		String interval = aiList.get(i).getInterval();
		String execution = aiList.get(i).getExecution();
		temp+=room+"/"+model+"/"+temperature+"/"+temperatureRule+"/"+dust+"/"+dustRule+"/"+humidity+"/"+humidityRule+"/"+day+"/"+onoff+"/"+time+"/"+interval+"/"+execution+"/";
	}
	//안드로이드 전송
	System.out.println("전송결과:"+temp);
	out.println(temp);
%>