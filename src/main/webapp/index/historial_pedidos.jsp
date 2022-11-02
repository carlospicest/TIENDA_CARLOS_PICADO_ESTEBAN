<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"
	import="java.util.LinkedHashMap, curso.java.tienda.index.pojo.Usuario,
			curso.java.tienda.index.pojo.Pedido, datos.EstadoPedido"%>
<%
LinkedHashMap<Integer, Pedido> pedidosList = (LinkedHashMap<Integer, Pedido>) request.getAttribute("pedidosList");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../WEB-INF/layouts/head.jspf"%>
<link rel="stylesheet" href="index/assets/css/button_icon_table.css">
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
								<h3 class="text-left">Historial de pedidos realizados</h3>
							</div>

							<div class="row">

								<div class="col-12">

									<table id="pedidoTable" class="table shopping-summery">
										<thead>
											<tr class="main-hading">
												<th class="align-middle">NUM FACTURA</th>
												<th class="align-middle">MÉTODO DE PAGO</th>
												<th class="align-middle">IMPORTE</th>
												<th class="align-middle">ESTADO</th>
												<th class="align-middle"></th>
											</tr>
										</thead>
										<tbody>

											<%
											for (Pedido pedido : pedidosList.values()) {
											%>
											<tr>
												<td class="align-middle text-center"><%=pedido.getNum_factura()%></td>
												<td class="align-middle text-center"><%=pedido.getMetodo_pago()%></td>
												<td class="align-middle text-center"><%=pedido.getTotal()%> €</td>
												<td class="align-middle text-center"><%=pedido.getEstado()%></td>
												<td class="align-middle text-center">
													<a title="Ver detalles del pedido" href="detalle_pedido?pedido=<%= pedido.getId() %>" target="_blank"><i class="bi bi-card-list icon_table" style="color: #F7941D;">
														</i>
													</a>
													
													<%
														switch (EstadoPedido.estado.getValueFromAlias(pedido.getEstado())) {
														
														case PENDIENTE_ENVIO:
													%>
													<a title="Cancelar pedido" href="cancelacion_pedido?pedido=<%= pedido.getId() %>" target="_blank"><i class="bi bi-send-slash-fill icon_table" style="color: #FF0000;">
														</i>
													</a>
													<%
															break;
															
														case PENDIENTE_CANCELACION:
															
													%>
													<a title="El pedido ha sido cancelado"><i class="bi bi-send-slash-fill icon_table">
														</i>
													</a>
													<%
													
															break;
															
														case CANCELADO:
														
															break;
														
														}
													
													
													%>
													
												</td>

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