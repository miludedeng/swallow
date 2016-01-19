<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
	<title>登录</title>
	<link href="${BASE}/asset/lib/application/application.css" rel="stylesheet" type="text/css">
	<link href="${BASE}/asset/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body class="login" cz-shortcut-listen="true">
	<div class="wrapper">
		<div class="row">
			<div class="col-lg-12">
				<div class="brand text-center">
					<h1>
						<div class="logo-icon">
						    <img src="${BASE}/asset/images/icon.png" height="42"/>
						</div>
						Swallow
					</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form>
					<fieldset class="text-center">
						<div class="form-group">
							<input class="form-control" placeholder="用户名/邮箱" type="text"></div>
						<div class="form-group">
							<input class="form-control" placeholder="密码" type="password"></div>
						<div class="text-center">
							<div class="checkbox">
								<label>
									<input type="checkbox">在这台计算机上记住我</label>
							</div>
							<a class="btn btn-default" href="http://lab2023.github.io/hierapolis/dashboard.html">登录</a>
							<br>
							<a href="http://lab2023.github.io/hierapolis/forgot_password.html">忘记密码?</a>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<!-- Javascripts -->
	<script src="${BASE}/asset/lib/jquery/jquery-1.12.0.js" type="text/javascript"></script>
</body>
</html>