<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/admin/include/head.jsp"%>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="card">
			<div class="card-body login-card-body">
				<c:if test="${not empty message}">
					<div class="alert alert-success mt-3" role="alert">
						${message}</div>
				</c:if>

				<c:if test="${not empty error}">
					<div class="alert alert-danger mt-3" role="alert">${error}</div>
				</c:if>
				<div class="text-center mb-4">
					<h4>Sign in to start your session</h4>
				</div>
				<form:form action="/login" method="POST" modelAttribute="user">

					<div class="input-group mt-3">

						<form:input type="email" path="email" class="form-control"
							placeholder="Email" />
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<form:errors path="email" cssClass="text-danger" />

					<div class="input-group mt-3">
						<form:input type="password" path="password" class="form-control"
							placeholder="Password" />
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>

					<form:errors path="password" cssClass="text-danger" />
					<div class="row mt-3">
						<div class="col-12">
							<form:button type="submit" class="btn btn-primary btn-block">Sign In</form:button>
						</div>
						<!-- /.col -->
					</div>
				</form:form>
				<p class="mb-0 mt-3 text-center">
					<a href="/register">Register a new membership</a>
				</p>
			</div>
		</div>
	</div>
	<!-- /.login-box -->
	<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>
</body>
</html>