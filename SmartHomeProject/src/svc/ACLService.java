package svc;
import java.io.IOException;

import Pi.AirCleaner;

public class ACLService {
	public String current(String msg, String code) throws Exception, IOException {
		String result="";
		AirCleaner air= new AirCleaner(code);
		result=air.Communication(msg);
		return result;
	}
}
