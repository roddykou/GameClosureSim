console.log('js loaded');

function handleClick(e){
	console.log('button clicked');

	
	$.ajax('/calculate.action',{
		type: 'post',
		data: {
		
		},
		cache: false,
		dataType: 'json',
		success: function(response){
			console.log('success return');
			var result = response.result;
			for (var i = 0; i <= result.length - 1; i++) {
				$('#result'+i).text(result[i]);
				$('#result'+i).attr("style","color: red;"); 
				console.log('reulst set');
			};
		
		}

	});
	
}

$(document).ready(function(){
	$('#start').click(handleClick);
})