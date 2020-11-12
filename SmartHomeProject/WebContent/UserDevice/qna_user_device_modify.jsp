<%@page import="vo.UserDevice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	UserDevice article = (UserDevice)request.getAttribute("article");
	String nowPage=(String)request.getAttribute("nowPage");
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
	<title>사용자 장비 수정 </title>
	<script type="text/javascript">
	function modifyUserDevice(){
		modifyform.submit();
	}
	</script>
	<style type="text/css">
table {
	margin: auto;
	width: 500px;
	height: 400px;
	font-size:22px;
		
}
th{
	font-size:50px;
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
        
		<div class="bg-secondary" style="margin: 0 auto; border: 1px; width:650px; height:600px;">
			<form action="UserDeviceModifyPro.am" method="post" name = "modifyform">
		<input type="hidden" name="nowPage" id="nowPage" value="<%=nowPage%>" >
		<table class="text-white bg-secondary">
				<tr>
				<th colspan="2">사용자 장비 수정</th>
				</tr>
				<tr>
					<td style="text-align: right;"><label for="id">아이디:</label></td>
					<td style="text-align: left;">
					<input name="id" type="text" id="id" value="<%=article.getId()%>"  readonly/></td>
				</tr>
				<tr>
					<td style="text-align: right;"><label for="name">장비 이름:</label></td>
					<td style="text-align: left;">
					<input name="name" type="text" id="name" value="<%=article.getName()%>"/></td>
				</tr>
				<tr>
					<td style="text-align: right;"><label for="kind">장비 종류:</label></td>
					<td style="text-align: left;">
					<input name="kind" type="text" id="kind" value="<%=article.getKind()%>"/></td>
				</tr>
				<tr>
					<td style="text-align: right;"><label for="model">장비 모델:</label></td>
					<td style="text-align: left;">
					<input name="model" type="text" id="model" value="<%=article.getModel()%>"/></td>
				</tr>
				<tr>
					<td style="text-align: right;"><label for="state">장비 상태</br>(0설치전 1완료 2대기)</label></td>
					<td style="text-align: left;">
					<input name="state" type="text" id="state" value="<%=article.getState()%>"/></td>
				</tr>
			</table>
		<section id = "commandCell">
			<a style="color: white;" href="javascript:modifyUserDevice()">[수정]</a>&nbsp;&nbsp;
			<a style="color: white;" href="javascript:history.go(-1)">[뒤로]</a>
		</section>
		</form>
		</div>
		</header>

</body>
</html>