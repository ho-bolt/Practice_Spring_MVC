<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
	<!-- 언어변환 taglib -->
<!DOCTYPE HTML>
<!--
	Stellar by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Generic - Stellar by HTML5 UP</title>
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
						<h2><spring:message code="message.members.login.title"/></h2>
						<p>Spring Project InsertMember연습 </p>
					</header>

				<!-- Main -->
					<div id="Join" style="width:50%" align="center">

						<!-- Content -->
						
						
						<a href="login.do?lang=en"> <spring:message code="message.members.login.language.en" /></a> <a href="login.do?lang=ko"><spring:message code="message.members.login.language.ko"/></a>
						<hr>
							<section id="Join_Member" class="Join_main" >
								<form action="login.do" method="post">
									<spring:message code="message.members.login.id" />
									<input type="text" name="id" value="${member.id }">
								<spring:message code="message.members.login.password" />
									<input type="password" name="password" value="${member.password }" >
									
									<input type="submit" value="<spring:message code="message.members.login.loginBtn" />">
									
								</form>
								
							
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