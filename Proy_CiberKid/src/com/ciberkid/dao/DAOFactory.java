package com.ciberkid.dao;

public abstract class DAOFactory 
{
	//Constantes para cada Gestor de BD
	public static final int MYSQL=1;
	public static final int SQLSERVER=2;
	public static final int ORACLE=3;
	
	
	
	public static DAOFactory getFactory(int bd)
	{
	  switch (bd) 
	  {
			case MYSQL:
				      return new MySQLDaoFactory();
		
			default:
				return null;
	   }	
	}
	
	
	
	
	

}
