package com.resumenpit.actions;



import java.util.List;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
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
	private  UsuarioDTO usuario;
	private  List<UsuarioDTO> listadoUsuarios;
	private  List<EstadoDTO>  listadoEstados;
	
	//Metodo a implementar del implements Preparable
	//Este metodo se ejecutara en el tiempo de frameworks que es antes de lanzar el proyecto
	//Este metodo es parte de la clase ActionSuport
	//Inicializa lo que querramos antes de lanzar el proyecto
	@Override
	public void prepare() throws Exception 
	{
		
		EstadoService servEstado=new EstadoService();
		listadoEstados=servEstado.listarEstados();
		System.out.println("Tamaño: "+listadoEstados.size());
		for (int i = 0; i < listadoEstados.size(); i++) 
		{
		  System.out.println("---->: "+listadoEstados.get(i).getIdEstado());
		  System.out.println("---->: "+listadoEstados.get(i).getDescripcion());
		}
	}



    
	public String validarLogueo()
	{
		//Servicio
		UsuarioServices sUsuario=new UsuarioServices();
	
		//Trabajaremos con las constantes que nos provee
		//La clase extendida ActionSupport, que son SUCCESS y ERROR
		  String resultado=ERROR;
		  UsuarioDTO user=sUsuario.validarUsuario(usuario.getUsuario(), usuario.getClave());
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
		UsuarioDTO user=sUsuario.validarUsuario(usuario.getUsuario(), usuario.getClave());
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
	
	
	public String reporte()
	{
		UsuarioServices su=new UsuarioServices();
		
		addActionMessage("Total de clientes: "+su.listadoUsuario().size());
		
		return SUCCESS;
	}
	
	public String listar()
	{
	
		UsuarioServices su=new UsuarioServices();
		listadoUsuarios=su.listadoUsuario();
		if (listadoUsuarios.size()>0) 
		{
			addActionMessage("Cantidad de registros encontrados: "+listadoUsuarios.size());
 		}
		else
		{
			addActionMessage("No se encontraron registros");
		}
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
		listadoUsuarios=su.buscarUsuarios(usuario.getNombre());
		if (listadoUsuarios.size()>0) 
		{
			addActionMessage("Cantidad de registros encontrados: "+listadoUsuarios.size());
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
		int e=su.eliminarUsuario(usuario.getUsuario());
		
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




	public List<EstadoDTO> getListadoEstados() {
		return listadoEstados;
	}




	public void setListadoEstados(List<EstadoDTO> listadoEstados) {
		this.listadoEstados = listadoEstados;
	}




}
