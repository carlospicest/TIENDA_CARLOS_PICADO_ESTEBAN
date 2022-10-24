$(function() {

	$("input[name='addCart']").click(function() {
		
		const idProd = $(this).attr("id");
		
		$.ajax({
			url : 'carrito_add',
			data : {
				idProduct : idProd,
				stack : 1
			},
			success : function(data) {
				
				if (data !== null) {
					
					console.log(data);
					
					if (data.result) {
						// Cambiamos cantidad.
						
						refreshProductCart(data);
						
					}
					
				}
				
			}
		});
		
	});
	
});

function refreshProductCart(data) {
		
	$('.total-count').html(data.totalProduct);
		
	const cartListElement = $('.shopping-list');
		
	cartListElement.empty();
		
	// Agregar elementos con cada artículo.
	
	data.products.forEach(product => {
		
		cartListElement.append('<li><a href="#" class="remove" title="Remove this item">' +
								'<i class="fa fa-remove"></i></a> <a class="cart-img" href="#">' +
								'<img src="https://via.placeholder.com/70x70" alt="#"></a>' +
									'<h4><a href="#"> ' + product.producto.nombre + '</a></h4>' +
									'<p class="quantity">' + product.unidades + 'x - <span class="amount"> ' + product.precio_unidad + '</span></p></li>');
		
	});
	
	$('.total-amount').html(data.totalAmmount + ' €');
	
}