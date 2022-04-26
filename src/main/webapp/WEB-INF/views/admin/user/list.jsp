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
					href="#" role="button"><i class="fas fa-bars"></i></a>
				</li>
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
									<div class="alert alert-success mt-3" role="alert">
										${message}</div>
								</c:if>
								<c:if test="${empty users}">
									<div class="alert alert-warning mt-3" role="alert">"Danh
										sách người dùng trống"</div>
								</c:if>
								<table class="table">
									<thead>
										<tr>
											<th style="width: 50px">ID</th>
											<th>Name</th>
											<th>Email</th>
											<th>Phone</th>
											<th>Address</th>
											<th style="width: 100px">&nbsp;</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="user" items="${users}">
											<tr>
												<td>${user.userId}</td>												
												<td>${user.name}</td>
												<td>${user.email}</td>
												<td>${user.phone}</td>
												<td>${user.address}</td>
												<td><a class="btn btn-primary btn-sm"
													href="/admin/users/edit/${user.userId}">
														<i class="fas fa-edit"></i>
												</a> <a href="/admin/users/delete/${user.userId}"
													class="btn btn-danger btn-sm">
														<i class="fas fa-trash"></i>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<nav class="mx-auto">
									<ul class="pagination">
										<li class="page-item"><a class="page-link"
											href="/admin/users/?page=1">First</a></li>
										<c:forEach var="item" begin="1" end="${totalPage}">
											<c:if test="${item != currentPage}">
												<c:if
													test="${item > (currentPage - 3) && item < (currentPage + 3) }">
													<li class="page-item"><a class="page-link"
														href="/admin/users/?page=${item}">${item}</a></li>
												</c:if>
											</c:if>
											<c:if test="${item == currentPage}">
												<li class="page-item active"><a class="page-link"
													href="/admin/users/?page=${item}">${item}</a></li>
											</c:if>
										</c:forEach>
										<li class="page-item"><a class="page-link"
											href="/admin/users/?page=${totalPage}">Last</a></li>
									</ul>
								</nav>
							</div>
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
