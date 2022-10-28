$('div .password-data i').click(function() {
	
	const inputPassword = $('input[id="password"]');
	
	if (inputPassword.prop('type') === 'password') {
		inputPassword.prop('type', 'text');
		$(this).prop('class', 'pw pw-not');
	} else {
		inputPassword.prop('type', 'password');
		$(this).prop('class', 'pw');
	}
	
});