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
						$('.total-count').html(data.productCount);
						
						
						
					}
					
				}
				
			}
		});
		
	});
	
});