package com.resumenpit.models;

public class PersonaDTO 
{
	
	private String nombre;
	private String apellido;
	private String  email;

	

	//Si extendemos una clase y queremos usar un constructor vacio, la clase padre
	//tambien debee poseer el constructor vacio, de lo contrario no se podra
	//crear constructor vacio en la clase hija
	public PersonaDTO(String nombre, String apellido) 
	{
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public PersonaDTO()
	{
		
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	public String getApellido() 
	{
		return apellido;
	}
	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

}
