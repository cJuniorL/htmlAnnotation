window.onload = function(){
	
	var response = document.getElementById('resposta');
	var error = document.getElementById('error');
	
	if(error.value == "error"){
		$('#erro').removeClass("hidden");
		$('#sucesso').addClass("hidden");
	} else {
		if(response.value != null && response.value != ""){
			$('#sucesso').removeClass("hidden");
			$('#erro').addClass("hidden");
		}
	}
	
	 $('#submit1').click(function(){
		 window.location.href = 'http://localhost:8080/compilador';
	    });
	
};

