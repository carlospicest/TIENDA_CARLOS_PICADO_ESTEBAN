<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"
	import="com.fasterxml.jackson.databind.ObjectMapper, com.fasterxml.jackson.databind.node.ObjectNode, 
			com.fasterxml.jackson.databind.JsonNode,mapping.Request"%>

<%
String errorLogin = (String) request.getAttribute("errorLogin");
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../../WEB-INF/layouts/head.jspf"%>
<link rel="stylesheet" href="index/assets/css/icon_custom.css">
</head>
<body class="js">

	<%@ include file="../../WEB-INF/layouts/header.jspf"%>

	<!-- Breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="bread-inner">
						<ul class="bread-list">
							<li><a href="index1.html">Home<i class="ti-arrow-right"></i></a></li>
							<li class="active"><a href="blog-single.html">Contact</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Breadcrumbs -->

	<!-- Start Login -->
	<section id="contact-us" class="contact-us section">
		<div class="container">
			<div class="contact-head">
				<div class="row justify-content-md-center">
					<div class="col-lg-8 col-12">
						<div class="form-main">

							<div class="title">
								<h3 class="text-center">Iniciar sesión</h3>
							</div>

							<form class="form" method="POST" action="login">

								<div class="row justify-content-center">

									<div class="col-lg-6 col-12">

										<%
										if (errorLogin != null) {
										%>

										<div class="alert alert-warning mb-5" role="alert"><%=errorLogin%></div>

										<%
										}
										%>
										
										<div class="form-group">
											<label class="control-label" for="email">Email</label>
											<div class="input-group">
												<div class="input-group-addon">
													<i class="bi bi-at"></i>
												</div>
												<input class="form-control" id="email"
													name="email" type="email" />
											</div>
										</div>
										

										<div class="form-group">
											<label class="control-label" for="password">Contraseña</label>
											<div class="input-group">
												<div class="input-group-addon">
													<i class="bi bi-eye-fill"></i>
												</div>
												<input class="form-control" id="password" name="password"
													type="password" />
											</div>
										</div>

									</div>

									<div class="col-12 mt-4">
										<div class="form-group button text-center">
											<button type="submit" class="btn">Iniciar sesión</button>
										</div>
									</div>
								</div>

							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ End Login -->

	<%@ include file="../../WEB-INF/layouts/footer.jspf"%>

	<!-- Jquery -->
	<script src="index/assets/js/jquery.min.js"></script>
	<script src="index/assets/js/jquery-migrate-3.0.0.js"></script>
	<script src="index/assets/js/jquery-ui.min.js"></script>
	<!-- Popper JS -->
	<script src="index/assets/js/popper.min.js"></script>
	<!-- Bootstrap JS -->
	<script src="index/assets/js/bootstrap.min.js"></script>
	<!-- Slicknav JS -->
	<script src="index/assets/js/slicknav.min.js"></script>
	<!-- Owl Carousel JS -->
	<script src="index/assets/js/owl-carousel.js"></script>
	<!-- Magnific Popup JS -->
	<script src="index/assets/js/magnific-popup.js"></script>
	<!-- Waypoints JS -->
	<script src="index/assets/js/waypoints.min.js"></script>
	<!-- Countdown JS -->
	<script src="index/assets/js/finalcountdown.min.js"></script>
	<!-- Nice Select JS -->
	<script src="index/assets/js/nicesellect.js"></script>
	<!-- Flex Slider JS -->
	<script src="index/assets/js/flex-slider.js"></script>
	<!-- ScrollUp JS -->
	<script src="index/assets/js/scrollup.js"></script>
	<!-- Onepage Nav JS -->
	<script src="index/assets/js/onepage-nav.min.js"></script>
	<!-- Easing JS -->
	<script src="index/assets/js/easing.js"></script>
	<!-- Active JS -->
	<script src="index/assets/js/active.js"></script>
	<!-- Common settings -->
	<script src="index/assets/js/common-settings.js"></script>
	<!-- Shop -->
	<script src="index/assets/js/shop.js"></script>
	<!-- Login -->
	<script src="index/assets/js/password_field.js"></script>

</body>
</html>