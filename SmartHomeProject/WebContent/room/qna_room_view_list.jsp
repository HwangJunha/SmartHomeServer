
<%@page import="vo.Room"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.net.URLEncoder"%>

<%
	ArrayList<Room> articleList=(ArrayList<Room>)request.getAttribute("articleList");
	String code=(String)request.getAttribute("code");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>SmartHome Web Page</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
<meta charset="UTF-8" />
<style type="text/css">


table {
	margin: auto;
	text-align: center;
	width: 1000px;
	height: 400px;
}

#emptyArea {
	margin: auto;
	width: 600px;
	text-align: center;
}

#commandList {
	margin: auto;
	width: 500px;
	text-align: center;
}

</style>
</head>

<body>
	<!-- 방  리스트 -->
	<header class="masthead bg-primary text-center" id="">
		<div class="container d-flex align-items-center flex-column">
		<h1 class="masthead-heading text-white text-uppercase mb-2">방 목록</h1>
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-home"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
        </div>
        
		<div style="margin: 0 auto; border: 1px; width:1000px; height:600px; background: #FFFFFF;">
				<section class="text-center">
		<table>
			<%
if(articleList != null){
%>

			<tr class="text-center bg-primary text-white bg-secondary" >
				<td>방 이름</td>
				<td>방 크기</td>
				<td>방 종류</td>
			</tr>

			<%
		for(int i=0;i<articleList.size();i++){
			
			%>
			<tr>
				<td>
					 <a href="RoomDetail.bo?name=<%=articleList.get(i).getRoomName() %>&code=<%=code%>">
						<%=articleList.get(i).getRoomName()%>
				</a>
				<td><%=articleList.get(i).getSize()%>평</td>
				<td><%=articleList.get(i).getKind()%></td>
				
			</tr>
			<%
				}
			%>
		</table>
	</section>
	<section id="commandList">
		<a
			href="RoomWriteForm.bo?code=<%=code %>">
			[입력하기] </a> 
			<a href="roomList.bo?code=<%=code%>">
			[돌아가기]</a>
			
	</section>
	<%
    }
	else{ //null 일 경우 등록된 방이 없다. 
	%>
	<section id="emptyArea">등록된 방이 없습니다.</section>
	<%
	}
	%>
	</div>
		</header>

</body>
</html> 