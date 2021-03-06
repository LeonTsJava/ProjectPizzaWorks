<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<meta charset="UTF-8">

<title>會員登入</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- ----- -->
<jsp:include page="../shopSystem/fragment/ContentMetaInfo.jsp" />
<jsp:include page="../shopSystem/fragment/ContentCSS.jsp" />
<!-- ----- -->

</head>
<body>
	
	<jsp:include page="../shopSystem/fragment/navbar.jsp" />
	<section class="ftco-section">

		<div class='login-box col-lg-4 col-sm-6 col-md-6 mx-auto align-items-center needs-validation'> 
		<div class="login-logo" id='header'>
			<a href="#"><b>Pizza</b>會員登入</a>
		</div>
		<!-- /.login-logo -->
			<div id='container justify-content-center'>
		<!-- <div class="card">
			<div class="card-body login-card-body"> -->
				<p class="login-box-msg">${errorMessage}</p>
				<p class="login-box-msg">${CLoginOK.lastName}</p>
				<form action="${pageContext.request.contextPath}/memberSystem/loginCheck" method="post">
					<div class="input-group mb-3">
						<input type="email" class="form-control" placeholder="請輸入信箱" name="email" required autocomplete="off">
					</div>
					<div class="input-group mb-3">
						<input type="password" class="form-control" placeholder="請輸入密碼" name="password" required>
						
					</div>
					<div class="row">
						<div class="col-8">
							<div class="icheck-primary">
								<input type="checkbox" id="remember"> <label
									for="remember"> 記住我 </label>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-4">
							<button type="submit" class="btn btn-primary btn-block">登入</button>
						</div>
						<!-- /.col -->
					</div>
				</form>

				<!-- /.social-auth-links -->

				<p class="mb-1">
					<a href="${pageContext.request.contextPath}/memberSystem/forgetpwd">忘記密碼</a>
				</p>
				
				<p class="mb-1">
					<a href="${pageContext.request.contextPath}/memberSystem/register">註冊</a>
				</p>

			<!-- /.login-card-body -->
		</div>
	</div>
	<!-- /.login-box -->
</section>
	<jsp:include page="../shopSystem/fragment/footer.jsp" />
	<jsp:include page="../shopSystem/fragment/loader.jsp" />
	<jsp:include page="../shopSystem/fragment/ContentJS.jsp" />
</body>
</html>