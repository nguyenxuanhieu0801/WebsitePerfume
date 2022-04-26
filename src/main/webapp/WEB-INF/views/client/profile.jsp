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
	<section class="shopping-cart spad" style="margin-top: 60px">
		<div class="container">
		<c:if test="${not empty message}">
					<div class="alert alert-success mt-3" role="alert">${message}
					</div>
				</c:if>
			<div class="row" style="justify-content: center">
				
				<div class="col-6">

					<form:form action="/user/update" method="POST"
						modelAttribute="user">

						<div class="form-group">
							<label for="name">Họ và tên</label>
							<form:input id="name" type="text" class="form-control"
								path="name" placeholder="Họ và tên" />
							<form:errors path="name" cssClass="text-danger" />
							
						</div>

						<div class="form-group">
							<label for="address">Địa chỉ</label>
							<form:input type="text" path="address" class="form-control"
								placeholder="Địa chỉ" />
							<form:errors path="address" cssClass="text-danger" />
							
						</div>

						<div class="form-group">
							<label>Email</label>
							<form:input type="email" path="email" cssClass="form-control"
								placeholder="Nhập email" readonly="true" />
							<form:errors path="email" cssClass="text-danger" />
							
						</div>
						<div class="form-group">
							<label for="phone">Số điện thoại</label>
							<form:input type="phone" path="phone" class="form-control"
								placeholder="Số điện thoại" />
							<form:errors path="phone" cssClass="text-danger" />
								
						</div>
						<div class="form-group" style="display: flex">
							<label style="margin-right: 3px;">Giới tính</label>
							<form:radiobutton path="sex" value="true" label="Nam"
								cssStyle="margin: 6px 6px;" />
							<form:radiobutton path="sex" value="false" label="Nữ"
								cssStyle="margin: 6px 6px;" />
						</div>

						<form:button type="submit" class="btn btn-primary">Cập nhật</form:button>

					</form:form>

				</div>
			</div>
		</div>
	</section>

	<%@include file="/WEB-INF/views/client/include/footer.jsp"%>



	<%@include file="/WEB-INF/views/client/include/script.jsp"%>



</body>
</html>