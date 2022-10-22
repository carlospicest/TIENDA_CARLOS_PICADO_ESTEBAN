<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../WEB-INF/layouts/index/head.jspf"%>
</head>
<body class="js">

	<!-- Preloader -->
	<div class="preloader">
		<div class="preloader-inner">
			<div class="preloader-icon">
				<span></span> <span></span>
			</div>
		</div>
	</div>
	<!-- End Preloader -->

	<%@ include file="../WEB-INF/layouts/index/header_without_category.jspf"%>

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
				<div class="row">
					<div class="col-lg-8 col-12">
						<div class="form-main">
							<div class="title">
								<h4>Get in touch</h4>
								<h3>Write us a message</h3>
							</div>
							<form class="form" method="post" action="mail/mail.php">
								<div class="row">
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Your Name<span>*</span></label> <input name="name"
												type="text" placeholder="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Your Subjects<span>*</span></label> <input
												name="subject" type="text" placeholder="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Your Email<span>*</span></label> <input name="email"
												type="email" placeholder="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Your Phone<span>*</span></label> <input
												name="company_name" type="text" placeholder="">
										</div>
									</div>
									<div class="col-12">
										<div class="form-group message">
											<label>your message<span>*</span></label>
											<textarea name="message" placeholder=""></textarea>
										</div>
									</div>
									<div class="col-12">
										<div class="form-group button">
											<button type="submit" class="btn ">Send Message</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="col-lg-4 col-12">
						<div class="single-head">
							<div class="single-info">
								<i class="fa fa-phone"></i>
								<h4 class="title">Call us Now:</h4>
								<ul>
									<li>+123 456-789-1120</li>
									<li>+522 672-452-1120</li>
								</ul>
							</div>
							<div class="single-info">
								<i class="fa fa-envelope-open"></i>
								<h4 class="title">Email:</h4>
								<ul>
									<li><a href="mailto:info@yourwebsite.com">info@yourwebsite.com</a></li>
									<li><a href="mailto:info@yourwebsite.com">support@yourwebsite.com</a></li>
								</ul>
							</div>
							<div class="single-info">
								<i class="fa fa-location-arrow"></i>
								<h4 class="title">Our Address:</h4>
								<ul>
									<li>KA-62/1, Travel Agency, 45 Grand Central Terminal, New
										York.</li>
								</ul>
							</div>
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

	<%@ include file="../WEB-INF/layouts/index/footer.jspf"%>

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