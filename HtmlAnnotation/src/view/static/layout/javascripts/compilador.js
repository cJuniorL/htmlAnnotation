function btnLexico(){
	var request = $('#texto').val();
	$.ajax({
		url: "http://localhost:8080/compilador/request",
		method: 'GET',
		contentType: 'application/json',
		data: {
			linguagem: $('#texto').val()
		},
		success: function(data){
			console.log(data);
			if(data != null && data != ""){
				$('#sucesso').removeClass("hidden");
				$('#erro').addClass("hidden");
				window.location.replace("http://localhost:8080/compilador/lexico");
			} else{
				$('#erro').removeClass("hidden");
				$('#sucesso').addClass("hidden");
			}
		}
	})
};