$(function() {

	// Comprobar botones de ver información (para asignar evento modal).

	const buttonList = $('a[class="product_modal"]');

	//buttonList.forEach(element => console.log('Mostrando info del producto => ', element.attr("id")));


	Object.values(buttonList).forEach((e) => {

		let element = $(e);
		let idProduct = null;

		if ((idProduct = $(element).prop("id")) !== undefined) {

			// Establecemos evento para abrir el modal con la información del producto.

			$(element).click(() => {

				$.ajax({

					url: 'producto_show',
					type: 'GET',
					data: {
						idProduct: parseInt(idProduct),
					},
					success: (data) => {

						console.log('Showing in modal => ', data);

					}

				});

				$("#exampleModal").modal('show');

				return false; // Anulamos la acción del a href

			});

		}

	});

});



function showProductInformation(idProduct) {

	$.ajax({

		url: 'producto_show',
		type: 'GET',
		data: {
			idProduct: parseInt(idProduct),
		},
		success: (data) => {

			console.log('Showing in modal => ', data);

		}

	});


}