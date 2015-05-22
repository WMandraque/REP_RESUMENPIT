package com.resumenpit.utils;

public class Constantes 
{
    //Constantes: se especifica final para que no pueda ser alterado
	public final static String MENSAJE_REGISTRO_EXITOSO="REGISTRO EXITOSO";
	public final static String MENSAJE_REGISTRO_ERROR="DATOS INVALIDOS DEL LOGIN";
	public final static String MENSAJE_ERROR_DATOS="ERROR CON LOS DATOS INGRESADOS";
	public final static String MENSAJE_CANTIDAD_REG="Cantidad de registros encontrados : ";
	public final static String EMAIL_MEDIKIDS="medikidsm@gmail.com";
	public final static String CLAVE_MEDIKIDS="ggronxubhzbcdgfg";
	/////////////////////
	
	
	public final static String MENSAJE_RECUPERACION_PASSWORD(String _nombre, String  _password)
	{
	 return	  "Hola, "+ _nombre+": " +"\n"
	         +"Parece que no recuerdas tu contraseña para entrar en MediKids" + "\n"
             +"Tu contraseña olvidada es: " + _password + "\n" + "\n" +"\n"
             +"Un saludo, El equipo de Medikids http://www.medikids.pe/"; 
	}
	
	public final static String TITULO_RECUPERACION_PASSWORD= "Cuenta de Medikids: se habilitó la "
			                                               + "opcion de recuperacion de password";
	
}
