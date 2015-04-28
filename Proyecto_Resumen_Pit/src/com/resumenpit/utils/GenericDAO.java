package com.resumenpit.utils;

import java.sql.Connection;


public interface GenericDAO 
{
		
	//Metodos obligado a impementar para facilitarnos la conexion
	Connection getConection() throws Exception;
	void abrirConexion() throws Exception;
	void commit() throws Exception;
	void rollBack() throws Exception;
	void cerrarConexion() throws Exception;

}
