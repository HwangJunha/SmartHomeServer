<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%
	String code = (String)request.getAttribute("code");
	String name = (String)request.getAttribute("name");
	String path = (String)request.getAttribute("path");
	
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>
  <body>

    <%
    ServletContext context = getServletContext();
    String uploadPath = context.getRealPath("/upload"+"/"+code+"/"+name);
    System.out.println("DeleteRealPath:"+uploadPath);
    
    File file = new File(uploadPath);
    File files[] = file.listFiles();
    if(files!=null && files.length>0){
      for(File f:files){
        %>
    <%=f.getName() %>(<%=f.isDirectory()?"디렉토리":"파일" %>)<br>
    <% 
    }

    for(File f:files){
      f.delete();
    }%>
    <h3>총 <%=files.length %>개의 파일 삭제 완료!</h3>
    <%
    }else{
      %>
    <h3>삭제할 파일이 없음.</h3>
    <%
    }
    %>

    <a href="javascript:history.back();">이전으로 돌아가기</a>

  </body>
</html>