$(function() {

	setMinMaxSlider(0, 10000); // Inicializamos el slider de precio con unos valores.

	// Evento que establece el valor min y max del Slider cuando el usuario establece los límites.

	$('#amount').change(function() {

		let amount = $(this).val();
		let values = amount.match(/[0-9]+/g);

		let min = values[0];
		let max = values[1];

		setMinMaxSlider(min, max);

	});

	// Eventos de los botones de Ordenación:

	$('button.sort').click(function() {

		if ($(this).attr('class').indexOf('criteria_active') === -1) {
			$(this).addClass('criteria_active');
		}

		// Solo puede permanecer activo un criterio de ordenación.

		let buttons = $('button.sort');

		Object.keys(buttons).forEach((e) => {

			const btn = $(buttons[e]);

			if (btn.prop('id') !== undefined) {
				if (btn.prop('id') !== $(this).prop('id')) {
					btn.removeClass('criteria_active');
				}
			}

		});

	});
	
	// Evento para el botón de borrar filtros.
	
	$('#clearFilter').click(() => {
		console.log('Llamando a clearFilters()');
		clearFilters();
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
	Elimina los filtros de categorías y de ordenación.
 */

function clearFilters() {

	// Filtro de categorías.

	const categories = $('input[type="checkbox"][name="category"]:checked');

	Object.keys(categories).forEach((e) => {

		const element = $(categories[e]);

		if (element !== undefined && element !== null) {
			//element.prop("checked", false);
			console.log(element);
		}

	});

	// Filtro de ordenación.

	const buttons = $('button.sort');

	Object.keys(buttons).forEach((e) => {

		const btn = $(buttons[e]);

		if (btn.prop('id') !== undefined) {
			btn.removeClass('criteria_active');
		}

	});

}

/*
	Función que genera un nuevo filtro.
*/

function buildFilter() {

	// Elementos de filtro.

	let criteria = {

		categories: null,
		price: null,
		sort: null

	};

	return criteria;

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

/*
	Devuelve el criterio de ordenación que está activo.
 */

function getSortCriteria() {

	let sortCriteria = null;
	let buttons = $('button.sort');

	Object.keys(buttons).forEach((e) => {

		const btn = $(buttons[e]);

		if (btn.prop('id') !== undefined) {
			if (btn.attr('class').indexOf('criteria_active') !== -1) {
				let idCriteria = btn.prop('id');
				
				switch (idCriteria) {
					
					case 'lowest_price':
					
					sortCriteria = 0;
					break;
					
					case 'highest_price':
					
					sortCriteria = 1;
					break;
					
					case 'best_sellers':
					
					sortCriteria = 2;
					break;
					
					case 'top_rated':
					
					sortCriteria = 3;
					break;
					
				}
				
			}
		}

	});

	return sortCriteria;

}

/*
	Permite preparar un filtro con los ajustes establecidos y enviar
	la solicitud al servlet para obtener la información resultante.
 */

function prepareFilter() {

	let criteria = buildFilter();

	criteria.categories = getIdCategorySelected();
	criteria.price = getPrice();
	criteria.sort = getSortCriteria();

	// Obtenemos JSON de criteria.

	const criteriaJSON = JSON.stringify(criteria);

	// Enviamos la información al servlet.

	$.ajax({

		url: 'catalogo_filter',
		type: 'POST',
		data: {
			filter: criteriaJSON
		},
		success: (data) => {

			console.log(data);

		}

	});

}
