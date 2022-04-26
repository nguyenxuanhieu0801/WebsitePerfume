<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <%@include file="/WEB-INF/views/admin/include/head.jsp"%>
  </head>

  <body class="hold-transition sidebar-mini">
    <div class="wrapper">
      <!-- Navbar -->
      <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" data-widget="pushmenu" href="#" role="button"
              ><i class="fas fa-bars"></i
            ></a>
          </li>
        </ul>
        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" data-widget="fullscreen" href="#" role="button">
              <i class="fas fa-expand-arrows-alt"></i>
            </a>
          </li>
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
					  <div class="alert alert-success" role="alert">
	  					${message}
					 </div>
				 </c:if>
                  <!-- content -->
                  <form:form
                    action="/admin/categories/update/${category.categoryId}"
                    method="POST"
                    modelAttribute="category"
                  >
                    <div class="card-body">
                      <div class="form-group">
                        <label for="menu">Tên Danh Mục 2</label>
                        <form:input
                          type="text"
                          path="name"                          
                          cssClass="form-control"
                          placeholder="Nhập tên danh mục"
                        />
                         <form:errors path="name" cssClass="text-danger"/>    
                      </div>
                      <div class="form-group">
                        <label>Mô Tả </label>
                        <form:textarea path="description" cssClass="form-control"></form:textarea>
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
        <div class="float-right d-none d-sm-block"><b>Version</b> 3.1.0</div>
        <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>. </strong>
        All rights reserved.
      </footer>
    </div>
    <!-- ./wrapper -->
    <%@include file="/WEB-INF/views/admin/include/footer.jsp"%>
  </body>
</html>
