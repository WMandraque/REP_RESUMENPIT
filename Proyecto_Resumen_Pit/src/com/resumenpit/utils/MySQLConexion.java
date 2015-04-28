package com.resumenpit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion 
{
	
	/**
	 * Carga en Memoria el Driver de MySQL
	 */
	static 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//URL de conexión a schema de MySQL mediante la constante
	static final String URL_BD_MYSQL="jdbc:mysql://localhost:3306/base?user=root&password=mysql";
	
	/**
	 * Retorna una conexión de la Base de Datos MySQL
	 */
	public static Connection getConnection()
	{
		//Creamos un objeto de tipo connection e inicializamos en null
		Connection connection=null;
		try 
		{
			connection = DriverManager.getConnection(URL_BD_MYSQL);
			//Desabilitamos el autocommit en modo false, para ya nostros trabajarlo
			connection.setAutoCommit(false);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return connection;
	}

}
