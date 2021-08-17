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
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
					<a href="index.jsp"><span class="logo"><img src="images/logo.svg" alt="" /></span></a>
						
						<h1><spring:message code="message.Msg.msgList.title"/></h1>
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
												<select name="search"> <!-- search는 찾아볼 거 -->
													<c:forEach items="${resultMap}" var="o">
														<option value="${o.value }">${o.key }</option>
													</c:forEach>
												</select>
												<input type="text" name="searchContent"><!-- 내가 입력한 거 -->
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
														<td><a href="getMsg.do?mid=${v.mid }">${v.mid }</a></td>
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