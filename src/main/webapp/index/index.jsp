<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, java.util.HashMap, curso.java.tienda.index.pojo.Categoria,curso.java.tienda.index.dao.CategoriaDAOImpl,curso.java.tienda.index.pojo.Producto, curso.java.tienda.index.dao.ProductoDAOImpl"%>
<%
HashMap<Integer, Producto> productosList = (HashMap<Integer, Producto>) request.getAttribute("productosList");
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../WEB-INF/layouts/head.jspf" %>
<body class="js">

	<%@ include file="../WEB-INF/layouts/header.jspf" %>

	<!-- Slider Area -->
	<section class="hero-slider">
		<!-- Single Slider -->
		<div class="single-slider">
			<div class="container">
				<div class="row no-gutters">
					<div class="col-lg-9 offset-lg-3 col-12">
						<div class="text-inner">
							<div class="row">
								<div class="col-lg-7 col-12">
									<div class="hero-text">
										<h1>
											<span>UP TO 50% OFF </span>Shirt For Man
										</h1>
										<p>
											Maboriosam in a nesciung eget magnae <br> dapibus
											disting tloctio in the find it pereri <br> odiy
											maboriosm.
										</p>
										<div class="button">
											<a href="#" class="btn">Shop Now!</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/ End Single Slider -->
	</section>
	<!--/ End Slider Area -->

	<!-- Start Product Area -->
	<div class="product-area section">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section-title">
						<h2>Catálogo</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="product-info">
						<div class="nav-main">
							<!-- Tab Nav (Filtros básicos) -->
							<ul class="nav nav-tabs" id="myTab" role="tablist">
								<li class="nav-item"><a class="nav-link active"
									data-toggle="tab" href="#variado" role="tab">VARIADO</a></li>
								<li class="nav-item"><a class="nav-link" data-toggle="tab"
									href="#man" role="tab">MÁS VENDIDOS</a></li>
								<li class="nav-item"><a class="nav-link" data-toggle="tab"
									href="#women" role="tab">TEMPORADA</a></li>
							</ul>
							<!--/ End Tab Nav -->
						</div>
						<div class="tab-content" id="myTabContent">

							<!-- Start Variado Tab -->

							<div class="tab-pane fade show active" id="variado"
								role="tabpanel">
								<div class="tab-single">
									<div class="row">

										<%
										for (Producto producto : productosList.values()) {
										%>
										<div class="col-xl-3 col-lg-4 col-md-4 col-12">
											<div class="single-product">
												<div class="product-img">
													<a href="product-details.html"> <img
														class="default-img"
														src="https://via.placeholder.com/550x750" alt="#"> <img
														class="hover-img"
														src="https://via.placeholder.com/550x750" alt="#">
													</a>
													<div class="button-head">
														<div class="product-action">
															<a id="<%=producto.getId()%>" class="product_modal"
																title="Quick View" href="#" data-toggle="modal"
																data-target="#exampleModal"><i class=" ti-eye"></i><span>Ver
																	información</span></a> <a title="Wishlist" href="#"><i
																class=" ti-heart "></i><span>Add to Wishlist</span></a> <a
																title="Compare" href="#"><i class="ti-bar-chart-alt"></i><span>Add
																	to Compare</span></a>
														</div>
														<div class="product-action-2">
															<a title="Add to cart" id="<%= producto.getId() %>" class="addCart" href="#">Añadir al carrito</a>
														</div>
													</div>
												</div>
												<div class="product-content">
													<h3>
														<a href="product-details.html"><%=producto.getNombre()%></a>
													</h3>
													<div class="product-price">
														<span><%=producto.getPrecio()%></span>
													</div>
												</div>
											</div>
										</div>
										<%
										}
										%>
									</div>
								</div>
							</div>

							<!-- End Variado Tab -->

							<!-- Start Single Tab -->
							<div class="tab-pane fade show active" id="man" role="tabpanel">
								<div class="tab-single">
									<div class="row">

										<div class="col-xl-3 col-lg-4 col-md-4 col-12">
											<div class="single-product">
												<div class="product-img">
													<a href="product-details.html"> <img
														class="default-img"
														src="https://via.placeholder.com/550x750" alt="#"> <img
														class="hover-img"
														src="https://via.placeholder.com/550x750" alt="#">
													</a>
													<div class="button-head">
														<div class="product-action">
															<a data-toggle="modal" data-target="#exampleModal"
																title="Quick View"><i class=" ti-eye"></i><span>Quick
																	Shop</span></a> <a title="Wishlist" href="#"><i
																class=" ti-heart "></i><span>Add to Wishlist</span></a> <a
																title="Compare" href="#"><i class="ti-bar-chart-alt"></i><span>Add
																	to Compare</span></a>
														</div>
														<div class="product-action-2">
															<a title="Add to cart" href="#">Add to cart</a>
														</div>
													</div>
												</div>
												<div class="product-content">
													<h3>
														<a href="product-details.html">Esto es de chico!</a>
													</h3>
													<div class="product-price">
														<span>$29.00</span>
													</div>
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>
							<!--/ End Single Tab -->
							<!-- Start Single Tab -->
							<div class="tab-pane fade" id="women" role="tabpanel">
								<div class="tab-single">
									<div class="row">
										<div class="col-xl-3 col-lg-4 col-md-4 col-12">
											<div class="single-product">
												<div class="product-img">
													<a href="product-details.html"> <img
														class="default-img"
														src="https://via.placeholder.com/550x750" alt="#"> <img
														class="hover-img"
														src="https://via.placeholder.com/550x750" alt="#">
													</a>
													<div class="button-head">
														<div class="product-action">
															<a data-toggle="modal" data-target="#exampleModal"
																title="Quick View" href="#"><i class=" ti-eye"></i><span>Quick
																	Shop</span></a> <a title="Wishlist" href="#"><i
																class=" ti-heart "></i><span>Add to Wishlist</span></a> <a
																title="Compare" href="#"><i class="ti-bar-chart-alt"></i><span>Add
																	to Compare</span></a>
														</div>
														<div class="product-action-2">
															<a title="Add to cart" href="#">Add to cart</a>
														</div>
													</div>
												</div>
												<div class="product-content">
													<h3>
														<a href="product-details.html">Esto es de mujer!</a>
													</h3>
													<div class="product-price">
														<span>$29.00</span>
													</div>
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>
							<!--/ End Single Tab -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Product Area -->

	<!-- Start Most Popular -->
	<div class="product-area most-popular section">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section-title">
						<h2>Hot Item</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="owl-carousel popular-slider">
						<!-- Start Single Product -->
						<div class="single-product">
							<div class="product-img">
								<a href="product-details.html"> <img class="default-img"
									src="https://via.placeholder.com/550x750" alt="#"> <img
									class="hover-img" src="https://via.placeholder.com/550x750"
									alt="#"> <span class="out-of-stock">Hot</span>
								</a>
								<div class="button-head">
									<div class="product-action">
										<a data-toggle="modal" data-target="#exampleModal"
											title="Quick View" href="#"><i class=" ti-eye"></i><span>Quick
												Shop</span></a> <a title="Wishlist" href="#"><i class=" ti-heart "></i><span>Add
												to Wishlist</span></a> <a title="Compare" href="#"><i
											class="ti-bar-chart-alt"></i><span>Add to Compare</span></a>
									</div>
									<div class="product-action-2">
										<a title="Add to cart" href="#">Add to cart</a>
									</div>
								</div>
							</div>
							<div class="product-content">
								<h3>
									<a href="product-details.html">Black Sunglass For Women</a>
								</h3>
								<div class="product-price">
									<span class="old">$60.00</span> <span>$50.00</span>
								</div>
							</div>
						</div>
						<!-- End Single Product -->
						<!-- Start Single Product -->
						<div class="single-product">
							<div class="product-img">
								<a href="product-details.html"> <img class="default-img"
									src="https://via.placeholder.com/550x750" alt="#"> <img
									class="hover-img" src="https://via.placeholder.com/550x750"
									alt="#">
								</a>
								<div class="button-head">
									<div class="product-action">
										<a data-toggle="modal" data-target="#exampleModal"
											title="Quick View" href="#"><i class=" ti-eye"></i><span>Quick
												Shop</span></a> <a title="Wishlist" href="#"><i class=" ti-heart "></i><span>Add
												to Wishlist</span></a> <a title="Compare" href="#"><i
											class="ti-bar-chart-alt"></i><span>Add to Compare</span></a>
									</div>
									<div class="product-action-2">
										<a title="Add to cart" href="#">Add to cart</a>
									</div>
								</div>
							</div>
							<div class="product-content">
								<h3>
									<a href="product-details.html">Women Hot Collection</a>
								</h3>
								<div class="product-price">
									<span>$50.00</span>
								</div>
							</div>
						</div>
						<!-- End Single Product -->
						<!-- Start Single Product -->
						<div class="single-product">
							<div class="product-img">
								<a href="product-details.html"> <img class="default-img"
									src="https://via.placeholder.com/550x750" alt="#"> <img
									class="hover-img" src="https://via.placeholder.com/550x750"
									alt="#"> <span class="new">New</span>
								</a>
								<div class="button-head">
									<div class="product-action">
										<a data-toggle="modal" data-target="#exampleModal"
											title="Quick View" href="#"><i class=" ti-eye"></i><span>Quick
												Shop</span></a> <a title="Wishlist" href="#"><i class=" ti-heart "></i><span>Add
												to Wishlist</span></a> <a title="Compare" href="#"><i
											class="ti-bar-chart-alt"></i><span>Add to Compare</span></a>
									</div>
									<div class="product-action-2">
										<a title="Add to cart" href="#">Add to cart</a>
									</div>
								</div>
							</div>
							<div class="product-content">
								<h3>
									<a href="product-details.html">Awesome Pink Show</a>
								</h3>
								<div class="product-price">
									<span>$50.00</span>
								</div>
							</div>
						</div>
						<!-- End Single Product -->
						<!-- Start Single Product -->
						<div class="single-product">
							<div class="product-img">
								<a href="product-details.html"> <img class="default-img"
									src="https://via.placeholder.com/550x750" alt="#"> <img
									class="hover-img" src="https://via.placeholder.com/550x750"
									alt="#">
								</a>
								<div class="button-head">
									<div class="product-action">
										<a data-toggle="modal" data-target="#exampleModal"
											title="Quick View" href="#"><i class=" ti-eye"></i><span>Quick
												Shop</span></a> <a title="Wishlist" href="#"><i class=" ti-heart "></i><span>Add
												to Wishlist</span></a> <a title="Compare" href="#"><i
											class="ti-bar-chart-alt"></i><span>Add to Compare</span></a>
									</div>
									<div class="product-action-2">
										<a title="Add to cart" href="#">Add to cart</a>
									</div>
								</div>
							</div>
							<div class="product-content">
								<h3>
									<a href="product-details.html">Awesome Bags Collection</a>
								</h3>
								<div class="product-price">
									<span>$50.00</span>
								</div>
							</div>
						</div>
						<!-- End Single Product -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Most Popular Area -->

	<!-- Start Shop Services Area -->
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
	<!-- End Shop Services Area -->

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

	<%@ include file="../WEB-INF/layouts/modal_product.jspf"%>

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
	<!-- Toastr -->
	<script src="index/assets/js/toastr.js"></script>
	<!-- Shop -->
	<script src="index/assets/js/shop.js"></script>
	<!-- Modal product -->
	<script src="index/assets/js/modal_product.js"></script>

</body>
</html>