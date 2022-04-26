
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/views/admin/include/head.jsp"%>
</head>

<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#" role="button"><i class="fas fa-bars"></i></a></li>
			</ul>
			<!-- Right navbar links -->
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					data-widget="fullscreen" href="#" role="button"> <i
						class="fas fa-expand-arrows-alt"></i>
				</a></li>
			</ul>
		</nav>
		<!-- /.navbar -->

		<%@include file="/WEB-INF/views/admin/include/sidebar.jsp"%>
		<div class="content-wrapper">
			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<!-- left column -->
						<div class="col-md-12">
							<!-- jquery validation -->
							<div class="card card-primary mt-3">
								<div class="card-header">
									<h3 class="card-title">${title}</h3>
								</div>
								<c:if test="${not empty message}">
									<div class="alert alert-success mt-3" role="alert">${message}
									</div>
								</c:if>
								<c:if test="${not empty message2}">
									<div class="alert alert-danger mt-3" role="alert">${message2}
									</div>
								</c:if>

								<!-- content -->
								<form:form action="/admin/users/update/${userId}" method="POST"
									modelAttribute="user">
									<div class="card-body">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label for="menu">Họ và tên</label>
													<form:input type="text" path="name" cssClass="form-control"
														placeholder="Nhập họ và tên	" />
													<form:errors path="name" cssClass="text-danger" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Email</label>
													<form:input type="email" path="email"
														cssClass="form-control" placeholder="Nhập email"
														readonly="true" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Địa chỉ</label>
													<form:input type="text" path="address"
														cssClass="form-control" placeholder="Nhập địa chỉ" />
													<form:errors path="address" cssClass="text-danger" />

												</div>
											</div>
										</div>
										<!--  -->
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label for="menu">Số điện thoại</label>
													<form:input type="phone" path="phone"
														cssClass="form-control" placeholder="Nhập số điện thoại	" />
													<form:errors path="phone" cssClass="text-danger" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Mật khẩu mới</label>
													<form:input type="text" path="password"
														cssClass="form-control" placeholder="Mật khẩu mới" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-check" style="padding-left: 0">
													<label style="margin-right: 12px;">Quyền</label>
													<form:radiobutton path="role" value="0" label="User"
														cssStyle="margin: 6px 6px;" />
													<form:radiobutton path="role" value="1" label="Admin"
														cssStyle="margin: 6px 6px;" />

												</div>
											</div>

										</div>
										<div class="row">
											<div class="col-md-6">
												<label style="margin-right: 12px;">Giới tính</label>
												<form:radiobutton path="sex" value="true" label="Nam"
													cssStyle="margin: 6px 6px;" />

												<form:radiobutton path="sex" value="false" label="Nữ"
													cssStyle="margin: 6px 6px;" />
											</div>
										</div>
									</div>



									<div class="card-footer">
										<form:button type="submit" class="btn btn-primary">
                        Cập nhật Người Dùng
                        
                      </form:button>
									</div>
								</form:form>
							</div>
							<!-- /.card -->
						</div>
						<!--/.col (left) -->
						<!-- right column -->
						<div class="col-md-6"></div>
						<!--/.col (right) -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="float-right d-none d-sm-block">
				<b>Version</b> 3.1.0
			</div>
			<strong>Copyright &copy; 2014-2021 <a
				href="https://adminlte.io">AdminLTE.io</a>.
			</strong> All rights reserved.
		</footer>
	</div>
	<!-- ./wrapper -->
	<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>
</body>
</html>