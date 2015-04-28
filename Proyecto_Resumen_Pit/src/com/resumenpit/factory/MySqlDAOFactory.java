package com.resumenpit.factory;

import com.resumenpit.dao.MySqlUsuarioDAO;
import com.resumenpit.interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory {

	//Retornara una clasa implementada
	@Override
	public UsuarioDAO getUsuarioDAO() 
	{
		return new MySqlUsuarioDAO();
	}

}
