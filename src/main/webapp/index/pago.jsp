<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.HashMap, curso.java.tienda.index.pojo.Categoria,
	curso.java.tienda.index.pojo.MetodoPago, curso.java.tienda.index.pojo.Producto, 
	com.fasterxml.jackson.databind.ObjectMapper, com.fasterxml.jackson.databind.node.ObjectNode, 
	com.fasterxml.jackson.databind.JsonNode,mapping.Request"%>

<%
HashMap<Integer, MetodoPago> metodoPagoList = (HashMap<Integer, MetodoPago>) request.getAttribute("paymentMethods");
String paymentData = (String) request.getAttribute("paymentDetails");
JsonNode paymentDetails = null;

if (paymentData != null) {
	paymentDetails = new ObjectMapper().readTree(paymentData);
}
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../WEB-INF/layouts/head.jspf"%>
</head>
<body>

	<%@ include file="../WEB-INF/layouts/header.jspf"%>

	<!-- Start Checkout -->
	<section class="shop checkout section">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-12">
					<div class="checkout-form">
						<h2>Datos personales</h2>
						<hr />
						<!-- Información del usuario -->

						<!-- <div class="container-fluid">
							<div class="row">
								<div class="col-2">
									<h6>Nombre: </h6>
								</div>
								<div class="col-3">
									<label for="" class="d-block"user.getNombre()e() %></label>
								</div>
							</div>
						</div> -->

						<div class="container">
							<div class="row mb-4">
								<div class="col-sm">
									<h6>Nombre:</h6>
								</div>
								<div class="col-sm">
									<label for="" class="d-block"><%=user.getNombre()%></label>
								</div>
								<div class="col-sm">
									<h6>Apellidos:</h6>
								</div>
								<div class="col-sm">
									<label for="" class="text-left"><%=user.getApellido1() + " " + user.getApellido2()%></label>
								</div>
							</div>
							<div class="row mb-4">
								<div class="col-sm">
									<h6>Dirección:</h6>
								</div>
								<div class="col-sm">
									<label for="" class="d-block"><%=user.getDireccion()%></label>
								</div>
								<div class="col-sm">
									<h6>Localidad:</h6>
								</div>
								<div class="col-sm">
									<label for="" class="text-left"><%=user.getLocalidad()%></label>
								</div>
							</div>
							<div class="row mb-4">
								<div class="col-sm">
									<h6>Provincia:</h6>
								</div>
								<div class="col-sm">
									<label for="" class="d-block"><%=user.getProvincia()%></label>
								</div>
								<div class="col-sm">
									<h6>Teléfono:</h6>
								</div>
								<div class="col-sm">
									<label for="" class="text-left"><%=user.getTelefono()%></label>
								</div>
							</div>
						</div>


					</div>
				</div>
				<div class="col-lg-4 col-12">
					<div class="order-details">
						<!-- Order Widget -->
						<div class="single-widget">
							<h2>DETALLES DE PAGO</h2>
							<div class="content">
								<ul>
									<li>Importe<span><%=paymentDetails.get("total_without_IVA").asText()%>
											€</span></li>
									<li>IVA <%=paymentDetails.get("IVA_tax").asText()%>%<span><%=paymentDetails.get("total_with_IVA").asText()%>
											€</span></li>
									<li class="last">Total<span><%=paymentDetails.get("total").asText()%>
											€</span></li>
								</ul>
							</div>
						</div>
						<!--/ End Order Widget -->
						<!-- Order Widget -->

						<form action="checkout" method="POST">

							<div class="single-widget">
								<h2>Métodos de pago disponibles</h2>
								<div class="content"></div>
							</div>

							<div class="container-fluid">

								<div class="row justify-content-center">

									<%
									for (MetodoPago metodo : metodoPagoList.values()) {
									%>
									<div class="col-6 pl-4">
										<label for="<%=metodo.getMetodo_pago()%>" class="d-block">
											<input name="paymentMethod" id="<%=metodo.getMetodo_pago()%>"
											type="radio" value="<%=metodo.getMetodo_pago()%>"> <%=metodo.getMetodo_pago()%>
										</label>

									</div>
									<%
									}
									%>
								</div>

							</div>

							<!--/ End Order Widget -->
							<!-- Payment Method Widget -->
							<div class="single-widget payement">
								<div class="content">
									<img src="index/assets/images/payment-method.png" alt="#">
								</div>
							</div>
							<!--/ End Payment Method Widget -->
							<!-- Button Widget -->
							<div class="single-widget get-button">
								<div class="content">
									<div class="button">
										<input type="submit" class="btn mb-2" id="doPayment" value="Realizar pago" disabled="disabled">
										<button class="btn" id="cart">Volver al carrito</button>
									</div>
								</div>
							</div>
							<!--/ End Button Widget -->
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ End Checkout -->

	<!-- Start Shop Services Area  -->
	<section class="shop-services section home">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6 col-12">
					<!-- Start Single Service -->
					<div class="single-service">
						<i class="ti-rocket"></i>
						<h4>Free shiping</h4>
						<p>Orders over $100</p>
					</div>
					<!-- End Single Service -->
				</div>
				<div class="col-lg-3 col-md-6 col-12">
					<!-- Start Single Service -->
					<div class="single-service">
						<i class="ti-reload"></i>
						<h4>Free Return</h4>
						<p>Within 30 days returns</p>
					</div>
					<!-- End Single Service -->
				</div>
				<div class="col-lg-3 col-md-6 col-12">
					<!-- Start Single Service -->
					<div class="single-service">
						<i class="ti-lock"></i>
						<h4>Sucure Payment</h4>
						<p>100% secure payment</p>
					</div>
					<!-- End Single Service -->
				</div>
				<div class="col-lg-3 col-md-6 col-12">
					<!-- Start Single Service -->
					<div class="single-service">
						<i class="ti-tag"></i>
						<h4>Best Peice</h4>
						<p>Guaranteed price</p>
					</div>
					<!-- End Single Service -->
				</div>
			</div>
		</div>
	</section>
	<!-- End Shop Services -->

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
	<!-- Pago JS -->
	<script src="index/assets/js/pago.js"></script>

</body>
</html>