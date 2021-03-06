<%@page import="vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	Admin article = (Admin)request.getAttribute("article");
	String code=(String)request.getAttribute("code");
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

	<title>사용자 수정 </title>
	<script type="text/javascript">
	function modifyUser(){
		modifyform.submit();
	}
	</script>
	<style type="text/css">
   table {
	margin: auto;
	width: 500px;
	height: 400px;
	font-size:30px;
		
}
th{
	font-size:50px;
}
#commandCell{
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
<!-- 게시판 등록 -->
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
       	<form action="UserModifyPro.bo" method="post" name = "modifyform">
		<input type="hidden" name="code" id="code" value="<%=code%>" >
		<input type="hidden" name="name" id="name" value="<%=article.getName()%>" >
		<table class="text-white bg-secondary">
				<tr>
				<th colspan="2">사용자 수정</th>
				</tr>
				<tr>
				<tr>
					<td style="text-align: right;"><label for="mName">이름:</label></td>
					<td style="text-align: left;">
					<input name="mName" type="text" id="mName" value="<%=article.getName()%>"></td>
				</tr>
				<tr>
					<td style="text-align: right;"><label for="number">번호:</label></td>
					<td style="text-align: left;">
					<input name="number" type="text" id="number" value="<%=article.getPhone()%>"/></td>
				</tr>
				<tr>
					<td style="text-align: right;"><label for="email">이메일:</label></td>
					<td style="text-align: left;">
					<input name="email" type="text" id="email" value="<%=article.getEmail()%>"/></td>
				</tr>
			</table>
	<section id = "commandCell">
			<a style="color: white;" href="javascript:modifyUser()">[수정]</a>&nbsp;&nbsp;
			<a style="color: white;" href="javascript:history.go(-1)">[뒤로]</a>
	</section>
</form>
        </div>
</header>
</body>
</html>