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
			<div class="card-body register-card-body">
				<c:if test="${not empty error}">
					<div class="alert alert-danger mt-3" role="alert">${error}</div>
				</c:if>
				<div class="text-center mb-4">
					<h2>Register</h2>
				</div>
				<form:form action="/register" method="POST" modelAttribute="user">

					<div class="input-group">
						<form:input type="text" class="form-control" path="name"
							placeholder="Full name" />
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-user"></span>
							</div>
						</div>
					</div>
					<form:errors path="name" cssClass="text-danger" />


					<div class="input-group mt-3">
						<form:input type="email" class="form-control" path="email"
							placeholder="Email" />
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<form:errors path="email" cssClass="text-danger" />


					<div class="input-group mt-3">
						<form:input type="password" class="form-control" path="password"
							placeholder="Password" />
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<form:errors path="password" cssClass="text-danger" />

					<div class="input-group mt-3">
						<form:input  type="tel" class="form-control" path="phone"
							placeholder="Phone Number" />
					</div>
					<form:errors path="phone" cssClass="text-danger" />

					<div class="input-group mt-3">
						<form:input type="text" class="form-control" path="address"
							placeholder="Address" />
					</div>
					<form:errors path="address" cssClass="text-danger" />

					<div class="input-group mt-3">
						<label style="margin-right: 12px;">Gender</label>
						<form:radiobutton path="sex" value="true" label="Male" cssStyle="margin: 6px 6px;"/>
						<form:radiobutton path="sex" value="false" label="Female" cssStyle="margin: 6px 8px;"/>
					</div>
					<form:errors path="sex" cssClass="text-danger" />





					<!--
					<div class="input-group mb-3">
						<form:input type="password" class="form-control" path="password" placeholder="Retype password" />
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					-->
					<!--
					<div class="row">
						<!--<div class="col-8">
							<div class="icheck-primary">
								<input type="checkbox" id="agreeTerms" name="terms"
									value="agree"> <label for="agreeTerms"> I agree
									to the <a href="#">terms</a>
								</label>
							</div>
						</div>
						 /.col -->
					<div class="mt-3 col-12">
						<button type="submit" class="btn btn-primary btn-block">Register</button>
					</div>
					<!-- /.col -->
				</form:form>
					<p class="mb-0 mt-3 text-center">
					<a href="/login">I already have an account</a>
				</p>
				
			</div>
			<!-- /.form-box -->
		</div>
		<!-- /.card -->
	</div>
	</div>
	<!-- /.login-box -->
	<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>
</body>
</html>