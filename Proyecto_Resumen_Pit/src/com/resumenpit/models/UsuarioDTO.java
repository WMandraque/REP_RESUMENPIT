package com.resumenpit.models;

import java.util.Date;



public class UsuarioDTO extends PersonaDTO
{
	

	private String usuario;
	private String clave;
	private Date   fechaAcceso;
	private EstadoDTO    estado;	
	

	public UsuarioDTO(String usuario, String clave, String nombre, String apellido, Date fechaAcceso, EstadoDTO estado) 
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

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

	public Date getFechaAcceso() {
		return fechaAcceso;
	}

	public void setFechaAcceso(Date fechaAcceso) {
		this.fechaAcceso = fechaAcceso;
	}


}
