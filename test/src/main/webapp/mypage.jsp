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
										<form action="updateMsg.do" method="post"> 
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
														<td><input type="password" name="password" value="${vvv.password}"></td>
														<td><input type="text" name="name" value="${vvv.name}"></td>
														<td>${vvv.role}</td>
														
													</tr>
														
												</tbody>
													
											</table>
											<input type="submit" value="수정하기">
											
											</form>
										</div>

										<h3>Alternate</h3>
										<div class="table-wrapper">
											<table class="alt">
												<thead>
													<tr>
														<th>Name</th>
														<th>Description</th>
														<th>Price</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>Item One</td>
														<td>Ante turpis integer aliquet porttitor.</td>
														<td>29.99</td>
													</tr>
													<tr>
														<td>Item Two</td>
														<td>Vis ac commodo adipiscing arcu aliquet.</td>
														<td>19.99</td>
													</tr>
													<tr>
														<td>Item Three</td>
														<td> Morbi faucibus arcu accumsan lorem.</td>
														<td>29.99</td>
													</tr>
													<tr>
														<td>Item Four</td>
														<td>Vitae integer tempus condimentum.</td>
														<td>19.99</td>
													</tr>
													<tr>
														<td>Item Five</td>
														<td>Ante turpis integer aliquet porttitor.</td>
														<td>29.99</td>
													</tr>
												</tbody>
												<tfoot>
													<tr>
														<td colspan="2"></td>
														<td>100.00</td>
													</tr>
												</tfoot>
											</table>
										</div>
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