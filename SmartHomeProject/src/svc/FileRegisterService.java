package svc;

import java.io.File;

public class FileRegisterService {
	public void MakeDir(String name, String code) {
		String path = "/Users/junha/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SmartHomeProject/upload/"+code; //폴더 경로
		File Folder = new File(path);
		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!Folder.exists()) { //code 폴더가 없을경우
			try{
			    Folder.mkdir(); //폴더 생성합니다.
			    System.out.println(path+"폴더가 생성되었습니다.");
			    path+="/"+name;
				Folder = new File(path); //name 경로
					if(!Folder.exists()) {
						 Folder.mkdir(); //폴더 생성합니다.
						 System.out.println(path+"폴더가 생성되었습니다.");
					}else {
						System.out.println(path+"이미 폴더가 생성되어 있습니다.");
					}
				} 
				catch(Exception e){
		        	e.getStackTrace();
		        }        
	         }else { //code 폴더가 있을 경우
	        	 System.out.println(path+"이미 폴더가 생성되어 있습니다.");
	        	 try{
	 			    path+="/"+name;
	 				Folder = new File(path); //name 경로
	 					if(!Folder.exists()) {
	 						 Folder.mkdir(); //폴더 생성합니다.
	 						 System.out.println(path+"폴더가 생성되었습니다.");
	 					}else {
	 						System.out.println(path+"이미 폴더가 생성되어 있습니다.");
	 					}
	 				} 
	 				catch(Exception e){
	 		        	e.getStackTrace();
	 		        }  
	         }
			
		}
	public void MakeDir2(String name, String code) {
		String path="/Users/junha/eclipse-workspace/SmartHomeProject/WebContent/upload"+code;
		File Folder = new File(path);
		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!Folder.exists()) { //code 폴더가 없을경우
			try{
			    Folder.mkdir(); //폴더 생성합니다.
			    System.out.println(path+"폴더가 생성되었습니다.");
			    path+="/"+name;
				Folder = new File(path); //name 경로
					if(!Folder.exists()) {
						 Folder.mkdir(); //폴더 생성합니다.
						 System.out.println(path+"폴더가 생성되었습니다.");
					}else {
						System.out.println(path+"이미 폴더가 생성되어 있습니다.");
					}
				} 
				catch(Exception e){
		        	e.getStackTrace();
		        }        
	         }else { //code 폴더가 있을 경우
	        	 System.out.println(path+"이미 폴더가 생성되어 있습니다.");
	        	 try{
	 			    path+="/"+name;
	 				Folder = new File(path); //name 경로
	 					if(!Folder.exists()) {
	 						 Folder.mkdir(); //폴더 생성합니다.
	 						 System.out.println(path+"폴더가 생성되었습니다.");
	 					}else {
	 						System.out.println(path+"이미 폴더가 생성되어 있습니다.");
	 					}
	 				} 
	 				catch(Exception e){
	 		        	e.getStackTrace();
	 		        }  
	         }
	}
}
