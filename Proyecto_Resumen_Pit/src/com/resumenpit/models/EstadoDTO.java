package com.resumenpit.models;
import java.util.*;


public class EstadoDTO 
{
	
	private int idEstado;
	private String descripcion;
	
	
	private  List<UsuarioDTO> listadoUsuarios;

	public List<UsuarioDTO> getListadoUsuarios() 
	{
		return listadoUsuarios;
	}
	public void setListadoUsuarios(List<UsuarioDTO> listadoUsuarios) 
	{
		this.listadoUsuarios = listadoUsuarios;
	}
	
	
	
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
