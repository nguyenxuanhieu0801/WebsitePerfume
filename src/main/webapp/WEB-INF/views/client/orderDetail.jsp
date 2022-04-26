<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/client/include/head.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/views/client/include/header.jsp"%>

	<section class="shopping-cart spad mt-3">

		<div class="container">
			<div class="row">
				<!-- left column -->
				<div class="col-md-12">
					<!-- jquery validation -->
					<div class="card card-primary mt-3">
						<div class="card-header">
							<h3 class="card-title">${title}</h3>
						</div>
						<c:if test="${not empty message}">
							<div class="alert alert-success" role="alert">${message}</div>
						</c:if>
						<!-- content -->
						<form:form action="/user/orders/update/${order.orderId}"
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
											<div class="form-group">${order.amount} USD</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>Ngày</label>
											<div class="form-group">${order.orderDate}</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>Trạng thái </label>
											<div class="d-flex" style="border: none;">
												<c:if test="${order.status == 1}">
													<form:radiobutton path="status" value="1"
														label="Xác nhận đơn hàng" cssStyle="margin: 6px 6px;" />
												</c:if>
												<c:if test="${order.status == 0}">
													<form:radiobutton path="status" value="0"
														label="Đang xử lý" cssStyle="margin: 6px 6px;" />
													<form:radiobutton path="status" value="2"
														cssStyle="margin: 6px 6px;" label="Hủy đơn hàng" />
												</c:if>
												<c:if test="${order.status == 2}">
													<form:radiobutton path="status" value="2"
														cssStyle="margin: 6px 6px;" label="Hủy đơn hàng" />
												</c:if>


											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="card-footer">
								<form:button type="submit" class="btn btn-primary">
                        Cập Nhật Đơn Hàng
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

		<div class="container">
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
								src="/uploads/${orderDetail.getProduct().getImage()}" width="80"
								height="70"></td>
							<td>${orderDetail.getProduct().getName()}</td>
							<td>${orderDetail.quantity} </td>
							<td>${orderDetail.price} USD</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /.content -->
		</div>
	</section>

	<%@include file="/WEB-INF/views/client/include/footer.jsp"%>



	<%@include file="/WEB-INF/views/client/include/script.jsp"%>



</body>
</html>