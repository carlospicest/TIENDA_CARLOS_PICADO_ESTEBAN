<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%
String errorChangePassword = (String) request.getAttribute("errorChangePassword");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../WEB-INF/layouts/head.jspf"%>
<link rel="stylesheet" href="index/assets/css/icon_custom.css">
</head>
<body>

	<%@ include file="../WEB-INF/layouts/header.jspf"%>

	<!-- Start Userprofile -->

	<section id="contact-us" class="contact-us section">
		<div class="container">
			<div class="contact-head">
				<div class="row justify-content-md-center">
					<div class="col-lg-8 col-12">
						<div class="form-main">


							<div class="title">
								<h3 class="text-left">Modificar contraseña</h3>
							</div>

							<form class="form" method="POST" action="password_update">
								<div class="row justify-content-center">

									<div class="col-lg-6 col-12">

										<%
										if (errorChangePassword != null) {
										%>

										<div class="alert alert-warning mb-5" role="alert"><%=errorChangePassword%></div>

										<%
										}
										%>

										<div class="form-group">
											<label class="control-label" for="current_password">Contraseña
												actual</label>
											<div class="input-group">
												<div class="input-group-addon">
													<i class="bi bi-eye-fill"></i>
												</div>
												<input class="form-control" id="current_password"
													name="current_password" type="password" />
											</div>
										</div>

										<div class="form-group">
											<label class="control-label" for="current_password_repeat">Repetir
												contraseña actual</label>
											<div class="input-group">
												<div class="input-group-addon">
													<i class="bi bi-eye-fill"></i>
												</div>
												<input class="form-control" id="current_password_repeat"
													name="current_password_repeat" type="password" />
											</div>
										</div>

										<div class="form-group">
											<label class="control-label" for="password">Nueva
												contraseña</label>
											<div class="input-group">
												<div class="input-group-addon">
													<i class="bi bi-eye-fill"></i>
												</div>
												<input class="form-control" id="password"
													name="password" type="password" />
											</div>
										</div>

									</div>

									<div class="col-12 mt-4">
										<div class="form-group button text-center">
											<button type="submit" class="btn">Actualizar contraseña</button>
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
	<!-- End Userprofile -->

	<%@ include file="../WEB-INF/layouts/footer.jspf"%>

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
	<!-- <script src="index/assets/js/nicesellect.js"></script> -->
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
	<!-- Shop JS -->
	<script src="index/assets/js/shop.js"></script>
	<!-- Login -->
	<script src="index/assets/js/password_field.js"></script>

</body>
</html>