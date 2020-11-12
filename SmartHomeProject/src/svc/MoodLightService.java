package svc;

import java.io.IOException;

import Pi.MoodLight;

public class MoodLightService {
	
	public String current(String msg, String code) throws Exception, IOException {
		String result="";
		MoodLight mood= new MoodLight(code);
		result=mood.Communication(msg);
		return result;
	}
}
