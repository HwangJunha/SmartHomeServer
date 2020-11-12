<%@page import= "java.sql.Connection"%>
<%@page import="vo.AISet"%>
<%@page import="svc.LoginService"%>
<%@page import="svc.AIsetDeleteService"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	AISet aiSet= new AISet();
	String result="";
	request.setCharacterEncoding("UTF-8");
	LoginService loginService= new LoginService();
	AIsetDeleteService aiService = new AIsetDeleteService();
	
	String code = request.getParameter("code");
	loginService.getUserCode(code); //코드 저장
	
	String model = request.getParameter("model");
	String temperature = request.getParameter("temperature");
	String dust = request.getParameter("dust");
	String humidity = request.getParameter("humidity");
	String temperatureRule = request.getParameter("temperatureRule");
	String dustRule = request.getParameter("dustRule");
	String humidityRule = request.getParameter("humidityRule");
	String onoff = request.getParameter("onoff");
	String day = request.getParameter("day");
	String time = request.getParameter("time");
	String interval = request.getParameter("interval");
	String room = request.getParameter("room");
	
	
	if(day.equals("null") && time.equals("null")){ //day와 time이 null일떄
		
		String[] array = interval.split(" ");
		
		
		time=array[0];
		System.out.println("time:"+time);
		day = array[1].substring(0,1);
		String[] array2= time.split(":");
		
		if(!(array2[0].length()==2)){
			if(Integer.parseInt(array2[0])<10){
			array2[0]="0"+array2[0];
			}
		}
		if(!(array2[1].length()==2)){
		if(Integer.parseInt(array2[1])<10){
				array2[1]="0"+array2[1];
			}
		}
		time=array2[0]+":"+array2[1];
		
		System.out.println("day:"+day);
		interval ="0";
	}
	System.out.println(model);
	System.out.println(temperature);
	System.out.println(dust);
	System.out.println(humidity);
	System.out.println(temperatureRule);
	System.out.println(dustRule);
	System.out.println(humidityRule);
	System.out.println(onoff);
	System.out.println(day);
	System.out.println(time);
	System.out.println(interval);
	System.out.println(room);
	
	aiSet.setRoom(room);
	aiSet.setModel(model);
	aiSet.setTemperature(temperature);
	aiSet.setDust(dust);
	aiSet.setHumidity(humidity);
	
	if(temperatureRule.equals("이상")){
		aiSet.setTemperatureRule("up");
	}else if(temperatureRule.equals("미만")){
		aiSet.setTemperatureRule("down");
	}
	if(dustRule.equals("이상")){
		aiSet.setDustRule("up");
	}else if(dustRule.equals("미만")){
		aiSet.setDustRule("down");
	}
	if(humidityRule.equals("이상")){
		aiSet.setHumidityRule("up");
	}else if(humidityRule.equals("미만")){
		aiSet.setHumidityRule("down");
	}
	
	aiSet.setOnoff(onoff);
	aiSet.setDay(day);
	aiSet.setTime(time);
	aiSet.setInterval(interval);
	
	if(aiService.AIsetDeleteService(aiSet, code)){
		result="success";
	}else{
		result="fail";
	}
	result=aiService.AIcom("newAI",code);
	 
   // 안드로이드로 전송
   out.println(result);
%>