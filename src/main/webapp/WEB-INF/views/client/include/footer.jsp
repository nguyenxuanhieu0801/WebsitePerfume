<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<footer class="bg3 p-t-75 p-b-0">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-lg-6 p-b-50">
				<h4 class="stext-301 cl0 p-b-30">CATEGORIES</h4>

				<ul >
					<c:forEach var="catogory" items="${listCategories}">
					<li class="p-b-10"><a href="/category/${catogory.categoryId}"
						class="stext-107 cl7 hov-cl1 trans-04">${catogory.name}</a></li>
					</c:forEach>
					

					
					<c:if test="${user.role == 1}">
						<li class="p-b-10"><a href="/admin/products"
							class="stext-107 cl7 hov-cl1 trans-04"> Admin </a></li>
					</c:if>
				</ul>
			</div>


			<div class="col-sm-6 col-lg-6 p-b-50">
				<h4 class="stext-301 cl0 p-b-30">CONTACT</h4>

				<p class="stext-107 cl7 size-201">Thông Tin Chi Tiết Vui Lòng Liên Hệ Địa Chỉ 97 Man Thiện, Phường Hiệp Phú, Thành Phố Thủ Đức.<br> Số Điện Thoại: 0888 888 888</p>

			</div>

		</div>
	</div>
</footer>