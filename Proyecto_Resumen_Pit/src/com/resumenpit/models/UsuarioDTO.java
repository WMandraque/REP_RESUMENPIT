package com.resumenpit.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class UsuarioDTO extends PersonaDTO
{
	

	private String usuario;
	private String clave;
	private Date   fechaAcceso;
	private EstadoDTO    estado;
	
	

	public String getUsuario() 
	{
		return usuario;
	}

	public void setUsuario(String usuario) 
	{
		this.usuario = usuario;
	}

	public String getClave() 
	{
		return clave;
	}

	public void setClave(String clave)
	{
		this.clave = clave;
	}

	public EstadoDTO getEstado() 
	{
		return estado;
	}

	public void setEstado(EstadoDTO estado) 
	{
		this.estado = estado;
	}

	public Date getFechaAcceso() 
	{
		return fechaAcceso;
	}
	

	public void setFechaAcceso(Date fechaAcceso) 
	{
		this.fechaAcceso = fechaAcceso;
	}
	



}
