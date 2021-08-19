<%@page import="com.test.myapp.message.MessageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE HTML>
<!--
	Stellar by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Elements - Stellar by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
		<noscript><link rel="stylesheet" href="assets/css/fontawesome-all.min.css" /></noscript>
		<style>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap');

header,h1{font-family: 'Nanum Pen Script', cursive;}
h2{font-family: 'Nanum Pen Script', cursive;}
p{font-family: 'Nanum Pen Script', cursive;}
ui,li{font-family: 'Nanum Pen Script', cursive;}
</style>
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
					<a href="index.jsp"><span class="logo"><img src="images/logo.svg" alt="" /></span></a>
						<h1>마이페이지 목록들</h1>
						<p>Spring Project Practice</p>
					</header>

				<!-- Main -->
					<div id="main">

						<!-- Content -->
							<section id="content" class="main">

								<!-- Text -->
									<section class="MsgList">
								
									

									</section>

				

								<!-- Table -->
								<section>
								${vvv.name }님 정보  
										<h2>MyPage</h2>
										<div class="table-wrapper">
										<form action="updateMypage.do" method="post"> 
										<input type="hidden" value="${vvv.id}" name="id"/>
											<table>
												<thead>
												</thead>
												<tbody>
													<tr>
														<th>아이디</th>
														<th>비밀번호</th>														
														<th>이름</th>
														<th>역할</th>
													</tr>
												
													<tr>
														<td>${vvv.id}</td>
														<td>${vvv.password}</td>
														<td>${vvv.name}</td>
														<td>${vvv.role}</td>
													</tr>
												</tbody>
											</table>
											
											</form>
										</div>

										<h3>Alternate</h3>
										
									</section>
									</section>
									</div>
									</div>
									
												

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>