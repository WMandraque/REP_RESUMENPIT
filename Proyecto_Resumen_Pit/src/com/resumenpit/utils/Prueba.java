package com.resumenpit.utils;

public class Prueba 
{
	
	
	public static void main(String[] arg)
	{
		
		try 
		{
			
			ServicioCorreo x=new ServicioCorreo();
			x.enviar("fuenmondal@gmail.com", "Hola", "Sabpeee");
			System.out.println("Funco");

		} catch (Exception e) {
			System.out.println("Error en "+ e);
		}
	}

}
