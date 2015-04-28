package com.resumenpit.models;

import java.sql.Date;

public class UsuarioDTO extends PersonaDTO
{
	

	private String usuario;
	private String clave;
	private int    estado;
	private Date   fechaAcceso;
	


	public UsuarioDTO(String usuario, String clave, String nombre, String apellido, int estado, Date fechaAcceso) 
    {
		super(nombre, apellido);
		this.usuario = usuario;
		this.clave = clave;
		this.estado = estado;
		this.fechaAcceso = fechaAcceso;
	}
	
	public UsuarioDTO()
	{
		
	}
	



	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechaAcceso() {
		return fechaAcceso;
	}

	public void setFechaAcceso(Date fechaAcceso) {
		this.fechaAcceso = fechaAcceso;
	}


}
