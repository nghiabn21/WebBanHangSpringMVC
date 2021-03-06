<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="path/to/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
<header id="header">
	<div class="row">
		<div class="span4">
			<h1>
				<a class="logo" href="index.html"><span>Template</span> <img
					src="<c:url value ="/assets/user/img/logo-bootstrap-shoping-cart.png"></c:url>"
					alt="bootstrap sexy shop"> </a>
			</h1>
		</div>
		<div class="span4">
			<div class="offerNoteWrapper">
				
			</div>
		</div>
		<div class="span4 alignR">
			<p>
				<br> <br>
				<br>
			</p>
			<span class="btn btn-mini">[ ${ TotalQuantyCart }]<span
				class="icon-shopping-cart"></span></span> <span
				class="btn btn-warning btn-mini">$</span> <span class="btn btn-mini">&pound;</span>
			<span class="btn btn-mini">&euro;</span>
		</div>
	</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
				<ul class="nav">

					<c:forEach var="item" items="${menus}" varStatus="index">
						<c:if test="${index.first }">
							<li class="active">
						</c:if>
						<c:if test="${not index.first }">
							<li class="">
						</c:if>
						<a href="<c:url value ="/${item.url}"></c:url>">${item.name } </a>
						</li>
					</c:forEach>




				</ul>
				<form action="#" class="navbar-search pull-left">
					<input type="text" placeholder="Search" class="search-query span2">
				</form>
				<ul class="nav pull-right">

					<c:if test="${ empty LoginInfo }">
						<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#"><span class="icon-lock"></span>
								????ng nh???p <b class="caret"></b></a>
							<div class="dropdown-menu">
								<form class="form-horizontal loginFrm">
									<div class="control-group">
										<input type="text" class="span2" id="inputEmail" placeholder="Email">
									</div>
									<div class="control-group">
										<input type="password" class="span2" id="inputPassword" placeholder="Password">
									</div>
									<div class="control-group">
										<label class="checkbox"> <input type="checkbox">
											Remember me
										</label>
										<button type="submit" class="shopBtn btn-block">Sign in</button>
									</div>
								</form>
							</div></li>
					</c:if>

					<c:if test="${ not empty LoginInfo }">
						<li><a href="#">${ LoginInfo.displayName } <b
								class="caret"></b></a></li>
					</c:if>

				</ul>
			</div>
		</div>
	</div>
</div>