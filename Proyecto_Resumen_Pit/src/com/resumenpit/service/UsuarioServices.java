package com.resumenpit.service;

import java.util.List;

import com.resumenpit.factory.DAOFactory;
import com.resumenpit.interfaces.UsuarioDAO;
import com.resumenpit.models.UsuarioDTO;

public class UsuarioServices 
{
	
	DAOFactory factory=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	UsuarioDAO dao=factory.getUsuarioDAO();
	
	public UsuarioDTO validarUsuario(String usuario, String clave) 
	{
		return dao.validarUsuario(usuario, clave);
	}
	
	public int insertarUsuario(UsuarioDTO usuario)
	{
		return dao.insertarUsuario(usuario);
	}
	
	public List<UsuarioDTO> listadoUsuario()
	{
		return dao.listadoUsuario();
	}
	
	public UsuarioDTO buscarUsuario(String usuario) 
	{
		return dao.buscarUsuario(usuario);
	}
	
	public int eliminarUsuario(String usuario) 
	{
		return dao.eliminarUsuario(usuario);
	}
	
	public List<UsuarioDTO> buscarUsuarios(String nombre)
	{
		return dao.buscarUsuarios(nombre);
	}

	


}
