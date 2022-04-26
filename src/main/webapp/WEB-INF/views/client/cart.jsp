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
					<c:if test="${empty cart}">
						<div class="alert alert-warning" style="margin-top: 30px;"
							role="alert">"Danh sách danh mục trống"</div>
					</c:if>
					<c:if test="${not empty message}">
						<div class="alert alert-success mt-3" role="alert">
							${message}</div>
					</c:if>
					<c:if test="${!empty cart}">
						<div class="cart-table">
							<table>
								<thead>
									<tr>
										<!-- <th>Image</th>-->
										<th>Hình ảnh</th>
										<th class="p-name">Tên sản phẩm</th>
										<th>Giá</th>
										<th class="text-center">Số Lượng</th>
										<th>Tổng</th>
										<th>Xóa</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${cart}">
										<tr id="product${item.name}">

											<td class="cart-pic first-row"><img
												src="uploads/${item.image }" alt="" width="80" height="70"></td>

											<td class="cart-title first-row">
												<h5>${item.name}</h5>
											</td>
											<td class="p-price first-row">${item.price} USD<input
												type="hidden" class="iprice" value="${item.price}">
											</td>
											<td class="qua-col first-row"><input
												class="txt-center iquantity" type="number"
												value="${item.quantity}" min="1"
												onchange="updateCart(this, ${item.productId})"></td>
											<td class="total-price first-row itotal"></td>
											<td class="close-td first-row"><input type="button"
												class="btn btn-danger"
												onclick="deleteCart(${item.productId})" value="Xóa"></td>
									</c:forEach>

								</tbody>
							</table>

						</div>
						<div class="row" style="justify-content: flex-end">
							<div class="col-lg-4 offset-lg-8">
								<div class="proceed-checkout">
									<ul>
										<!--  <li class="subtotal">Subtotal <span>$240.00</span></li>-->
										<li class="cart-total">Tổng <span id="amountCart"></span></li>
									</ul>
									<a href="/order/add" class="proceed-btn">Xác nhận đơn hàng</a>
								</div>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</section>

	<%@include file="/WEB-INF/views/client/include/footer.jsp"%>



	<%@include file="/WEB-INF/views/client/include/script.jsp"%>

	<script>
		
	</script>

</body>
</html>