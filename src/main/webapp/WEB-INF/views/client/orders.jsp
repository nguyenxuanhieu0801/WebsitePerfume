<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<div class="col-lg-12">
					<c:if test="${empty orders}">
						<div class="alert alert-warning" style="margin-top: 30px;"
							role="alert">"Danh sách đơn hàng trống"</div>
					</c:if>
					<c:if test="${not empty message}">
						<div class="alert alert-success mt-3" role="alert">
							${message}</div>
					</c:if>
					<c:if test="${!empty orders}">
						<div class="cart-table">
							<table>
								<thead>
									<tr>
										<th>Mã sản phẩm</th>
										<th>Tổng</th>
										<th>Trạng Thái</th>
										<th>Ngày</th>
										<th>&nbsp;</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="order" items="${orders}">
										<tr>
											<td>${order.orderId}</td>
											<td>${order.amount} USD</td>
											<td><c:if test="${order.status == 2}">
													Đã huỷ đơn
													</c:if> <c:if test="${order.status == 1}">
													Đã xác nhận 
													</c:if> <c:if test="${order.status == 0}">
													Đang chờ xác nhận
													</c:if></td>

											<td>${order.orderDate}</td>
											<td><a href="/user/orders/${order.orderId}"
												class="btn btn-primary btn-sm">Chi tiết </a></td>											
										</tr>
									</c:forEach>


								</tbody>
							</table>
							<div class="flex-c-m flex-w w-full p-t-45">
								<ul class="pagination">
									<li class="page-item"><a class="page-link"
										href="/user/orders/?page=1">First</a></li>
									<c:forEach var="item" begin="1" end="${totalPage}">
										<c:if test="${item != currentPage}">
											<c:if
												test="${item > (currentPage - 3) && item < (currentPage + 3) }">
												<li class="page-item"><a class="page-link"
													href="/user/orders/?page=${item}">${item}</a></li>
											</c:if>
										</c:if>
										<c:if test="${item == currentPage}">
											<li class="page-item active"><a class="page-link"
												href="/user/orders/?page=${item}">${item}</a></li>
										</c:if>
									</c:forEach>
									<li class="page-item"><a class="page-link"
										href="/user/orders/?page=${totalPage}">Last</a></li>
								</ul>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</section>

	<%@include file="/WEB-INF/views/client/include/footer.jsp"%>



	<%@include file="/WEB-INF/views/client/include/script.jsp"%>



</body>
</html>