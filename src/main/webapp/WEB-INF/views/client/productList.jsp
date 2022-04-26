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


	<section class="bg0 p-t-23 p-b-140" style="margin-top: 80px">
		<div class="container">
			<div class="flex-w flex-l-m filter-tope-group m-tb-10">
				<a class="stext-106 cl6 bor3 hov1 trans-04 m-r-32 m-tb-5" href="/products"
					>All Product</a>
				<c:forEach var="catogory" items="${listCategories}">
				<a class="stext-106 cl6 bor3 hov1 trans-04 m-r-32 m-tb-5" href="/category/${catogory.categoryId}"
					>${catogory.name}</a>

				
					</c:forEach>
					
			</div>

			<h2 class="text-center" style="padding-bottom: 12px">DANH SÁCH
				SẢN PHẨM</h2>
			<div class="list row align-items-stretch">
				<c:forEach var="product" items="${products}">
					<div class="col-sm-6 col-md-4 col-lg-3 p-b-35">
						<div class="block2">

							<div class="block2-pic hov-img0">
								<img src="/uploads/${product.image}" alt="IMG-PRODUCT" />
							</div>

							<div class="block2-txt" style="margin-top: 8px;">

								<div class="text-center">
									<a href="products/${product.productId}"
										class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6"
										style="font-size: 16px;"> ${product.name} </a>

								</div>

								<div class="d-flex align-items-center justify-content-center">
									<c:if test="${product.discount/100 * product.price  > 0}">
										<span class="stext-105 cl3"
											style="text-decoration: line-through;">${product.price }
											VND</span>
										<span class="stext-105 cl3" style="margin-left: 5px;">${product.price - (product.discount/100 * product.price)}USD</span>
									</c:if>
									<c:if test="${product.discount/100 * product.price  == 0}">
										<span class="stext-105 cl3">${product.price } USD</span>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

				<div class="flex-c-m flex-w w-full p-t-45">
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="/products/?page=1">First</a></li>
						<c:forEach var="item" begin="1" end="${totalPage}">
							<c:if test="${item != currentPage}">
								<c:if
									test="${item > (currentPage - 3) && item < (currentPage + 3) }">
									<li class="page-item"><a class="page-link"
										href="/products/?page=${item}">${item}</a></li>
								</c:if>
							</c:if>
							<c:if test="${item == currentPage}">
								<li class="page-item active"><a class="page-link"
									href="/products/?page=${item}">${item}</a></li>
							</c:if>
						</c:forEach>
						<li class="page-item"><a class="page-link"
							href="/products/?page=${totalPage}">Last</a></li>
					</ul>
				</div>
			</div>

		</div>

	</section>
	F
	<%@include file="/WEB-INF/views/client/include/footer.jsp"%>



	<%@include file="/WEB-INF/views/client/include/script.jsp"%>

	<script>
		
	</script>

</body>
</html>