package svc;

import java.io.IOException;

import Pi.FlowerPot;

public class FlowerPotService {
	public String flowerActivity(String msg, String code) throws Exception, IOException {
		String result="";
		FlowerPot flower= new FlowerPot(code);
		
		result=flower.Communication(msg);
		return result;
	}
}
