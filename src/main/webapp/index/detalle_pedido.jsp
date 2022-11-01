<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, curso.java.tienda.index.pojo.Pedido,
			curso.java.tienda.index.pojo.Producto, curso.java.tienda.index.pojo.DetallePedido,
			curso.java.tienda.index.pojo.Usuario, curso.java.tienda.util.DateTime"%>
<%
ArrayList<DetallePedido> detallePedido = (ArrayList<DetallePedido>) request.getAttribute("detallePedido");
Usuario usuario = detallePedido.get(0).getPedido().getUsuario();
Pedido pedido = detallePedido.get(0).getPedido();
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../WEB-INF/layouts/head.jspf"%>
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
							
							<h3 class="mb-4">Detalle del pedido</h3>

							<fieldset class="mb-4">

								<legend>Datos del usuario</legend>

								<div class="container">
									<div class="row">
										<div class="col-2 font-weight-bold">Nombre:</div>
										<div class="col-4"><%=usuario.getNombre()%></div>
										<div class="col-2 font-weight-bold">Apellidos:</div>
										<div class="col-4"><%=usuario.getApellido1() + " " + usuario.getApellido2()%></div>
									</div>
									<div class="row">
										<div class="col-2 font-weight-bold">Dirección:</div>
										<div class="col-10"><%=usuario.getDireccion()%></div>
									</div>
									<div class="row">
										<div class="col-2 font-weight-bold">Provincia:</div>
										<div class="col-4"><%=usuario.getProvincia()%></div>
										<div class="col-2 font-weight-bold">Localidad:</div>
										<div class="col-4"><%=usuario.getLocalidad()%></div>
									</div>
									<div class="row">
										<div class="col-2 font-weight-bold">DNI:</div>
										<div class="col-4"><%=usuario.getDni()%></div>
									</div>
								</div>

							</fieldset>



							<fieldset class="mb-4">

								<legend>Datos del pedido</legend>

								<div class="container">
									<div class="row align-items-center mb-3">
										<div class="col-2 font-weight-bold">Num Factura:</div>
										<div class="col-4"><%=pedido.getNum_factura()%></div>
										<div class="col-2 font-weight-bold">Método de pago:</div>
										<div class="col-4"><%=pedido.getMetodo_pago()%></div>
									</div>
									<div class="row align-items-center mb-3">

										<div class="col-2 font-weight-bold">Importe total:</div>
										<div class="col-4"><%=pedido.getTotal()%>
											€
										</div>

										<div class="col-2 font-weight-bold">Fecha:</div>
										<div class="col-4"><%=DateTime.getFormat(pedido.getFecha(), "dd.MM.yyyy HH.mm.ss")%></div>

									</div>
									<div class="row align-items-center">
										<div class="col-2 font-weight-bold">Estado del pedido:</div>
										<div class="col-4"><%=pedido.getEstado()%></div>
										<div class="col-2 font-weight-bold">Cantidad de productos:</div>
										<div class="col-4"><%=detallePedido.size()%></div>
									</div>
								</div>

							</fieldset>



							<table id="detallePedidoTable" class="table shopping-summery">
								<thead>
									<tr class="main-hading">
										<th class="align-middle">PRODUCTO</th>
										<th class="align-middle">UNIDADES</th>
										<th class="align-middle">PRECIO UNIDAD</th>
										<th class="align-middle">TOTAL</th>
									</tr>
								</thead>
								<tbody>

									<%
									for (DetallePedido detalle : detallePedido) {
									%>
									<tr>
										<td><%=detalle.getProducto().getNombre()%></td>
										<td class="text-center"><%=detalle.getUnidades()%></td>
										<td class="text-center"><%=detalle.getPrecio_unidad()%> €</td>
										<td class="text-center"><%=detalle.getTotal()%> €</td>
									</tr>
									<%
									}
									%>

								</tbody>
							</table>

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

</body>
</html>