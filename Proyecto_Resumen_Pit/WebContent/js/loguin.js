$(function(){   //Si el btnLoguin ha sido presionado click
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
		
		

});




