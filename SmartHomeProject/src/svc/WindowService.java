package svc;

import java.io.IOException;

import Pi.Window;

public class WindowService {
	public String openWindow(String msg, String code) throws Exception, IOException {
		String result="";
		Window window= new Window(code);
		result=window.Communication(msg);
		return result;
	}
	
	public String closeWindow(String msg, String code) throws Exception, IOException {
		String result="";
		Window window= new Window(code);
		
		result=window.Communication(msg);
		return result;
	}
	public String AIMode(String msg, String code) throws Exception, IOException {
		String result="";
		Window window= new Window(code);
		result=window.Communication(msg);
		return result;
	}
	public String manualMode(String msg, String code) throws Exception, IOException {
		String result="";
		Window window= new Window(code);
		
		result=window.Communication(msg);
		return result;
	}
	
	public String current(String msg,String code) throws Exception, IOException {
		String result="";
		Window window= new Window(code);
		result=window.Communication(msg);
		return result;
	}
}
