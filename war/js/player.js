console.log('js loaded');

function handleClick(e){
	console.log('button clicked');
	var username = $('#username').val();
	var email = $('#email').val();
	var offer = $('#offer').val();
	var receive = $('#receive').val();
	console.log('user typed'+username);
	console.log('user typed'+email);
	$.ajax('/playersignup.action',{
		type: 'post',
		data: {
			username:username,
			email:email,
			offer:offer,
			receive: receive
		},
		cache: false,
		dataType: 'json',
		success: function(response){
			console.log('success return');
			$('#result').append(response.feedback);
		}

	});
	
}

$(document).ready(function(){
	$('#signUp').click(handleClick);
})