<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="vo.Admin"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<title>회원가입</title>
 <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<script type="text/javascript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>
    function zipCheck() { 
    	new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
 
                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
 
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address').value = fullRoadAddr;
                document.getElementById('address2').focus();
            }
        }).open();
    }
</script>
<script>
function updateCheck() // 개인정보 수정 버튼을 누르면 호출되는 함수 입력하지 않은값이 있으면 경고창이 뜨고 정상적으로 입력하면
{	
	var id= document.querySelector('#id');
	var pwd= document.querySelector('#pwd');
	var repwd= document.querySelector('#repwd');
	var name= document.querySelector('#name');
	var email= document.querySelector('#email');
	var tel_1= document.querySelector('#tel_1');
	var tel_2= document.querySelector('#tel_2');
	var tel_3= document.querySelector('#tel_3');
	var zipcode= document.querySelector('#zipcode');
	var address= document.querySelector('#address');
	var address2= document.querySelector('#address2');
	
	if (id.value == "") {
       alert("아이디를 입력해 주세요.");
       id.focus();
       return;
   }
	
   if (pwd.value != repwd.value) // 입력한 비밀번호와
   {
       alert("비밀번호가 일치하지 않습니다.");
       repwd = "";
       id.focus();
       return;
   }

   if (name.value == "") {
       alert("이름을 입력해 주세요");
       name.focus();
       return;
   }
   

   if (email.value == "") {
       alert("이메일을 입력해 주세요.");
       email.focus();
       return;
   }

   if (email.value != ""){
   	
   	var exptext = /^[0-9a-zA-Z][-_.]?[0-9a-zA-Z]*[0-9a-zA-Z]*.[a-zA-Z]]{2,3}$/i;

		if(exptext.test(email.value)){

		//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우			
		alert("이 메일형식이 올바르지 않습니다.22");

		email.focus();

		return;

		}
   }
   if(tel_1.value=="" || tel_2.value=="" || tel_3.value=="" ){
   	alert("핸드폰 번호를 확인해 주세요.");
       tel_1.focus();
       return;
   }
   if(tel_1.value !="" || tel_2.value !="" || tel_3.value !="" ){
   	var rgEx = /(01[016789])[-](\d{4}|\d{3})[-]\d{4}$/g; 
   	   var strValue = tel_1.value+"-"+tel_2.value+"-"+tel_3.value;
   	   var chkFlg = rgEx.test(strValue);  
   	   if(!chkFlg){
   	    alert("올바른 휴대폰번호가 아닙니다.");
   	    tel_1.focus();
   	    return;
   	  }
   }
   if (zipcode.value == "") {
       alert("우편번호를 검색해 주세요.");
       return;
   }

   if (address.value == "") {
       alert("주소를 검색해 주세요");
       
       return;
   }
   if (address2.value == "") {
       alert("주소를 입력해 주세요");
       
       return;
   }
   var form = document.Personal;
   form.submit();
   
}
</script>
</head>
<body>
					<% 
                    Admin loginMember = (Admin)request.getAttribute("loginMember");
                    
                    %>
	<nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="MainPage?code=<%=loginMember.getCode()%>">Smart Home</a>
            </div>
     </nav>
     <section class="page-section bg-primary text-white mb-0" id="about">
    <div class="container">
        <br /> <br />
        <form method="post" action="Personal" id="Personal" name="Personal">
            <input id="code" name="code"  value="<%=loginMember.getCode()%>" style="display:none">
            <table width=36% align="center" border="1">
                <tr>
                    <td align="center" valign="middle">
                        <table border="0" align="center">
                            <tr class="bg-secondary" align="center" >
                                <td colspan="3"><font color="#FFFFFF"><b>개인정보 수정</b></font></td>
                                
                            </tr>
 
 
                            <tr class="form-group">
                                <td>아이디</td>
                                <td><input id="id" name="id" size="21" value="<%=loginMember.getId()%>"> 
                                <!-- onClick로 입력한 아이디가 중복된 값인지 확인 -->
                                
                            </tr>
 
                            <tr>
                                <td>패스워드</td>
                                <td><input type="password" id="pwd" name="pwd" size="21"></td>
                                
                            </tr>
 
                            <tr>
                                <td>패스워드 확인</td>
                                <td><input type="password" id="repwd" name="repwd" size="21"></td>
                                
                            </tr>
 
                            <tr>
                                <td>이름</td>
                                <td><input id="name" name="name" size="21" value="<%=loginMember.getName()%>"></td>
                                
                            </tr>
 
                            <tr>
                                <td>Email</td>
                                <td><input id="email" name="email" size="21" value="<%=loginMember.getEmail()%>"></td>
                                
                            </tr>
 							<tr>
 								<td>핸드폰 번호</td>
 								<td>
 									<input type="text" size="7" id="tel_1" name="tel_1" value="<%=loginMember.getPhone().substring(0,3)%>"> -
 									<input type="text" size="7" id="tel_2" name="tel_2" value="<%=loginMember.getPhone().substring(4,8)%>"> - 
 									<input type="text" size="7" id="tel_3" name="tel_3" value="<%=loginMember.getPhone().substring(9)%>"> 
 									
 								</td>
 							</tr>
                            <tr class="form-group">
                            	<td rowspan="3">주소</td>
                                <td>
                                <input type="text" id="zipcode" name="zipcode" value="<%=loginMember.getZip_code()%>" readonly> &nbsp; &nbsp;
                                <input class="btn btn-secondary" type="button" size="10" value="우편번호찾기" onClick="zipCheck()">
                                </td> <!-- zipCheck()함수를 사용해 우편번호와 주소를 검색한다. -->
                            </tr>
                            <tr>
                            	<td><input type="text" size="30" id="address" name="address" value="<%=loginMember.getAddr()%>"  readonly></td>
                            </tr>
                            <tr>
                            	<td><input type="text" size="30" id="address2" name="address2" value="<%=loginMember.getAddr2()%>"></td>
                            </tr>
                            <tr class="form-group">
            
                                <td colspan="2" align="center"><input class="btn btn-secondary" type="button" id="modifyButton" name="modifyButton" value="개인정보 수정" onclick="updateCheck()"> &nbsp; &nbsp; 
                                <input class="btn btn-secondary" type="button" value="로그아웃" onClick="location.href='logout'"></td>
                            </tr>
 
                        </table>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    </section>
</body>
<!-- Footer-->
<footer class="footer text-center">
            <div class="container">
                <div class="row">
                    <!-- Footer Location-->
                    <div class="col-lg-4 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">지역</h4>
                        <p class="lead mb-0">
                            충북 청주시 상당구 금천동
                            <br />
                            장자마을 부영아파트 501동 104호
                        </p>
                    </div>
                    <!-- Footer Social Icons-->
                    <div class="col-lg-4 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">웹사이트 둘러보기</h4>
                        <a class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-fw fa-facebook-f"></i></a>
                        <a class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-fw fa-twitter"></i></a>
                        <a class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-fw fa-linkedin-in"></i></a>
                        <a class="btn btn-outline-light btn-social mx-1" href="#!"><i class="fab fa-fw fa-dribbble"></i></a>
                    </div>
                    <!-- Footer About Text-->
                    <div class="col-lg-4">
                        <h4 class="text-uppercase mb-4">개발자</h4>
                        <p class="lead mb-0">
                            서원대학교 컴퓨터공학과 15학번 황준하</br>
                            전화번호:010-8428-2511</br>
                           	이메일:tarot1415@gmail.com
                        </p>
                    </div>
                </div>
            </div>
</footer>
</html>