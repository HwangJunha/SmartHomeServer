<%@page import="vo.ServiceUp"%>
<%@page import="java.net.URLEncoder" %>
<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%
	ServiceUp article = (ServiceUp)request.getAttribute("article");
    String nowPage = (String)request.getAttribute("page");
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
<title>사용자 요청 페이지</title>
<style type="text/css">
table {
	margin: auto;
	width: 400px;
	height: 400px;
	font-size:20px;
	
}
th{
	font-size:40px;
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
        
		<div class="bg-secondary" style="margin: 0 auto; border: 1px; width:500px; height:600px;">
		<table class="text-white bg-secondary">
				<tr>
				<th colspan="2">서비스 상세 보기</th>
				</tr>
				<tr>
					<td ><label for="id">사용자 아이디</label></td>
					<td ><%=article.getId()%></td>
				</tr>
				<tr>
					<td ><label for="code">사용자 코드</label></td>
					<td ><%=article.getCode()%></td>
				</tr>
				<tr>
					<td ><label for="ip">사용자 아이피</label></td>
					<td ><%=article.getIp() %></td>
				</tr>
				<tr>
					<td ><label for="name">장비 이름</label></td>
					<td ><%=article.getName() %></td>
				</tr>
				<tr>
					<td ><label for="kind">장비 종류</label></td>
					<td ><%=article.getKind() %></td>
				</tr>
				<tr>
					<td ><label for="model">장비 모델</label></td>
					<td ><%=article.getModel() %></td>
				</tr>
				<tr>
					<td ><label for="pcDate">구매 날짜</label></td>
					<td ><%=article.getPcDate() %></td>
				</tr>
			</table>
			
	<section id="commandList">
		   <a
			href="ServiceIpForm.am?ip=<%=article.getIp() %>&page=<%=nowPage%>&id=<%=article.getId()%>">
			[ip등록] </a> <a href="ServiceList.am?page=<%=nowPage%>">[목록]</a>&nbsp;&nbsp;
	</section>
		</div>
		</header>
	
</body>
</html>