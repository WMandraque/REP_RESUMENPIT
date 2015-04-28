package com.resumenpit.utils;

import java.sql.Connection;



public class GenericDAOImpl implements GenericDAO 
{

	//Objeto de tipo Connection:
	private Connection connection=null;
	@Override
	public Connection getConection() throws Exception 
	{
		return connection;
	}

	@Override
	public void abrirConexion() throws Exception 
	{
		connection=MySQLConexion.getConnection();

	}

	@Override
	public void commit() throws Exception 
	{
      connection.commit();
	}

	@Override
	public void rollBack() throws Exception 
	{
     connection.rollback();
	}

	@Override
	public void cerrarConexion() throws Exception 
	{
		connection.close();
	}

}
