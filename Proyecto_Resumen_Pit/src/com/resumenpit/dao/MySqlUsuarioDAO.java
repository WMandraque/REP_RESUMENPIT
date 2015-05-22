package com.resumenpit.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis.MyBatisFactorySqlSession;

import org.apache.ibatis.session.SqlSession;

import com.resumenpit.interfaces.UsuarioDAO;
import com.resumenpit.models.UsuarioDTO;

public class MySqlUsuarioDAO extends MyBatisFactorySqlSession  implements UsuarioDAO 
{


	public UsuarioDTO recuperarPasswordEmail(String _usuario, String _email)
	{
		UsuarioDTO r_usuario=null;
		try 
		{
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("_usuario", _usuario);
			map.put("_email", _email);
           r_usuario=abrirSession().selectOne("UsuarioSQL.SQL_recuperarPasswordEmail", map);
		}
		catch (Exception e)
		{
			System.out.println("Error en recuperarPasswordEmail() --> "+e);
		}
		finally
		{
			cerrarSession();
		}
	return r_usuario;
	}
	
	@Override
	public int insertarUsuario(UsuarioDTO _usuario) 
	{
		int r=0;
		try 
		{
		 r=abrirSession().insert("UsuarioSQL.SQL_registrarUsuario", _usuario);
		 commit();
			
		} 
		catch (Exception e) 
		{
			System.out.println("Error al registrar usuario: "+e);
		}
		finally
		{	
		  cerrarSession();
		}
		return r;
	}
	
	public int actualizarUsuario(UsuarioDTO _usuario)
	{
		int r=0;
		try 
		{
			r=abrirSession().update("UsuarioSQL.SQL_actualizarUsuario", _usuario);
			commit();

		} 
		catch (Exception e) 
		{
			rollback();
			System.out.println("Error en actualizarUsuario() -->"+e);
		}
		finally
		{
			cerrarSession();
		}
	return r;
	}

	
	public int eliminarUsuario(String _usuario) {

		int r=0;
		try 
		{
			 r=abrirSession().delete("UsuarioSQL.SQL_eliminarUsuario", _usuario);
			 commit();
		} 
		catch (Exception e) 
		{
			rollback();
			System.out.println("Error eliminarUsuario() -->"+e);
		}finally
		{
            cerrarSession();         
        }
		return r;
	}
	
	
	
	@Override
	public UsuarioDTO validarUsuario(UsuarioDTO _usuario) 
	{
		UsuarioDTO user=null;
		try 
		{
		   
		   user=abrirSession().selectOne("UsuarioSQL.SP_validarLogueo", _usuario);
		} 
		catch (Exception e) 
		{
			System.out.println("Error validarUsuario() --> "+e);
		}
		finally
		{
			cerrarSession();
		}
		return user;
	}
	
	
	@Override
	public UsuarioDTO buscarUsuario(String _usuario) 
	{
		
		UsuarioDTO usuarioX=null;
		try 
		{
		  usuarioX=abrirSession().selectOne("UsuarioSQL.SQL_buscarUsuario", _usuario);			
		} 
		catch (Exception e) 
		{
		  System.out.println("Error buscarUsuario() --->"+e);	
		}finally
		{
         cerrarSession();
		}
		return usuarioX;
	}
	
	

	public List<UsuarioDTO> buscarUsuarios(String _parametro, String _valor)
	{
		List<UsuarioDTO> listadoUsuario=new ArrayList<UsuarioDTO>();
		
		try 
		{
			Map<String, Object> param=new HashMap<String, Object>();
			param.put("_parametro", _parametro);
			param.put("_valor", _valor+"%");
			
			listadoUsuario=abrirSession().selectList("UsuarioSQL.SQL_listadoUsuarios", param);
		} 
		catch (Exception e) 
		{
			System.out.println("Error en buscarUsuarios() -->" +e);
		}
		finally
		{
			cerrarSession();
		}
       return listadoUsuario;
	}

}
