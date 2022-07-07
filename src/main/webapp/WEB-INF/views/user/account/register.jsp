<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
</head>
<body>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">

					<c:forEach var="item" items="${categorys }">
						<li><a href='<c:url value="/san-pham/${item.id }" />'><span
								class="icon-circle-blank"></span>${item.name }</a></li>
						<li>
					</c:forEach>



					<li><a class="totalInCart" href="cart.html"><strong>
								Đã mua<span class="badge badge-warning pull-right"
								style="line-height: 18px;"><fmt:formatNumber
													type="number" groupingUsed="true" value="${ TotalPriceCart }" />₫ </span>
						</strong></a></li>
				</ul>
			</div>

			<div class="well well-small alert alert-warning cntr">
				<h2>50% Discount</h2>
				<p>
					only valid for online order. <br> <br> <a
						class="defaultBtn" href="#">Click here </a>
				</p>
			</div>
			<div class="well well-small">
				<a href="#"><img
					src="<c:url value ="/assets/user/img/paypal.jpg"></c:url>"
					alt="payment method paypal"></a>
			</div>

			<a class="shopBtn btn-block" href="#">Upcoming products <br>
				<small>Click to view</small></a> <br> <br>
			<ul class="nav nav-list promowrapper">
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img src="assets/user/img/bootstrap-ecommerce-templates.png"
							alt="bootstrap ecommerce templates">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img
							src="<c:url value ="/assets/user/img/shopping-cart-template.png"></c:url>"
							alt="shopping cart template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img
							src="<c:url value ="assets/user/img/bootstrap-template.png"></c:url>"
							alt="bootstrap template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
			</ul>

		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Người dùng</li>
			</ul>
			<h3>Người dùng</h3>
			<hr class="soft" />

			<div class="row">
				<div class="span4">
					<div class="well">
						<h5>Đăng ký tài khoản</h5>
						
						
						<br />
						 
						<form:form action="dang-ky" method ="POST" modelAttribute="user">  
							<div class="control-group">
								<label class="control-label" for="inputEmail">E-mail
									address</label>
								<div class="controls">
					
									<form:input type="email" class="span3" placeholder="Email" path="user" /> 
								</div>  
								
								<label class="control-label" for="inputEmail">Mật khẩu</label>
								<div class="controls">
									
									<form:input type="password" class="span3" placeholder="Mật khẩu" path="password" /> 
								</div>  
								
								<label class="control-label" for="inputEmail">Họ và tên</label>
								<div class="controls">
									
									<form:input type="text" class="span3" placeholder="Họ và tên" path="displayName" /> 
								</div>  
								
								<label class="control-label" for="inputEmail">Địa chỉ</label>
								<div class="controls">
									 
									<form:input type="text" class="span3" placeholder="Địa chỉ" path="address" /> 
								</div>
							</div>
							<div class="controls">
								<button type="submit" class="btn block">Tạo tài khoản</button>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
				<div class="span4">
					<div class="well">
						<h5>Đăng nhập hệ thống</h5>
						
						<form:form action="dang-nhap" method ="POST" modelAttribute="user">  
							<div class="control-group">
								<label class="control-label" for="inputEmail">Tài khoản</label>
								<div class="controls"> 
								   <form:input type="email" class="span3" placeholder="Nhập tài khoản" path="user" /> 
									
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Mật khẩu</label>
								<div class="controls">
									 <form:input type="password" class="span3" placeholder="Nhập mật khẩu" path="password" /> 
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="defaultBtn">Đăng nhập</button>
									<a href="#">Forget password?</a>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>