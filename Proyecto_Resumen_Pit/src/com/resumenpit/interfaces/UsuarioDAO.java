package com.resumenpit.interfaces;

import java.util.List;

import com.resumenpit.models.UsuarioDTO;

public interface UsuarioDAO 
{
	
	UsuarioDTO validarUsuario(UsuarioDTO _usuario);
	int insertarUsuario(UsuarioDTO usuario);
	UsuarioDTO buscarUsuario(String usuario); 
	int eliminarUsuario(String usuario);	
	List<UsuarioDTO> buscarUsuarios(String _parametro, String _valor);
	public UsuarioDTO recuperarPasswordEmail(String _usuario, String _email);

}
