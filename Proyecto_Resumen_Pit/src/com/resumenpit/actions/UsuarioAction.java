package com.resumenpit.actions;



import java.util.List;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.resumenpit.dao.MySqlUsuarioDAO;
import com.resumenpit.models.EstadoDTO;
import com.resumenpit.models.UsuarioDTO;
import com.resumenpit.service.EstadoService;
import com.resumenpit.service.UsuarioServices;
import com.resumenpit.utils.Constantes;


// Implementamos "Preparable". Ejecuta primero el framework("intercepto prepare") 
// para prepargar datos en el metodo
@SuppressWarnings("serial")
@ParentPackage("default")
public class UsuarioAction extends ActionSupport implements Preparable
{

	


	//Declaramos como global el objeto UsuarioDTO
	//Ademas creamos sus respectivos set y get para
	//Asi poder trabajar directamente con la vista
	//Por que los objetos declarados son los que interactuan con
	//La vista
	private  UsuarioDTO usuario=new UsuarioDTO();
	private  List<UsuarioDTO> listadoUsuarios;
	private  List<EstadoDTO>  listadoEstados;
	
	//Metodo a implementar del implements Preparable
	//Este metodo se ejecutara en el tiempo de frameworks que es antes de lanzar el proyecto
	//Este metodo es parte de la clase ActionSuport
	//Inicializa lo que querramos antes de lanzar el proyecto

	public void prepare() throws Exception 
	{
	//Inicializamos para que cada request se realizae en esta clase se cargue los estado
	 EstadoService servEstado=new EstadoService();
	 listadoEstados=servEstado.listarEstados();
	 
	 System.out.println("Se ejecuto el prepare ---->");
	}



    
	public String validarLogueo()
	{
		//Servicio
		UsuarioServices sUsuario=new UsuarioServices();
	
		//Trabajaremos con las constantes que nos provee
		//La clase extendida ActionSupport, que son SUCCESS y ERROR
		  String resultado=ERROR;
		  UsuarioDTO user=sUsuario.validarUsuario(usuario);
		  if (user!=null) 
		  {
			//Metodo de la clase ActionSupport, que nos servira para enviar mensaje  
			addActionMessage(Constantes.MENSAJE_REGISTRO_EXITOSO);
			resultado=SUCCESS;
		  }
		  addActionError(Constantes.MENSAJE_REGISTRO_ERROR);
		  return resultado;
	}
	
	
	@Action(value="/validarLogueo2", results={
			@Result(location="/WEB-INF/paginas/principal.jsp", name="success"),
			@Result(location="/WEB-INF/paginas/logueo_v2.jsp", name="error")
			})
	public String validarLogueo2()
	{
		//Servicio
		UsuarioServices sUsuario=new UsuarioServices();
	
		String resultado=ERROR;
		UsuarioDTO user=sUsuario.validarUsuario(usuario);
		if (user!=null) 
		{
		   resultado=SUCCESS;	
		}
		return resultado;
	}
	
	
	public String registrarUsuario()
	{
		String vista=ERROR;
		
		UsuarioServices sUsuario=new UsuarioServices();
		int r=sUsuario.insertarUsuario(usuario);
		
		if (r!=0) 
		{
		   addActionMessage("Usuario registrado : "+usuario.getUsuario());	
		   vista=SUCCESS;
		}
		else
		{
		  addActionError("Error al registrar usuario");
		}
		
	return vista;
	}
	
	public String actualizar()
	{
		int r=new MySqlUsuarioDAO().actualizarUsuario(usuario);
		if(r>0)
		{
		  return "listado";	
		}
		
	return "actualizar";
	}
	
	
	public String reporte()
	{
		UsuarioServices servUsuario=new UsuarioServices();
		
		addActionMessage("Total de clientes: "+servUsuario.buscarUsuarios("","").size());
		
		return SUCCESS;
	}
	
	public String listar()
	{
         listadoUsuarios=new UsuarioServices().buscarUsuarios("", "");
		 addActionMessage(Constantes.MENSAJE_CANTIDAD_REG+listadoUsuarios.size());
		return "listado";
	}
	
	public String cargar()
	{
		UsuarioServices su=new UsuarioServices();
		usuario=su.buscarUsuario(usuario.getUsuario());
		
		return "actualizar";
	}
	//type="redirectAction"
	
	public String buscar()
	{
		UsuarioServices su=new UsuarioServices();
		listadoUsuarios=su.buscarUsuarios("nombre", usuario.getNombre());
		if (listadoUsuarios.size()>0) 
		{
			 addActionMessage(Constantes.MENSAJE_CANTIDAD_REG+listadoUsuarios.size());
 		}
		else
		{
			addActionMessage("No se encontraron registros");
		}
		return "listado";
	}
	
	
	public String eliminar()
	{
		UsuarioServices su=new UsuarioServices();
		su.eliminarUsuario(usuario.getUsuario());
		
		listar();
		
		return "listado";
	}
	

	
	
	




    //Set and Get
	public UsuarioDTO getUsuario() 
	{
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) 
	{
		this.usuario = usuario;
	}


	public List<UsuarioDTO> getListadoUsuarios() {
		return listadoUsuarios;
	}



	public List<EstadoDTO> getListadoEstados() 
	{
		return listadoEstados;
	}
	
	public void setListadoUsuarios(List<UsuarioDTO> listadoUsuarios) {
		this.listadoUsuarios = listadoUsuarios;
	}






}
