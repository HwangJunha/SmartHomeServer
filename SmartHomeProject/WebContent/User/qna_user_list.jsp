<%@page import="vo.PageInfo"%>
<%@page import="vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.net.URLEncoder"%>

<%
	ArrayList<Admin> articleList=(ArrayList<Admin>)request.getAttribute("articleList");
    PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int listCount=pageInfo.getListCount();
	int nowPage=pageInfo.getPage();
	int maxPage=pageInfo.getMaxPage();
	int startPage=pageInfo.getStartPage();
	int endPage=pageInfo.getEndPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>SmartHome My Page</title>
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
<title>사용자 목록 </title>
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
<style type="text/css">
table {
	margin: auto;
	width: 1400px;
	text-align: center;
}

#pageList {
	margin: auto;
	width: 600px;
	text-align: center;
}

#emptyArea {
	margin: auto;
	width: 600px;
	text-align: center;
}


</style>
</head>

<body>
	<nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
		<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="index.jsp">Smart Home</a>
		<div class="collapse navbar-collapse" id="navbarResponsive">
	
		<span class="navbar ml-auto text-uppercase font-weight-bold bg-primary text-white rounded openmenu" onclick='openNav()'>
		Menu
		 <i class="fas fa-bars"></i>
		</span>
		
		
		</div>
		</div>
		</nav>
	<header class="masthead bg-primary text-center" id="">
		
		<div class="container d-flex align-items-center flex-column">
		<h1 class="masthead-heading text-white text-uppercase mb-2">유저 목록</h1>
		<section id="listForm">
		<h2>
					<a style="color: white;" href="UserWriteForm.am">유저 등록하기</a>
		</h2>
		</section>
        </div>
        
		<div style="margin: 0 auto; border: 1px; width:1400px; height:350px; background: #FFFFFF;">
		<table>
			<%
if(articleList != null && listCount > 0){
%>

			<tr class="text-center bg-primary text-white bg-secondary">
				<td>코드</td>
				<td>아이디</td>
				<td>이름</td>
				<td>이메일</td>
				<td>전화번호</td>
				<td>지역번호</td>
				<td>우편번호</td>
				<td>주소</td>
				<td>상세 주소</td>
				<td>아이피</td>
			</tr>

			<%
		for(int i=0;i<articleList.size();i++){
			
	%>
			<tr>
				<td><%=articleList.get(i).getCode()%></td>
				<td>
					 <a href="UserDetail.am?id=<%=articleList.get(i).getId() %>&page=<%=nowPage %>">
						<%=articleList.get(i).getId()%>
				</a>
				</td>
				<td><%=articleList.get(i).getName()%></td>
				<td><%=articleList.get(i).getEmail() %></td>
				<td><%=articleList.get(i).getPhone() %></td>
				<td><%=articleList.get(i).getCityId() %></td>
				<td><%=articleList.get(i).getZip_code() %></td>
				<td><%=articleList.get(i).getAddr() %></td>
				<td><%=articleList.get(i).getAddr2() %></td>
				<td><%=articleList.get(i).getIp() %></td>
			</tr>
			<%} %>
		</table>
	
	
	<section id="pageList">
		<%if(nowPage<=1){ %>
		[이전]&nbsp;
		<%}else{ %>
		<a href="UserList.am?page=<%=nowPage-1 %>">[이전]</a>&nbsp;
		<%} %>

		<%for(int a=startPage;a<=endPage;a++){
				if(a==nowPage){%>
		[<%=a %>]
		<%}else{ %>
		<a href="UserList.am?page=<%=a %>">[<%=a %>]
		</a>&nbsp;
		<%} %>
		<%} %>

		<%if(nowPage>=maxPage){ %>
		[다음]
		<%}else{ %>
		<a href=UserList.am?page=<%=nowPage+1 %>>[다음]</a>
		<%} %>
	</section>
	<%
    }
	else
	{
	%>
	<section id="emptyArea">등록된 사용자가 없습니다.</section>
	<%
	}
%>
		</div>
		</header>
		
	<div id="mysidenav" class="sidenav"">
		<a href="#" class="closebtn" onclick='closeNav()'>x</a>
		<a href="UserList.am""><i class="fas fa-user"></i>  사용자</a>
		<a href="DeviceList.am"><i class="fas fa-laptop"></i>  장비</a>
		<a href="UserDeviceList.am"><i class="fas fa-laptop-house"></i>  사용자 장비</a>
		<a href="ServiceList.am"><i class="fas fa-cogs"></i>  서비스 등록</a>
		
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