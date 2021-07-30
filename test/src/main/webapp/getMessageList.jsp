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
						<h1>게시글 목록들</h1>
						<p>Spring Project Practice</p>
					</header>

				<!-- Main -->

						<!-- Content -->

								<!-- Text -->
									<section class="MsgList">
								
									

									</section>

				

								<!-- Table -->
									<section>
								<c:forEach items="${msgList}" var="v">
										<h3><a href="getMsg.do?mid=${v.mid }">글 번호</a></h3>
										<p>${v.mid }</p>										
								
										<h3>작성자</h3>
										<p>${v.writer }</p>										
							
										<h3>내용</h3>
										<p>${v.content }</p>										
										</c:forEach>
									</section>
										
								
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