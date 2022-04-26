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

	<%@include file="/WEB-INF/views/client/include/slider.jsp"%>


	<section class="bg0 p-t-23 p-b-140">
		<div class="container">
			<div class="p-b-10">
				<h3 class="ltext-103 cl5">NEW PRODUCTS</h3>
			</div>

			<div class="image-slider">
				<c:forEach var="product" items="${products}">
					<div class="block2">
						<div class="block2-pic hov-img0">
							<img src="/uploads/${product.image}" alt="IMG-PRODUCT" />
						</div>
						<div class="block2-txt" style="margin-top: 8px;">
							<div class="text-center">
								<a href="/products/${product.productId}"
									class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6"
									style="font-size: 16px;"> ${product.name} </a>
							</div>

							<div class="d-flex align-items-center justify-content-center">
								<c:if test="${product.discount * product.price  > 0}">
									<span class="stext-105 cl3"
										style="text-decoration: line-through;">${product.price }
										USD</span>
									<span class="stext-105 cl3" style="margin-left: 5px;">${product.price - (product.discount/100 * product.price)} USD</span>
								</c:if>
								<c:if test="${product.discount * product.price  == 0}">
									<span class="stext-105 cl3">${product.price } USD</span>
								</c:if>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>




	</section>

	<!-- Back to top -->
	<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top"> <i
			class="zmdi zmdi-chevron-up"></i>
		</span>
	</div>



	<%@include file="/WEB-INF/views/client/include/footer.jsp"%>



	<%@include file="/WEB-INF/views/client/include/script.jsp"%>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$(".image-slider")
									.slick(
											{
												slidesToShow : 4,
												slidesToScroll : 1,
												infinite : true,
												arrows : true,
												draggable : false,
												prevArrow : `<button type='button' class='slick-prev slick-arrow'><ion-icon name="arrow-back-outline"></ion-icon></button>`,
												nextArrow : `<button type='button' class='slick-next slick-arrow'><ion-icon name="arrow-forward-outline"></ion-icon></button>`,
												dots : true,
												responsive : [ {
													breakpoint : 1025,
													settings : {
														slidesToShow : 3
													}
												}, {
													breakpoint : 480,
													settings : {
														slidesToShow : 1,
														arrows : false,
														infinite : false
													}
												} ],
												autoplay : true,
												autoplaySpeed : 1000,
											});
						});
	</script>

</body>

</html>