<%@page import="com.test.myapp.message.MessageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
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
						<h1><spring:message code="message.Msg.msgList.title1"/></h1>
						<p>Spring Project Practice</p>
					</header>

				<!-- Main -->
					<div id="main">

						<!-- Content -->
							<section id="content" class="main">
									<a href="getMsgList.do?lang=en"> <spring:message code="message.members.login.language.en" /></a> <a href="getMsgList.do?lang=ko"><spring:message code="message.members.login.language.ko"/></a>
								<!-- Text -->
									<section class="MsgList">
								
									

									</section>

				

								<!-- Table -->
								<section>
								<form action="getMsgList.do" method="post">
									<table>
										<tr>
											<td>
												<select name="search"> <!-- search??? ????????? ??? -->
													<c:forEach items="${resultMap}" var="o">
														<option value="${o.value }">${o.key }</option>
													</c:forEach>
												</select>
												<input type="text" name="searchContent"><!-- ?????? ????????? ??? -->
												<input type="submit" value="<spring:message code="message.Msg.msgList.SearchBtn"/>">
											</td>
										</tr>
									
									
									</table>
								
								
								</form>
										<h2>Msg Table</h2>
										<div class="table-wrapper">
											<table>
												<thead>
												</thead>
												<tbody>
													<tr>
														<th><spring:message code="message.Msg.msgList.Num"/></th>
														<th><spring:message code="message.Msg.msgList.title"/></th>
														<th><spring:message code="message.Msg.msgList.content"/></th>
													</tr>
												<c:forEach items="${msgList }" var="v">
												
													<tr>
														<td><a href="getMsg.do?mid=${v.mid}">${v.mid }</a></td>
														<td>${v.title}</td>
														<td>${v.content }</td>
													</tr>
													</c:forEach>
													
												</tbody>
												
											</table>
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