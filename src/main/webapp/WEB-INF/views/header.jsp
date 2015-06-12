<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | E-Shopper</title>
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/font-awesome.min.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/prettyPhoto.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/price-range.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/animate.css' />" rel="stylesheet">
	<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet">
	<link href="<c:url value='/resources/css/responsive.css' />" rel="stylesheet">
	<link href="<c:url value='/resources/css/chosen.min.css' />" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="<c:url value='/resources/js/html5shiv.js' />"></script>
    <script src="<c:url value='/resources/js/respond.min.js' />"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="<c:url value='/resources/images/ico/favicon.ico' />">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value='/resources/images/ico/apple-touch-icon-144-precomposed.png' />">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value='/resources/images/ico/apple-touch-icon-114-precomposed.png' />">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value='/resources/images/ico/apple-touch-icon-72-precomposed.png' />">
    <link rel="apple-touch-icon-precomposed" href="<c:url value='/resources/images/ico/apple-touch-icon-57-precomposed.png' />">
</head><!--/head-->

<body>
	
	<!-- HEADER -->
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> +55 11 999 999 999</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> contact@ecommerce.com</a></li>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="${pageContext.request.contextPath}/home/"><img src="<c:url value='/resources/images/home/logo.png' />" alt="" /></a>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="${pageContext.request.contextPath}/carrinho-compras/"><i class="fa fa-shopping-cart"></i> Carrinho de Compras</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	

	
	<!-- MENU -->
	<%@ include file="menu.jsp" %>
	
	</header><!--/header-->