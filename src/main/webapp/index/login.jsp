<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"
	import="com.fasterxml.jackson.databind.ObjectMapper, com.fasterxml.jackson.databind.node.ObjectNode, 
			com.fasterxml.jackson.databind.JsonNode,mapping.Request"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../../WEB-INF/layouts/resultado/head.jspf"%>
</head>
<body class="js">

	<%@ include
		file="../../WEB-INF/layouts/resultado/header_without_category.jspf"%>

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

	<!-- Start Contact -->
	<section id="contact-us" class="contact-us section">
		<div class="container">
			<div class="contact-head">
				<div class="row justify-content-md-center">
					<div class="col-lg-8 col-12">
						<div class="form-main">

							<div class="title">
								<h3 class="text-center">Iniciar sesión</h3>
							</div>

							<form class="form" method="POST" action="">
							
								<div class="row justify-content-center">
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Email<span>*</span></label> <input name="email"
												type="email" placeholder="">
										</div>
										<div class="form-group">
											<label>Contraseña<span>*</span></label> <input name="password"
												type="password" placeholder="">
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
	<!--/ End Contact -->

	<!-- Start Shop Newsletter  -->
	<section class="shop-newsletter section">
		<div class="container">
			<div class="inner-top">
				<div class="row">
					<div class="col-lg-8 offset-lg-2 col-12">
						<!-- Start Newsletter Inner -->
						<div class="inner">
							<h4>Newsletter</h4>
							<p>
								Subscribe to our newsletter and get <span>10%</span> off your
								first purchase
							</p>
							<form action="mail/mail.php" method="get" target="_blank"
								class="newsletter-inner">
								<input name="EMAIL" placeholder="Your email address" required=""
									type="email">
								<button class="btn">Subscribe</button>
							</form>
						</div>
						<!-- End Newsletter Inner -->
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Shop Newsletter -->
	<!-- Modal end -->

	<%@ include file="../../WEB-INF/layouts/resultado/footer.jspf"%>

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

</body>
</html>