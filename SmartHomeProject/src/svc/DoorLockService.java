package svc;

import java.io.IOException;

import Pi.DoorLock;

public class DoorLockService {
	public String doorActivity(String msg, String code) throws Exception, IOException {
		String result="";
		DoorLock door= new DoorLock(code);
		
		result=door.Communication(msg);
		return result;
	}
}
