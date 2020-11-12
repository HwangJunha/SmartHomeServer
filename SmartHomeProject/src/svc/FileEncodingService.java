package svc;

import java.io.IOException;

import Pi.FileEncoding;

public class FileEncodingService {
	public String current(String msg) throws Exception, IOException {
		String result="";
		FileEncoding hf= new FileEncoding();
		result=hf.Communication(msg);
		return result;
	}
}
