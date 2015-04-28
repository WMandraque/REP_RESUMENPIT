package com.resumenpit.service;

import java.util.List;

import com.resumenpit.factory.DAOFactory;
import com.resumenpit.interfaces.EstadoDAO;
import com.resumenpit.models.EstadoDTO;

public class EstadoService 
{
	
	DAOFactory factory=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	EstadoDAO dao=factory.getEstadoDAO();
	
	public List<EstadoDTO> listarEstados() 
	{
		return dao.listarEstados();
	}

}
