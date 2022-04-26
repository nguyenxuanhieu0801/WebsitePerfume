<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/views/admin/include/head.jsp"%>
<script src="/ckeditor/ckeditor.js"></script>
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

					<c:if test="${not empty error}">
                    	<div class="alert alert-danger mt-3" role="alert">${error}</div>
                    </c:if>
						<!-- left column -->
						<div class="col-md-12">
							<!-- jquery validation -->
							<div class="card card-primary mt-3">
								<div class="card-header">
									<h3 class="card-title">${title}</h3>
								</div>

								<!-- content -->
								<form:form action="/admin/products/save" method="POST"
									modelAttribute="product" enctype="multipart/form-data">

									<div class="card-body">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label for="menu">Tên Sản Phẩm</label>
													<form:input type="text" path="name" cssClass="form-control"
														placeholder="Nhập tên sản phẩm" />
													<form:errors path="name" cssClass="text-danger"/>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label>Danh Mục</label>
													<form:select path="categoryId" cssClass="form-control">
														<form:options items="${categories}"
															itemValue="categoryId" itemLabel="name" />
													</form:select>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label for=quantity>Số lượng</label>
													<form:input id="quantity" type="number" path="quantity"
														cssClass="form-control"
														min = "0"
														step="1"/>
													 <form:errors path="quantity" cssClass="text-danger"/>
												</div>
											</div>

											<div class="col-md-4">
												<div class="form-group">
													<label for="price">Giá</label>
													<form:input type="number" path="price"
														cssClass="form-control" 
														min = "0"
														step="0.1" />
													<form:errors path="price" cssClass="text-danger"/>
												</div>
											</div>

											<div class="col-md-4">
												<div class="form-group">
													<label for="discout">Discount</label>
													<form:input type="number" 
														path="discount"														
														class="form-control" />
												</div>
											</div>
										</div>



										<div class="form-group">
											<label for="description">Mô Tả Chi Tiết</label>
											<form:textarea path="description" />
										<form:errors path="description" cssClass="text-danger"/>

										</div>

										<div class="form-group">
											<label for="imageFile">Ảnh Sản Phẩm</label>
											<form:input type="file" 
											cssClass="form-control"
											path="imageFile" 
											onchange="chooseFile(this)"
											accept="image/png, image/jpeg, image/jpg"/>
											<img id="image" src="" width="300px" />
											<form:errors path="imageFile" cssClass="text-danger"/> 
										</div>
										<!--  -->

										<div class="card-footer">
											<form:button type="submit" class="btn btn-primary">Thêm Sản Phẩm</form:button>
										</div>
									</div>
								</form:form>
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

	<script>
		function chooseFile(fileInput) {
			if (fileInput.files && fileInput.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$("#image").attr("src", e.target.result);
				};

				reader.readAsDataURL(fileInput.files[0]);
			}
		}
	</script>
	<script>
		CKEDITOR.replace("description");
	</script>
</body>
</html>