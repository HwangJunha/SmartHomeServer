<%@page import="vo.Admin"%>
<%@page import="java.net.URLEncoder" %>
<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%
	Admin article = (Admin)request.getAttribute("article");
	String code = (String)request.getAttribute("code");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>방 페이지</title>
<style type="text/css">
table {
	margin: auto;
	width: 1000px;
	height: 400px;
	font-size:30px;
}
th{
	font-size:50px;
}

#commandList {
	margin: auto;
	width: 500px;
	text-align: center;
}
</style>
</head>

<body>
	<!-- 코드  수정 -->
	<header class="masthead bg-primary text-center" id="">
		<div class="container d-flex align-items-center flex-column">
		<h1 class="masthead-heading text-white text-uppercase mb-2">my home</h1>
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-home"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
        </div>
        
		<div class="bg-secondary" style="margin: 0 auto; border: 1px; width:1000px; height:600px;">
		
		<section>
			<table class="text-white bg-secondary">
				<tr>
				<th colspan="2">유저 상세 보기</th>
				</tr>
				<tr>
					<td><label for="code">코드</label></td>
					<td><%=article.getCode()%></td>
				</tr>
				<tr>
					<td><label for="name">이름</label></td>
					<td><%=article.getName()%></td>
				</tr>
				<tr>
					<td><label for="email">이메일</label></td>
					<td><%=article.getEmail()%></td>
				</tr>
				<tr>
					<td><label for="number">번호</label></td>
					<td><%=article.getPhone() %></td>
				</tr>
				<tr>
					<td><label for="cityId">도시 번호</label></td>
					<td><%=article.getCityId() %></td>
				</tr>
				<tr>
					<td><label for="address">주소</label></td>
					<td><%=article.getAddr() %></td>
				</tr>
				<tr>
					<td><label for="address2">상세 주소</label></td>
					<td><%=article.getAddr2() %></td>
				</tr>
			</table>
			
		</section>
	<section id="commandList">
		<a style="color: white;" href="UserModifyForm.bo?name=<%=article.getName()%>&code=<%=code%>">
			[수정] </a>  
			<a style="color: white;" href="UserDeletePro.bo?name=<%=article.getName()%>&code=<%=code%>">
			[삭제] </a > 
			<a style="color: white;" href="UserViewList.bo?code=<%=code%>">[목록]</a>&nbsp;&nbsp;
	</section>
		</div>
	</header>
	
</body>
</html>