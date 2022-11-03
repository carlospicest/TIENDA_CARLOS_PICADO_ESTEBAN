<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, curso.java.tienda.index.pojo.Pedido,
			curso.java.tienda.index.pojo.Producto, curso.java.tienda.index.pojo.DetallePedido,
			curso.java.tienda.index.pojo.Usuario, curso.java.tienda.util.DateTime,
			curso.java.tienda.index.pojo.Categoria"%>
<%
ArrayList<Categoria> categoriaList = (ArrayList<Categoria>) request.getAttribute("categoriaList");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../WEB-INF/layouts/head.jspf"%>
</head>
<body>

	<%@ include file="../../WEB-INF/layouts/header.jspf"%>

	<!-- Start Userprofile -->

	<section id="contact-us" class="contact-us section">
		<div class="container">
			<div class="contact-head">
				<div class="row justify-content-md-center">
					<div class="col-lg-8 col-12">
						<div class="form-main">

							<h3 class="mb-4">Agregar nuevo producto</h3>

							<form class="form" method="POST" action="producto_agregar">
								<div class="row">
									<div class="col-12">
										<div class="form-group">
											<label>Nombre<span>*</span></label> <input name="nombre"
												type="text" placeholder="" value="">
										</div>
									</div>
									<div class="col-12">
										<div class="form-group">
											<label>Descripción</label>
											<textarea rows="2" maxlength="255" name="descripcion"></textarea>
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Categoría<span>*</span></label>
											
											<select
												name="categoria" id="categoria"
												style="display: block; border: 1px solid #e6e2f5; border-radius: 2px; height: 5.2vh; width: 100%; padding-left: 1.3vw;">
												<option value="default" selected>Seleccionar
													categoría</option>
												<% for (Categoria categoria : categoriaList) { %>
												<option value="<%=categoria.getId()%>"><%=categoria.getNombre()%></option>
												<% }%>
											</select>
											
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Precio<span>*</span></label> <input
												name="precio" type="number" step=".01" value="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Stock<span>*</span></label> <input name="stock"
												type="number" value="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Impuesto<span>*</span></label> <input
												name="impuesto" type="number" value="">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Baja de producto</label>
											<input type="checkbox" name="baja_producto" value="bajaProducto">
										</div>
									</div>
									<div class="col-lg-6 col-12">
										<div class="form-group">
											<label>Imágen del producto</label>
											<input type="file" name="baja_producto" value="Agregar imagen">
										</div>
									</div>
																		
									<div class="col-12">
										<div class="form-group button text-center">
											<button type="submit" class="btn mt-4">Agregar producto</button>
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