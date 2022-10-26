$(function() {

	getCartDetail();
	
	// Asignamos evento al botón de Agregar carrito.
	
	$("input[name='addCart']").click(function() {
		
		const idProduct = $(this).attr("id");
		
		$.ajax({
			url : 'carrito_add',
			data : {
				idProduct : idProduct,
				stack : 1
			},
			success : function(data) {
				
				if (data !== null) {

					// Una vez obtenidos los datos, refrescamos carrito.
					refreshProductCart(data);
					
				}
				
			}
		});
		
	});

});

/*
	Funciones para manipular los elementos del DOM.
*/


function refreshProductCart(data) {
		
	$('.total-count').html(data.totalProduct);
		
	$('.shopping-articles').html(data.totalProduct);	
		
	// Limpiar información del carrito para incluirla.
	
	const cartListElement = $('.shopping-list');
		
	cartListElement.empty();
		
	// Agregar elementos con cada artículo.
	
	data.products.forEach(product => {
		
		cartListElement.append('<li>' +
									'<a href="#" class="remove" title="Remove this item">' +
										'<i class="fa fa-remove"></i>' +
									'</a> <a class="cart-img" href="#">' +
										'<img src="https://via.placeholder.com/70x70" alt="#"></a>' +
										'<h4><a href="#"> ' + product.producto.nombre + '</a></h4>' +
										'<p class="quantity">' + product.unidades + 'x - <span class="amount"> ' + 
										product.precio_unidad + ' €</span></p></li>');
		
	});
	
	$('.total-amount').html(data.totalAmmount + ' €');
	
}

function getCartDetail() {

	$.ajax({
		url: 'carrito',
		data: {},
		success: function(data) {

			if (data !== null) {

				if (data !== null) {
					console.log(data);
					printCartDetail(data);
				}

			}

		}
	});

}

function printCartDetail(data) {

	const cart = {
		totalCount: $('.total-count'), // Cantidad total de productos.
		shopArticles: $('.shopping-articles'), // Cantidad total de productos.
		cartListElement: $('.shopping-list'), // Lista de los productos.
		totalAmmount: $('.total-amount') // Precio total de los productos.
	};

	emptyHtml(cart);

	cart.totalCount.append(data.totalProduct);
	cart.shopArticles.append(data.totalProduct);
	cart.totalAmmount.append(data.totalAmmount);

	if (data.products != null && data.products.length > 0) {
		addProductCart(data.products);
	}

}

function addProductCart(productList) {

	const cartListElement = $('.shopping-list'); // Lista de los productos.

	productList.forEach(product => {

		cartListElement.append('<li>' +
			'<a href="#" class="remove" title="Remove this item">' +
			'<i class="fa fa-remove"></i>' +
			'</a> <a class="cart-img" href="#">' +
			'<img src="https://via.placeholder.com/70x70" alt="#"></a>' +
			'<h4><a href="#"> ' + product.producto.nombre + '</a></h4>' +
			'<p class="quantity">' + product.unidades + 'x - <span class="amount"> ' +
			product.precio_unidad + ' €</span></p></li>');

	});

}

function emptyHtml(data) {
	if (data !== null) {
		Object.keys(data).forEach((e) => {
			$(data[e]).empty();
		});
	}
}
