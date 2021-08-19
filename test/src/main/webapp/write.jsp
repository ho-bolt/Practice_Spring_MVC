<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<h1>글 작성 화면</h1>
						<p>Spring Project InsertMember연습 </p>
					</header>

				<!-- Main -->
					<div id="main">

						<!-- Content -->
						
								<!-- Lists -->
									<section id="intro" class="main">
								<div class="spotlight">   
									<div class="content" style="margin:0 auto">
										<header class="major">
											<h2>새로운 글 작성하기</h2>
										</header>
										<form action="insertMsg.do" method="post" enctype="multipart/form-data">
											<ul>
												<li>제목</li>
												<li><input type="text" name="title"></li>
												<li>내용</li>
												<li><textarea name="content" placeholder="내용" maxlength="2048px" style="height:300px"></textarea></li>
												<li><input type="submit" value="글 등록" style="margin:10px"></li>
											</ul>
										</form>
										<ul class="actions">
										</ul>
									</div>
								</div>
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