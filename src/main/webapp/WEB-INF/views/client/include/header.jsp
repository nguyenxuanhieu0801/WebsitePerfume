<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <header>
      <!-- Header desktop -->
      <div class="container-menu-desktop">
        <div class="wrap-menu-desktop">
          <nav class="limiter-menu-desktop container">
            <!-- Logo desktop -->
            <a href="/" class="logo">
              <img src="/template/images/icons/logo-01.png" alt="IMG-LOGO" />
            </a>

            <!-- Menu desktop -->
            <div class="menu-desktop">
              <ul class="main-menu">
                <li class="active-menu">
                  <a href="/">Home</a>
                   <!--
                  <ul class="sub-menu">
                    <li><a href="index.html">Homepage 1</a></li>
                    <li><a href="home-02.html">Homepage 2</a></li>
                    <li><a href="home-03.html">Homepage 3</a></li>
                  </ul>
                -->
                </li>

                <li>
                  <a href="/products">Product</a>
                </li>

              </ul>
            </div>

            <!-- Icon header -->
            <div class="wrap-icon-header flex-w flex-r-m main-menu">
              

              <div
                class="
                  icon-header-item
                  cl2
                  hov-cl1
                  trans-04
                  p-l-22 p-r-11
                  icon-header-noti
                  js-show-cart
                "
                data-notify="${cartCounter}"
              >
              	<a href="/cart" style="color: rgb(81 88 136)
">
              	<i class="zmdi zmdi-shopping-cart"></i>
              	</a>
                
              </div>
				<c:if test="${user != null }">
				
			
				
              <div
                class="
                  dis-block
                  icon-header-item
                  cl2
                  hov-cl1
                  trans-04
                  p-l-22 p-r-11
                  dropdown
                "
              >
                <i class="zmdi zmdi-account"></i>  
                <div class="dropdown-content">
				  <a href="/user/profile">Profile</a>
				  <a href="/user/orders">Order</a>
				  <a href="/logout">Logout</a>
				  </div>                       
              </div>
              	</c:if>
              	<c:if test="${user == null }">
				
			
				
              <a
              	href="/login"
                class="
                  dis-block
                  icon-header-item
                  cl2
                  hov-cl1
                  trans-04
                  p-l-22 p-r-11
                "
              >
                <i class="zmdi zmdi-account"></i>                           
              </a>
              	</c:if>
            </div>
          </nav>
        </div>
      </div>

      <!-- Header Mobile   -->
      <div class="wrap-header-mobile">
        <div class="logo-mobile">
          <a href="/"><img src="/template/images/icons/logo-01.png" alt="IMG-LOGO" /></a>
        </div>

        <div class="wrap-icon-header flex-w flex-r-m m-r-15">
         

          <div
            class="
              icon-header-item
              cl2
              hov-cl1
              trans-04
              p-r-11 p-l-10
              icon-header-noti
              js-show-cart
            "
          data-notify="${cartCounter}"

          >
            <i class="zmdi zmdi-shopping-cart"></i>
          </div>

          <div
            class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10                   dropdown
            "
          >
                <i class="zmdi zmdi-account"></i>  
            <div class="dropdown-content">
				   <a href="user/profile">Profile</a>
				  <a href="/orders">Đơn hàng</a>
				  <a href="/logout">Logout</a>
				  </div> 
          </div>
        </div>

        <div class="btn-show-menu-mobile hamburger hamburger--squeeze">
          <span class="hamburger-box">
            <span class="hamburger-inner"></span>
          </span>
        </div>
      </div>

      <div class="menu-mobile">
          <ul class="main-menu-m">
          <li>
            <a href="index.html">Home</a>
             <!--
            <ul class="sub-menu-m">
              <li><a href="index.html">Homepage 1</a></li>
              <li><a href="home-02.html">Homepage 2</a></li>
              <li><a href="home-03.html">Homepage 3</a></li>
            </ul>
            -->
            <span class="arrow-main-menu-m">
              <i class="fa fa-angle-right" aria-hidden="true"></i>
            </span>
          </li>

          <li>
            <a href="/products">Sản phẩm</a>
          </li>




        </ul>
      </div>

    </header>