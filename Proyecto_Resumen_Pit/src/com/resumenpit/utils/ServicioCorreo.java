package com.resumenpit.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.resumenpit.models.UsuarioDTO;
import com.resumenpit.service.UsuarioServices;

public class ServicioCorreo {

	public void enviar(String _correoEnviar, String _titulo, String _mensaje)
	{
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(Constantes.EMAIL_MEDIKIDS, Constantes.CLAVE_MEDIKIDS);
			}
		  });
 
		try
		{
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Constantes.EMAIL_MEDIKIDS));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(_correoEnviar));
			message.setSubject(_titulo);
			message.setText(_mensaje);
 
			Transport.send(message);
            System.out.println("Correo enviado!!");
		} 
		catch (MessagingException e) 
		{
			throw new RuntimeException(e);
		}

		
	}
	
	


	public static void main(String[] ar) 
	{
		/*UsuarioDTO x1=new UsuarioServices().recuperarPasswordEmail("u002", "cristhianp00@gmail.com");
		
		if (x1==null) 
		{
			System.out.println("No existe usuario");
		}
		else
		{
			 ServicioCorreo x=new ServicioCorreo();
			 x.enviar(x1.getEmail(), Constantes.TITULO_RECUPERACION_PASSWORD, Constantes.MENSAJE_RECUPERACION_PASSWORD(x1.getNombre()+" "+x1.getApellido(), x1.getClave()));
		     System.out.println("Enviado correo");
		}*/
		
		ServicioCorreo x=new ServicioCorreo();
		x.enviar("lazo.salazar.ricardo@gmail.com", Constantes.TITULO_RECUPERACION_PASSWORD, Constantes.MENSAJE_RECUPERACION_PASSWORD("Ricardo", "123"));
		
	   //ServicioCorreo x=new ServicioCorreo();
	   //x.enviar("cristhianp00@gmail.com", "Title", "Prueba");
	}
	

	
}
