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
									<div class="alert alert-success" role="alert">${message}
									</div>
								</c:if>
								<!-- content -->
								<form:form action="/admin/orders/update/${order.orderId}"
									method="POST" modelAttribute="order">
									<div class="card-body">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label for="menu">ID</label>
													<form:input path="orderId" cssClass="form-control"
														readonly="true" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Tổng</label>
													<form:input path="amount" cssClass="form-control"
														readonly="true" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Ngày</label>
													<div class="form-group">${ order.orderDate}
													</div>
												</div>
											</div>
											<div class="form-group">
												<label>Trạng thái </label>
												<div class="form-control" style="border: none;">
													<form:radiobutton path="status" value="0"
														label="Đang xử lý" />
													<form:radiobutton path="status" value="1"
														label="Xác nhận đơn hàng" />
													<form:radiobutton path="status" value="2"
														label="Hủy đơn hàng" />

												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Tên khách hàng</label>
													<div class="form-group">${ user.name}
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Đia chỉ</label>
													<div class="form-group">${ user.address}
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Số điện thoai</label>
													<div class="form-group">${ user.phone}
													</div>
												</div>
											</div>
											
										</div>
									</div>
									<div class="card-footer">
										<form:button type="submit" class="btn btn-primary">
                        Cập nhật Danh Mục
                      </form:button>
									</div>
								</form:form>
							</div>
							<!-- /.card -->
						</div>
						<!--/.col (left) -->
						<!-- right column -->


						<!--/.col (right) -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<div class="container-fluid">
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Ảnh</th>
							<th>Tên Sản Phẩm</th>
							<th>Số Lượng</th>
							<th>Giá</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="orderDetail" items="${orderDetails}">
							<tr>
								<td>${orderDetail.orderDetailId}</td>
								<td width="100"><img
									src="/uploads/${orderDetail.getProduct().getImage()}"
									width="80" height="70"></td>
								<td>${orderDetail.getProduct().getName()}</td>
								<td>${orderDetail.quantity}</td>
								<td>${orderDetail.price}</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
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
