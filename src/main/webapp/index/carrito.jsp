<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, java.util.ArrayList, java.util.HashMap, curso.java.tienda.index.pojo.Categoria, curso.java.tienda.index.pojo.Producto"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../WEB-INF/layouts/head.jspf"%>
</head>
<body>

	<%@ include file="../WEB-INF/layouts/header.jspf"%>

	<!-- Shopping Cart -->
	<div class="shopping-cart section">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<!-- Shopping Summery -->
					<table class="table shopping-summery" id="cartTable">
						<thead>
							<tr class="main-hading">
								<th class="align-middle">PRODUCTO</th>
								<th class="align-middle">NOMBRE</th>
								<th class="align-middle">PRECIO UNITARIO</th>
								<th class="align-middle">CANTIDAD</th>
								<th class="align-middle">TOTAL</th>
								<th class="align-middle"><i class="ti-trash remove-icon"></i></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="image" data-title="No"><img
									src="https://via.placeholder.com/100x100" alt="#"></td>
								<td class="product-des" data-title="Description">
									<p class="product-name">
										<a href="#">{NOMBRE_PRODUCTO}</a>
									</p>
									<p class="product-des">{DESCRIPCION_PRODUCTO}.</p>
								</td>
								<td class="price" data-title="Price"><span>{PRECIO}</span></td>
								<td class="qty" data-title="Qty">
									<!-- Input Order -->
									<div class="input-group">
										<div class="button minus">
											<button type="button" class="btn btn-primary btn-number"
												disabled="disabled" data-type="minus" data-field="quant[id_prod]">
												<i class="ti-minus"></i>
											</button>
										</div>
										<input type="text" name="quant[id_prod]" class="input-number"
											data-min="1" data-max="100" value="1">
										<div class="button plus">
											<button type="button" class="btn btn-primary btn-number"
												data-type="plus" data-field="quant[id_prod]">
												<i class="ti-plus"></i>
											</button>
										</div>
									</div> <!--/ End Input Order -->
								</td>
								<td class="total-amount" data-title="Total"><span>{PRECIO_TOTAL}</span></td>
								<td class="action" data-title="Remove"><a href="#"><i
										class="ti-trash remove-icon"></i></a></td>
							</tr>

						</tbody>
					</table>
					<!--/ End Shopping Summery -->
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<!-- Total Amount -->
					<div class="total-amount">
						<div class="row">
							<div class="col-lg-8 col-md-5 col-12">
								<div class="left">
									<div class="coupon d-none">
										<form action="#" target="_blank">
											<input name="Coupon" placeholder="Enter Your Coupon">
											<button class="btn">Apply</button>
										</form>
									</div>
									<div class="checkbox d-none">
										<label class="checkbox-inline" for="2"><input
											name="news" id="2" type="checkbox"> Shipping (+10$)</label>
									</div>
								</div>
							</div>
							<div class="col-lg-4 col-md-7 col-12">
								<div class="right">
									<ul>
										<li>Importe total
											<span id="cart_resume_total_amount"></span>
										</li>
										<li class="d-none">Shipping<span>Free</span></li>
										<li class="d-none">You Save<span>$20.00</span></li>
										<li class="last d-none">You Pay<span>$310.00</span></li>
									</ul>
									<div class="button5">
										<a href="pago" class="btn">Realizar pago</a> 
										<a href="catalogo" class="btn">Continuar comprando</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--/ End Total Amount -->
				</div>
			</div>
		</div>
	</div>
	<!--/ End Shopping Cart -->


	<!-- Modal end -->

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