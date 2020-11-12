package svc;
import java.io.IOException;

import Pi.Humidifier;

public class HFService {
	public String current(String msg, String code) throws Exception, IOException {
		String result="";
		Humidifier hf= new Humidifier(code);
		result=hf.Communication(msg);
		return result;
	}
}
