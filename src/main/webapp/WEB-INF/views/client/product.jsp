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

	<section class="sec-product-detail bg0 p-t-65 p-b-60" style="margin-top: 32px;">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-lg-7 p-b-30">
				<div class="p-l-25 p-r-30 p-lr-0-lg ">
				<div class="d-flex justify-content-center">
					<img src="/uploads/${product.image}" alt="IMG-PRODUCT" width="300px"/>
				</div>
				</div>
									</div>	

				<div class="col-md-6 col-lg-5 p-b-30">
					<div class="p-r-50 p-t-5 p-lr-0-lg">
						<h4 class="mtext-105 cl2 js-name-detail p-b-14">${product.name}</h4>
						<c:if test="${product.discount * product.price  > 0}">
							<div class="text-center">
							<p class="mtext-106 cl2" style="text-decoration: line-through; margin-bottom: 6px">${product.price} USD</p>	
							<p class="mtext-106 cl2">${product.price - (product.discount/100 * product.price)} USD</p>	
							</div>	
						</c:if>
						
						<c:if test="${product.discount * product.price  == 0}">
							<span class="mtext-106 cl2">${product.price} USD</span>	
						</c:if>
										
						<div class="p-t-33">

							<div class="flex-w flex-r-m p-b-10">
								<div class="size-204 flex-w flex-m respon6-next">
								
						
									<button
										class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail"
										onclick="addToCart(${product.productId})">
										Add to cart</button>
								
									
								</div>
							</div>
						</div>

						
					</div>
				</div>
			</div>

			<div class="bor10 m-t-50 p-t-43 p-b-40">
				<!-- Tab01 -->
				<div class="tab01">
					<!-- Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item p-b-10"><a class="nav-link active"
							data-toggle="tab" href="#description" role="tab">Description</a>
						</li>
						<!-- 
						<li class="nav-item p-b-10"><a class="nav-link"
							data-toggle="tab" href="#information" role="tab">Additional
								information</a></li>

						<li class="nav-item p-b-10"><a class="nav-link"
							data-toggle="tab" href="#reviews" role="tab">Reviews (1)</a></li>
						 -->
					</ul>

					<!-- Tab panes -->
					<div class="tab-content p-t-43">
						<!-- - -->
						<div class="tab-pane fade show active" id="description"
							role="tabpanel">
							<div class="how-pos2 p-lr-15-md">
								<p class="stext-102 cl6">${product.description}</p>
							</div>
						</div>

					
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@include file="/WEB-INF/views/client/include/footer.jsp"%>



	<%@include file="/WEB-INF/views/client/include/script.jsp"%>



</body>
</html>