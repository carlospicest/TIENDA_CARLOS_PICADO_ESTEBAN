<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="curso.java.tienda.index.pojo.Usuario, java.util.List, java.util.ArrayList" %>
<% 
	ArrayList<String> provinciasList = (ArrayList<String>) request.getAttribute("provinciasList");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../WEB-INF/layouts/head.jspf"%>
</head>
<body>

	<%@ include file="../WEB-INF/layouts/header.jspf" %>

	<!-- Start Userprofile -->
	
	<section id="contact-us" class="contact-us section">
		<div class="container">
			<div class="contact-head">
				<div class="row justify-content-md-center">
					<div class="col-lg-8 col-12">
						<div class="form-main">


							<div class="title">
								<h3 class="text-left">Perfil de usuario</h3>
							</div>

							<form class="form" method="POST" action="registro">
								<div class="row">
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Nombre<span>*</span></label> <input name="nombre"
												type="text" placeholder="" value="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Primer apellido<span>*</span></label> <input
												name="primer_apellido" type="text" placeholder=""
												value="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Segundo apellido<span>*</span></label> <input
												name="segundo_apellido" type="text" value="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>DNI<span>*</span></label> <input name="dni"
												type="text" value="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Dirección<span>*</span></label> <input
												name="direccion" type="text" value="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Provincia<span>*</span></label> 
											<select
												name="provincia" id="provincia"
												style="display: block; border: 1px solid #e6e2f5; border-radius: 2px; height: 5.2vh; width: 100%; padding-left: 1.3vw;">
												<option value="default" selected>Seleccionar
													provincia</option>
												<% for (String provincia : provinciasList) { %>
												<option value="<%=provincia%>"><%=provincia%></option>
												<% }%>
											</select>
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Localidad<span>*</span></label> <input
												name="localidad" type="text" value="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Teléfono<span>*</span></label> <input name="telefono"
												type="text" value="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Email<span>*</span></label> <input name="email"
												type="email" value="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Contraseña<span>*</span></label> <input
												name="password" type="password"
												autocomplete="current-passowrd" value="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Repetir contraseña<span>*</span></label> <input
												name="repassword" type="password"
												autocomplete="current-passowrd" value="">
										</div>
									</div>

									<div class="col-12">
										<div class="form-group button text-center">
											<button type="submit" class="btn mt-4">Crear cuenta</button>
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
	<!-- Shop JS -->
	<script src="index/assets/js/shop.js"></script>

</body>
</html>