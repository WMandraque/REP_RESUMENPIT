$(function(){

	    //Si el btnLoguin ha sido presionado click
	    //Se reconocera solo por el id
		$('#btnLoguin').click(function(){
			
			var usuario=$("#txtUsuario").val();
			var password=$("#txtPassword").val();
			
			$.ajax({
				
				url:"validarLogueo2",
				type:'post',
				data:{usuario: usuario, password: password},
				
				success:function()
				{
					location.href="probando.jsp"
				}
				
			});
						
			
		});
		
		
		
		$('#txtPassword').keyup(function(e){
			
			var key = CryptoJS.enc.Hex.parse('000102030405060708090a0b0c0d0e0f');
			
			var sha1 = $(this).val();
//			console.log(sha1);
			
			var aSha1 = CryptoJS.SHA1(sha1,key);
			alert(sha1);
		});




});


