<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@page import="java.util.Enumeration" %>
 <%@page import="svc.FileMoveService" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    
  </head>
  <body>
    <%
    
    int fileSize = 1024*1024*5; //5mb로 파일 크기를 제한 
    ServletContext context = getServletContext();
    String uploadPath = context.getRealPath("/upload");
    MultipartRequest multi = null;

    try{
      multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8",new DefaultFileRenamePolicy());
	  String name=multi.getParameter("name");
	  String code= multi.getParameter("code");
	  Enumeration files = multi.getFileNames();
      String originalFile[] = new String[20];
      String newFileName[] = new String[20];
      for(int i=19; i>=0; i--){
    	String file = (String)files.nextElement();
    	
    	originalFile[i] = multi.getFilesystemName(file);
      	newFileName[i] = String.valueOf(i)+".jpg";
      	System.out.println("file:"+file);
      	System.out.println("ori:"+originalFile[i]+"new:"+newFileName[i]);
      }
     
     
      String saveDir = uploadPath;
	
      for(int i=0; i<20; i++){
    	  if(!(originalFile[i]==null)) {
    		     // 원본이 업로드된 절대경로와 파일명를 구한다.
    		     String fullFileName = saveDir + "/" + originalFile[i];
    		     File f1 = new File(fullFileName);
    		     if(f1.exists()) {     // 업로드된 파일명이 존재하면 Rename한다.
    		          File newFile = new File(saveDir + "/"+code+"/"+name+"/"+ newFileName[i]);
    		     	  System.out.println(saveDir + "/"+code+"/"+name+"/"+ newFileName[i]);
    		          f1.renameTo(newFile);
    		     }
    		}
      }
      
   
    }catch(Exception e){
      out.write("업로드 용량 오류 또는 그 이외..." + e.getMessage());
    }

    %>
	<script type="text/javascript">
		alert('이미지 등록 완료!!')
		url = "image/ImagePreView.jsp.jsp?code="+code+"&name="+name;
		loacation.href=url;
	</script>
</body>
</html>