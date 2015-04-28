package com.resumenpit.interfaces;

import java.util.List;

import com.resumenpit.models.UsuarioDTO;

public interface UsuarioDAO 
{
	
	UsuarioDTO validarUsuario(String usuario, String clave);
	int insertarUsuario(UsuarioDTO usuario);
	List<UsuarioDTO> listadoUsuario();
	UsuarioDTO buscarUsuario(String usuario); 
	int eliminarUsuario(String usuario);	
	List<UsuarioDTO> buscarUsuarios(String nombre);

}
