<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, java.util.ArrayList, java.util.HashMap, curso.java.tienda.index.pojo.Categoria, curso.java.tienda.index.pojo.Producto"%>
<%
ArrayList<Categoria> categoryList = (ArrayList<Categoria>) request.getAttribute("categoryList");
HashMap<Integer, Producto> productList = (HashMap<Integer, Producto>) request.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../WEB-INF/layouts/head.jspf"%>
<!-- Catalogo filter -->
<link rel="stylesheet" href="index/assets/css/catalogo_filter.css">
<body>

	<%@ include file="../WEB-INF/layouts/header.jspf"%>

	<!-- Breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="bread-inner">
						<ul class="bread-list">
							<li><a href="index1.html">Home<i class="ti-arrow-right"></i></a></li>
							<li class="active"><a href="blog-single.html">Shop Grid</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Breadcrumbs -->

	<!-- Product Style -->
	<section class="product-area shop-sidebar shop section">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-4 col-12">
					<div class="shop-sidebar">
					
						<div class="single-widget category">
							<button id="clearFilter" class="btn">
								<i class="bi bi-funnel mr-1"></i>
								Borrar filtros
							</button>
						</div>
					
						<!-- Single Widget -->
						<div class="single-widget category">
							<h3 class="title">Categorías</h3>

							<div style="overflow-y: auto; height: 25vh;">
								<ul class="categor-list">
									<%
									for (Categoria categoria : categoryList) {
									%>
									<li>
										<!-- <a href="#"><%=categoria.getNombre()%></a> --> <label
										for="<%=categoria.getId()%>" class="d-block category"> <input
											name="category" id="<%=categoria.getId()%>" type="checkbox"
											value="<%=categoria.getNombre()%>"> <%=categoria.getNombre()%>
									</label>
									</li>
									<%
									}
									%>
								</ul>
							</div>

						</div>
						<!--/ End Single Widget -->
						<!-- Shop By Price -->
						<div class="single-widget range">
							<h3 class="title">Precio</h3>
							<div class="price-filter">
								<div class="price-filter-inner">
									<div id="slider-range"></div>
									<div class="price_slider_amount">
										<div class="label-input">
											<span>Intervalo:</span><input type="text" id="amount"
												name="price" value="" placeholder="min - max" />
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--/ End Shop By Price -->

					</div>
				</div>
				<div class="col-lg-9 col-md-8 col-12">
				
					<div class="d-flex justify-content-center"
						style="background-color: #F6F7FB; padding: 15px;">
						<button class="btn mr-2 sortCriteria" id="lowest_price">
							<i class="bi bi-arrow-down mr-1"></i>Precio más bajo
						</button>
						<button class="btn mr-2 sortCriteria" id="highest_price">
							<i class="bi bi-arrow-up mr-1"></i>Precio más alto
						</button>
						<button class="btn mr-2 sortCriteria" id="best_sellers">
							<i class="bi bi-currency-exchange mr-1"></i>Más vendidos
						</button>
						<button class="btn mr-2 sortCriteria" id="top_rated">
							<i class="bi bi-star mr-1"></i>Mejor valorados
						</button>
					</div>

					<!-- Artículos de la tienda -->
					<div id="productsList" class="row">
						<%
						for (Producto product : productList.values()) {
						%>
						<div class="col-lg-4 col-md-6 col-12">
							<div class="single-product">
								<div class="product-img">
									<a href="product-details.html"> <img class="default-img"
										src="https://via.placeholder.com/550x750" alt="#"> <img
										class="hover-img" src="https://via.placeholder.com/550x750"
										alt="#"> <span class="new">New</span> <!--<span class="price-dec">30% Off</span> Para artículos en descuento -->
										<!--<span class="out-of-stock">Hot</span> Para artículos sin stock -->

									</a>
									<div class="button-head">
										<div class="product-action">
											<a title="Wishlist" href="#"><i class=" ti-heart "> </i><span>Añadir
													a lista de deseos</span></a>
										</div>
										<div class="product-action-2">
											<!-- <a title="Add to cart" href="#">Añadir al carrito</a>  -->
											<input type="button" name="addCart" id="<%=product.getId()%>"
												class="btn" value="Añadir al carrito">
										</div>
									</div>
								</div>
								<div class="product-content">
									<h3>
										<a href="product-details.html"><%=product.getNombre()%></a>
									</h3>
									<div class="product-price">
										<span><%=product.getPrecio()%> €</span>
									</div>
								</div>
							</div>
						</div>
						<%
						}
						%>
					</div>
					<!-- Fin Artículos de la tienda -->

				</div>
			</div>
		</div>
	</section>
	<!--/ End Product Style 1  -->

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



	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span class="ti-close" aria-hidden="true"></span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row no-gutters">
						<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
							<!-- Product Slider -->
							<div class="product-gallery">
								<div class="quickview-slider-active">
									<div class="single-slider">
										<img src="https://via.placeholder.com/569x528" alt="#">
									</div>
									<div class="single-slider">
										<img src="https://via.placeholder.com/569x528" alt="#">
									</div>
									<div class="single-slider">
										<img src="https://via.placeholder.com/569x528" alt="#">
									</div>
									<div class="single-slider">
										<img src="https://via.placeholder.com/569x528" alt="#">
									</div>
								</div>
							</div>
							<!-- End Product slider -->
						</div>
						<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
							<div class="quickview-content">
								<h2>Flared Shift Dress</h2>
								<div class="quickview-ratting-review">
									<div class="quickview-ratting-wrap">
										<div class="quickview-ratting">
											<i class="yellow fa fa-star"></i> <i
												class="yellow fa fa-star"></i> <i class="yellow fa fa-star"></i>
											<i class="yellow fa fa-star"></i> <i class="fa fa-star"></i>
										</div>
										<a href="#"> (1 customer review)</a>
									</div>
									<div class="quickview-stock">
										<span><i class="fa fa-check-circle-o"></i> in stock</span>
									</div>
								</div>
								<h3>$29.00</h3>
								<div class="quickview-peragraph">
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit. Mollitia iste laborum ad impedit pariatur esse optio
										tempora sint ullam autem deleniti nam in quos qui nemo ipsum
										numquam.</p>
								</div>
								<div class="size">
									<div class="row">
										<div class="col-lg-6 col-12">
											<h5 class="title">Size</h5>
											<select>
												<option selected="selected">s</option>
												<option>m</option>
												<option>l</option>
												<option>xl</option>
											</select>
										</div>
										<div class="col-lg-6 col-12">
											<h5 class="title">Color</h5>
											<select>
												<option selected="selected">orange</option>
												<option>purple</option>
												<option>black</option>
												<option>pink</option>
											</select>
										</div>
									</div>
								</div>
								<div class="quantity">
									<!-- Input Order -->
									<div class="input-group">
										<div class="button minus">
											<button type="button" class="btn btn-primary btn-number"
												disabled="disabled" data-type="minus" data-field="quant[1]">
												<i class="ti-minus"></i>
											</button>
										</div>
										<input type="text" name="quant[1]" class="input-number"
											data-min="1" data-max="1000" value="1">
										<div class="button plus">
											<button type="button" class="btn btn-primary btn-number"
												data-type="plus" data-field="quant[1]">
												<i class="ti-plus"></i>
											</button>
										</div>
									</div>
									<!--/ End Input Order -->
								</div>
								<div class="add-to-cart">
									<a href="#" class="btn">Add to cart</a> <a href="#"
										class="btn min"><i class="ti-heart"></i></a> <a href="#"
										class="btn min"><i class="fa fa-compress"></i></a>
								</div>
								<div class="default-social">
									<h4 class="share-now">Share:</h4>
									<ul>
										<li><a class="facebook" href="#"><i
												class="fa fa-facebook"></i></a></li>
										<li><a class="twitter" href="#"><i
												class="fa fa-twitter"></i></a></li>
										<li><a class="youtube" href="#"><i
												class="fa fa-pinterest-p"></i></a></li>
										<li><a class="dribbble" href="#"><i
												class="fa fa-google-plus"></i></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
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
	<!-- Toastr -->
	<script src="index/assets/js/toastr.js"></script>
	<!-- Common Settings JS -->
	<script src="index/assets/js/common-settings.js"></script>
	<!-- Shop JS -->
	<script src="index/assets/js/shop.js"></script>
	<!-- Catalogo JS -->
	<script src="index/assets/js/catalogo_filter.js"></script>

</body>
</html>