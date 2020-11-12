package Pi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import utils.AllUser;

public class MoodLight {
	Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public MoodLight(String code) throws Exception, IOException{
		socket= new Socket(AllUser.users.get(code).getIp(),9999);
		
	}
	public String Communication(String msg) throws Exception, IOException{
		String remsg="";
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		out.println(msg);
		remsg=in.readLine();
		socket.close();
		return remsg;
	}
}
