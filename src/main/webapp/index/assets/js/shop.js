$(function() {

	getCartDetail();

	// Asignamos evento al botón de Agregar carrito.

	$("input[name='addCart']").click(function() {

		const idProduct = $(this).attr("id");

		$.ajax({
			url: 'carrito_add',
			data: {
				idProduct: idProduct,
				stack: 1
			},
			success: (data) => {

				if (data !== null) {
					fillIncludedCart(data); // Rellenar el carrito acoplado en el header.
					fillCartTable(data);
				}

			}
		});

	});

});

/*
	Realiza una petición al servlet para obtener los productos
	que el usuario tiene en su carrito en formato JSON.
 */

function getCartDetail() {

	$.ajax({
		url: 'carrito_show',
		data: {},
		success: (data) => {

			if (data !== null) {

				if (data !== null) {
					console.log(data);
					fillIncludedCart(data); // Rellenar el carrito acoplado en el header.
					fillCartTable(data);
				}

			}

		}
	});

}

/*
	Agrega los artículos al contenido del carrito en el DOM.
 */

function fillIncludedCart(data) {

	const includedCartElement = $('div[class="sinlge-bar shopping"]');

	if ($(includedCartElement).length === 1) {

		const includedCart = {
			totalCount: $('.total-count'), // Cantidad total de productos.
			shopArticles: $('.shopping-articles'), // Cantidad total de productos.
			cartListElement: $('.shopping-list'), // Lista de los productos.
			totalAmmount: $('.total-amount-cart') // Precio total de los productos.
		};

		$(includedCart.totalCount).html(data.totalProduct);

		$(includedCart.shopArticles).html(data.totalProduct);

		// Limpiar el contenido del carrito.

		emptyHtml(includedCart.cartListElement);

		// Agregar elementos con cada artículo.

		data.products.forEach(product => {

			includedCart.cartListElement.append('<li>' +
				'<a href="#" class="remove" title="Eliminar artículo">' +
				'<i class="fa fa-remove"></i>' +
				'</a> <a class="cart-img" href="#">' +
				'<img src="https://via.placeholder.com/70x70" alt="#"></a>' +
				'<h4><a href="#"> ' + product.producto.nombre + '</a></h4>' +
				'<p class="quantity">' + product.unidades + 'x - <span class="amount"> ' +
				product.precio_unidad + ' €</span></p></li>');

		});

		$(includedCart.totalAmmount).html(data.totalAmmount + ' €');

	}

}

/*
	Recibe un objeto que contenga los elementos del DOM de los cuales
	eliminaremos la inforación que se encuentra en el interior.
	
	Ej: data = {
		el1 : elementoDOM_1,
		el2 : elementoDOM_2
	}
	
 */

function emptyHtml(data) {
	if (data !== null) {
		Object.keys(data).forEach((e) => {
			$(data[e]).empty();
		});
	}
}

/*
	Funciones para la vista completa de carrito.
 */

function fillCartTable(data) {

	console.log('Rellenando tabla...')

	const cartTable = $('table, .table shopping-summery');
	
	if (cartTable.length === 1) {
		
		const cartTableBody = $('.table shopping-summery, tbody');	
		
		// Limpiamos el contenido de la tabla.
		
		emptyHtml(cartTableBody);
		
		// Comenzamos a rellenar la tabla con la información de los productos.
		
		console.log(data.products);
		
		data.products.forEach(product => {
			
			cartTableBody.append('<tr>' +
									'<td class="image" data-title="No"><img src="https://via.placeholder.com/100x100" alt="#"></td>' +
									'<td class="product-des" data-title="Description">' +
										'<p class="product-name">' +
											'<a href="#"> ' + product.producto.nombre + '</a>' +
										'</p>' +
										'<p class="product-des"> ' + product.producto.descripcion + '</p>' +
									'</td>' +
									'<td class="price" data-title="Price"><span>' + product.precio_unidad + '</span></td>' +
									'<td class="qty" data-title="Qty">' +

									'<div class="input-group">' +
										'<div class="button minus">' +
											'<button type="button" class="btn btn-primary btn-number"' +
												'disabled="disabled" data-type="minus" data-field="quant[' + product.producto.id + ']">' +
												'<i class="ti-minus"></i>' +
											'</button>' + 
										'</div>' +
										'<input type="text" name="quant[' + product.producto.id + ']" class="input-number"' +
											' data-min="1" value="1">' +
										'<div class="button plus">' +
											'<button type="button" class="btn btn-primary btn-number"' +
												'data-type="plus" data-field="quant[' + product.producto.id + ']">' +
												'<i class="ti-plus"></i>' +
											'</button>' +
										'</div>' +
									'</div>' +
								'</td>' +
								'<td class="total-amount" data-title="Total"><span>' + (product.precio_unidad * product.unidades) + '</span></td>' +
								'<td class="action" data-title="Remove"><a href="#"><i class="ti-trash remove-icon"></i></a></td>' +
							'</tr>');
			
		});
		
	}

}
