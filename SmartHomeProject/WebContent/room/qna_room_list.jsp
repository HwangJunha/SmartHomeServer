
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
<style>
		/* 사이드바 스타일 */
		.sidenav {
			height:100%;
			width: 0;
			position: fixed;
			z-index:1031;
			top: 0;
			right: 0;
			background-color: rgb(0,154,200);
			overflow-x: hidden;
			transition:0.5s ease-in-out;
			padding-top: 60px;
			
		}
		.sidenav a {
			padding: 8px 8px 8px 32px;
			text-decoration: none;
			font-size: 25px;
			color: #fff;
			display: block;
			transition: 0.2s ease-in-out;
			
		}
		.sidenav a:hover, .offcanvas a:focus {
			color: #000;
		}
		.closebtn {
			position: absolute;
			top: 0;
			right: 25px;
			font-size: 36px !important;
			margin-left: 50px;
		}
		.openmenu:hover {
			color:rgb(0,154,200);
			transition:0.5s ease-in-out;
		}
		.openmenu {
			font-size: 25px;
			cursor:pointer;
			transition:0.5s ease-in-out;
		}
		.openmenu > i {
			font-size: 30px;
		}
		/* 미디어쿼리 적용 */
		@media screen and (max-height:450px) {
			.sidenav {
				padding-top:15px;
				
			}
			.sidenav a {
				font-size: 18px;
				
			}
		}
	</style>

<title>스마트 홈</title>
</head>

<body>
	<!-- 방  리스트 -->
	
	<section id="listForm">
		<nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
		<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="MainPage?code=<%=code%>">Smart Home</a>
		<div class="collapse navbar-collapse" id="navbarResponsive">
		
		<ul class="navbar-nav m-auto">
			<%for(int i=0; i<articleList.size(); i++){
				%>
			<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="DeviceDataChart.bo?room=<%=articleList.get(i).getRoom()%>&code=<%=code%>&date=day" target="con"> 
				<%if(articleList.get(i).getRoomName().equals("기타")){
					continue;
				}%>
				
				<%=articleList.get(i).getRoomName()%>
				
				</a> 
			</li>
				<% 
			}
			%>
		</ul>
	
		<span class="navbar ml-auto text-uppercase font-weight-bold bg-primary text-white rounded openmenu" onclick='openNav()'>
		Menu
		 <i class="fas fa-bars"></i>
		</span>
		
		</div>
		</div>
		</nav>
		<header class="masthead bg-primary text-white text-center" id="">
		<div class="container d-flex align-items-center flex-column">
		<h1 class="masthead-heading text-uppercase mb-2">My Home</h1>
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><a href=roomViewList.bo?code=<%=code%>><i class="fas fa-home text-whit btn-outline-light"></i></a></div>
                    <div class="divider-custom-line"></div>
                </div>
        </div>
		<div>
			<p align="center">
				<iframe width="1000" height="600" name="con" style="background: #FFFFFF;">
				</iframe>
			</p>
		</div>
		</header>
	</section>
	<div id="mysidenav" class="sidenav"">
		<a href="#" class="closebtn" onclick='closeNav()'>x</a>
		<a href="roomList.bo?code=<%=code%>"><i class="fas fa-chart-area"></i>  Chart</a>
		<a href="roomImage.bo?code=<%=code%>"><i class="fas fa-image"></i>  Image</a>
		<a href="roomDevice.bo?code=<%=code%>"><i class="fas fa-laptop-house"></i>  Device</a>
		
	</div>
	<script>
		function openNav() {
			document.getElementById('mysidenav').style.width = '250px';
		}
		function closeNav() {
			document.getElementById('mysidenav').style.width = '0';
		}
	</script>
</body>
</html> 