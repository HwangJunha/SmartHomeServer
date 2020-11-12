<%@ page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String model=(String)request.getAttribute("model");
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
<title>사용자 장비 삭제 </title>
<style>
table {
	margin: auto;
	width: 350px;
	height: 300px;
	font-size:20px;
	
}
#commandCell{
      text-align: center;     
}
</style>
</head>
<body>
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
        
		<div class="bg-secondary" style="margin: 0 auto; border: 1px; width:350px; height:350px;">
		<form name="deleteForm" action="UserDeviceDeletePro.am?model=<%=model %>" method="post">
		<input type = "hidden" name = "page" value = "<%=nowPage %>"/>
		<table class="text-white bg-secondary">
		<tr>
				<th colspan="2">사용자 장비 삭제</th>
		</tr>
		<tr>
		<td style="text-align: right;">
			<label>모델 : </label>
		</td>
		<td style="text-align: left;">
			<input name="model" type="text">
		</td>
		</tr>
		<tr>
		</tr>
		</table>
		<section id = "commandCell">
			<input style="color: #FFFFFF; background: #57B99D; font-size:1em; border-radius:0.5em; padding:5px 20px;" type="submit" value = "삭제"/>
			&nbsp;&nbsp;
			<input style="color: #FFFFFF; background: #57B99D; font-size:1em; border-radius:0.5em; padding:5px 20px;" type = "button" value = "돌아가기" onClick ="javascript:history.go(-1)"/>
		</section>	
		</form>
	</div>
	</header>	
</body>
</html>