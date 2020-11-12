package svc;

import java.io.File;

public class FileMoveService {
	File  folder1;
	File folder2;
	public FileMoveService() { //path1 원본 파일 경로 path2 이동할 파일 경로
		
	}
	public void moveFolder(String path1, String path2) {
		this.folder1= new File(path1);
		this.folder2= new File(path2);
		boolean isMoved = folder1.renameTo(folder2);
		if(isMoved) {
			System.out.println("파일 이동 성공");
		}else {
			System.out.println("파일 이동 실패");
		}
	}
	
}
