<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="svc.FileEncodingService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
 <%@page import="java.io.File"%>
 
 <%
 	FileEncodingService service = new FileEncodingService();
 	String code = (String)request.getAttribute("code");
	String name = (String)request.getAttribute("name");
	String path = (String)request.getAttribute("path");
	int z=0;
	int images=0;
	String[] imagePath= new String[30];
	//경로에 있는 모든 파일 찾기
	ServletContext context = getServletContext();
    String uploadPath = context.getRealPath("/upload"+"/"+code+"/"+name);
    
    
    System.out.println("name:"+name+"code:"+code+"/");
	System.out.println("Realpath:"+uploadPath+"/");

%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <style>
    table {
	margin: auto;
	width: 400px;
	height: 100px;
	border: 1px solid #444444;
	
	
	}
	th, td {
    border: 1px solid #444444;
    align: center;
  	}	
  
    </style>

  </head>
  <body>
	<%
   
    
    %>
	
    <hr>
   	<div>
    
    </div>
    <form action="image/ImageUp.jsp" method="post" enctype="multipart/form-data">
    <input type="button" value="업로드 폴더 초기화!" onclick="location.href='roomImageDelete.bo?code=<%=code%>&name=<%=name%>'">
    <input type="submit" value="이미지 저장" >
   <!-- <input type="button" value="이미지 학습" onclick="location.href='roomImageDelete.bo?code=<%=code%>&name=<%=name%>'"> 나중에 하기-->
    

	  <input type="hidden" name="name" id="name" value="<%=name%>">
      <input type="hidden" name="code" id="code" value="<%=code%>">
    
      
      <div>
      <%for(int i=0; i<5; i++){ 
      %>
      <table>
      	
      <tr>
      	<%for(int j=0; j<4; j++){ %>
      	
      	<td align="center">
      		<img id="blah<%=z+1 %>" src="upload/<%=code%>/<%=name%>/<%=z%>.jpg" alt="your image" style="width:200px; height:200px" />
	  		<input type="file" name="uploadfile<%=z%>" onchange="readURL<%=z+1%>(this);">
	  		
	  	</td>
	  	<%
	  	z++;
	  	} %>
	  </tr>
	  
      </table>
      <%} %>
      
 </div>
    </form>

    <script>
	
     function readURL1(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#blah1').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
     function readURL2(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah2').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL3(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah3').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL4(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah4').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL5(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah5').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL6(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah6').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL7(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah7').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL8(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah8').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL9(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah9').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL10(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah10').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL11(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah11').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL12(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah12').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL13(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah13').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL14(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah14').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL15(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah15').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL16(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah16').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL17(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah17').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL18(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah18').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL19(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah19').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     function readURL20(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#blah20').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     
    
    </script>

  </body>
</html>