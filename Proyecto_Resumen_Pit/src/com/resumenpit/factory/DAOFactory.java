package com.resumenpit.factory;

import com.resumenpit.interfaces.UsuarioDAO;

public abstract class DAOFactory 
{
	
	//Constantes para indentificar cada Factory(Fabrica)
	public static final int MYSQL=0;
	public static final int SQLSERVER=1;
	public static final int ORACLE=2;
	
	
	//Metodos Abstractos que la clase hija va a heredar
	public abstract UsuarioDAO getUsuarioDAO();
	
	
	// Identificador para obetener la fabrica
	// Cada identificador tendra su propia fabrica que retornara con la clase extendida DAOFactory
	// Ademas heredera los metodos obligados para implementarlos
	public static DAOFactory getDAOFactory(int bd)
	{
		switch (bd) 
		{
			case MYSQL:
				      return new MySqlDAOFactory();
			case SQLSERVER:
				      return new SqlServerDAOFactory();
			case ORACLE:
				      return new OracleDAOFactory();
			default:
				      return null;
		}
	}
	
	
	

}
