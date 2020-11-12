<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
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
<title>방 등록</title>
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
                <div class="bg-secondary" style="margin: 0 auto; border: 1px; width:1000px; height:600px;">
                	<form action="RoomWritePro.bo" method="post" name="Roomform">
					<input type="hidden" name="code" id="code" value="<%=code%>" >
					
					<table class="text-white bg-secondary">
				<tr>
					<td style="text-align: right;"><label for="name">방 이름:</label></td>
					<td style="text-align: left;"><input type="text" name="name"
						id="name" required="required" /></td>
				</tr>
				<tr>
					<td style="text-align: right;"><label for="kind">방 종류:</label></td>
					<td style="text-align: left;"><input type="text" name="kind"
						id="kind" /></td>
				</tr>
				<tr>
					<td style="text-align: right;"><label for="size">방 평수:</label></td>
					<td style="text-align: left;"><input type="text" name="size"
						id="size" /></td>
				</tr>
			</table>
			<section id="commandCell">
				<input style="color: #FFFFFF; background: #57B99D; font-size:1em; border-radius:0.5em; padding:5px 20px;" type="submit" value="등록">&nbsp;&nbsp; 
				<input style="color: #FFFFFF; background: #57B99D; font-size:1em; border-radius:0.5em; padding:5px 20px;" type="reset" value="다시쓰기" />
			</section>
		</form>
                </div>
        </div>
       </header>
        
</body>
</html>