package com.resumenpit.service;

import java.util.List;

import com.resumenpit.factory.DAOFactory;
import com.resumenpit.interfaces.UsuarioDAO;
import com.resumenpit.models.UsuarioDTO;

public class UsuarioServices 
{
	
	DAOFactory factory=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	UsuarioDAO dao=factory.getUsuarioDAO();
	
	public UsuarioDTO validarUsuario(UsuarioDTO _usuario) 
	{
		return dao.validarUsuario(_usuario);
	}
	
	public int insertarUsuario(UsuarioDTO usuario)
	{
		return dao.insertarUsuario(usuario);
	}
	

	public UsuarioDTO buscarUsuario(String usuario) 
	{
		return dao.buscarUsuario(usuario);
	}
	
	public int eliminarUsuario(String usuario) 
	{
		return dao.eliminarUsuario(usuario);
	}
	
	public List<UsuarioDTO> buscarUsuarios(String _parametro, String _valor)
	{
		return dao.buscarUsuarios(_parametro, _valor);
	}
	
	public UsuarioDTO recuperarPasswordEmail(String _usuario, String _email)
	{
		return dao.recuperarPasswordEmail(_usuario, _email);
	}

	


}
