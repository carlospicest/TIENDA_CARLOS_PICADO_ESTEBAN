$(function() {

	setMinMaxSlider(0, 999); // Inicializamos el slider de precio con unos valores.

	// Evento que establece el valor min y max del Slider cuando el usuario establece los límites.

	$('#amount').change(function() {

		let amount = $(this).val();
		let values = amount.match(/[0-9]+/g);

		let min = values[0];
		let max = values[1];

		setMinMaxSlider(min, max);

	});

	// Cuando se seleccione la cantidad, aplicamos el filtro.

	$("#slider-range").on("slidechange", function(event, ui) {

	});

});

/*
	Establece los valores de precio mínimo y máximo que indique
	el usuario.
 */

function setMinMaxSlider(min, max) {

	// Validar si los valores de min y max están definidos.

	if (min === undefined || max === undefined) {

		$("#amount").val(null);

	} else {

		min = parseInt(min);
		max = parseInt(max);

		$("#slider-range").slider({
			range: true,
			min: min,
			max: max,
			values: [min, max],
			slide: function(event, ui) {
				$("#amount").val(ui.values[0] + " € - " + ui.values[1] + " €");
			}
		});

		$("#amount").val($("#slider-range").slider("values", 0) +
			" € - " + $("#slider-range").slider("values", 1) + " €");

	}

}

/*
	Función que envía al servlet los criterios de filtrado que
	haya especificado el usuario.
*/

function getFilter() {

	// Elementos de filtro.
	
	const criteria = {

		category: getIdCategorySelected(),
		price: getPrice(),
		lowest_price: false,
		highest_price: false,
		best_sellers: false,
		top_rated: false

	};

	console.log(criteria);

}

/*
	Devuelve un array con los id's de las categorías seleccionadas.
 */

function getIdCategorySelected() {
	
	const categories = $('input[type="checkbox"][name="category"]:checked');
	
	const elementId = new Array();

	Object.keys(categories).forEach((e) => {
		
		const id = $(categories[e]).prop('id');
		
		if (id !== undefined && id !== null) {
			elementId.push(parseInt(id));	
		}
		
	});
	
	return elementId;

}

/*
	Devuelve el rango de precio mínimo y máximo establecido por el usuario.
 */

function getPrice() {
	
	const priceValues = $("#slider-range").slider("option", "values");
	
	let price = {}
	
	if (priceValues !== null && priceValues.length == 2) {
		
		price = {
			min: priceValues[0],
			max: priceValues[1]
		}
		
	}
	
	return price;
	
}
