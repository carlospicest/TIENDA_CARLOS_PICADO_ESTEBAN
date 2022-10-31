$(function() {

	/*=======================
		  Slider Range JS
		=========================*/
	$(function() {

		$("#slider-range").slider({
			range: true,
			min: 0,
			max: 500,
			values: [120, 250],
			slide: function(event, ui) {
				$("#amount").val(ui.values[0] + " € - " + ui.values[1] + " €");
			}
		});

		$("#amount").val($("#slider-range").slider("values", 0) +
			" € - " + $("#slider-range").slider("values", 1) + " €");
	});

	$('#amount').change(function() {

		let amount = $(this).val();
		let values = amount.match(/[0-9]+/g);

		let min = values[0];
		let max = values[1];

		setMinMaxSlider(min, max);

	});

});

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

