package com.resumenpit.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.resumenpit.interfaces.UsuarioDAO;
import com.resumenpit.models.EstadoDTO;
import com.resumenpit.models.UsuarioDTO;
import com.resumenpit.utils.GenericDAOImpl;
import com.resumenpit.utils.SQLMyBatisMapper;

public class MySqlUsuarioDAO  extends GenericDAOImpl implements UsuarioDAO 
{

	PreparedStatement pst=null;
	CallableStatement cst=null;
	ResultSet rs=null;
	@Override
	public UsuarioDTO validarUsuario(String usuario, String clave) 
	{
		UsuarioDTO user=null;
		
		try 
		{
			abrirConexion();
			String sql="select * From tb_usuario as u "
					+ "inner join tb_estado as e "
					+ "on u.idestado=e.idestado"
					+ " where usuario=? and clave=?";
			pst=getConection().prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, clave);
			
			ResultSet rs=pst.executeQuery();
			if (rs.next()) 
			{
			   EstadoDTO regEstado=new EstadoDTO();
			   regEstado.setIdEstado(rs.getInt(7));
			   regEstado.setDescripcion(rs.getString(8));
			   user=new UsuarioDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), regEstado);	
			}
			
		} 
		catch (Exception e) 
		{
			System.out.println("Error: validarUsuario() --> "+e);
		}
		finally
		{
			try 
			{
			   cerrarConexion();
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return user;
	}
	
	@Override
	public int insertarUsuario(UsuarioDTO usuario) {
		

		int r=0;

		
		try {
		 
			abrirConexion();
			
			String sql="{call usp_insertarUsuario(?, ?, ?, ?, ?, ?)}";
			cst=getConection().prepareCall(sql);
			cst.setString(1, usuario.getUsuario());
			cst.setString(2, usuario.getClave());
			cst.setString(3, usuario.getNombre());
			cst.setString(4, usuario.getApellido());
			cst.setString(5, ""+usuario.getFechaAcceso());
			cst.setInt(6, usuario.getEstado().getIdEstado());
			
	        r=cst.executeUpdate();
		
			commit();
			
		} catch (Exception e) {
			
			System.out.println("Error al registrar usuario: "+e);
		
			try {
				rollBack();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
			
		}
		finally
		{	
			try {
				cerrarConexion();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return r;
	}
	
	public List<UsuarioDTO> listadoUsuario()
	{
		List<UsuarioDTO> listadoUsuario=new ArrayList<UsuarioDTO>();
		try 
		{
			abrirConexion();
			String sql="select * from tb_usuario as u inner join tb_estado as e on u.idestado=e.idestado";
			pst=getConection().prepareStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()) 
			{
				  EstadoDTO regEstado=new EstadoDTO();
				   regEstado.setIdEstado(rs.getInt(7));
				   regEstado.setDescripcion(rs.getString(8));
			   	listadoUsuario.add(new UsuarioDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), regEstado));
			}

		}
		catch (Exception e) 
		{
			System.out.println("Error en : listadoUsuario() --> "+e);
		}
		finally
		{
			try 
			{
				pst.close();
				rs.close();
			} catch (Exception e) {
				System.out.println("Error en ");
			}
		}
		
		return listadoUsuario;	
	}
	
	
	@Override
	public UsuarioDTO buscarUsuario(String usuario) 
	{
		
		UsuarioDTO usuarioX=null;
		try {
			
			abrirConexion();
			
			String sql="select*From tb_usuario where usuario=?";
			pst=getConection().prepareStatement(sql);
			pst.setString(1, usuario);
			rs=pst.executeQuery();
			
			if(rs.next())
			{
				  EstadoDTO regEstado=new EstadoDTO();
				   regEstado.setIdEstado(rs.getInt(7));
				   regEstado.setDescripcion(rs.getString(8));
		      usuarioX=new UsuarioDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), regEstado);
			}
			
		} catch (Exception e) 
		{
		  System.out.println("Error al buscar usuario: "+e);	
		}finally
		{
			try {
				cerrarConexion();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return usuarioX;
	}
	
	
	
	public int eliminarUsuario(String usuario) {

		 int r=0;
		 try {
	         abrirConexion();
			 String sql="delete from tb_usuario where usuario=?";
			 pst=getConection().prepareStatement(sql);
			 pst.setString(1, usuario);
			 r=pst.executeUpdate();
			 commit();

			
		} catch (Exception e) {
			System.out.println("Error al eliminar  usuario: "+e);
		}finally{
                try {
					cerrarConexion();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
		return r;
	}
	
	
	public List<UsuarioDTO> buscarUsuarios(String _parametro, String _valor)
	{
		List<UsuarioDTO> listadoUsuario=new ArrayList<UsuarioDTO>();
		/*try 
		{
			abrirConexion();
			String sql="SELECT * FROM tb_usuario as u inner join tb_estado as e "
					+ "on u.idestado=e.idestado "
					+ "where nombre like ?";
			pst=getConection().prepareStatement(sql);
			pst.setString(1, nombre+"%");
			rs=pst.executeQuery();
			while (rs.next())
			{
				  EstadoDTO regEstado=new EstadoDTO();
				   regEstado.setIdEstado(rs.getInt(7));
				   regEstado.setDescripcion(rs.getString(8));
				   listadoUsuario.add(new UsuarioDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), regEstado));				
			}
			
			

		} catch (Exception e) {
			System.out.println("Error en buscarUsuarios() -->"+e);
		}
		finally
		{
			try {
				rs.close();
				cerrarConexion();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		SqlSession session=new SQLMyBatisMapper().getSession().openSession();
		try 
		{
			Map<String, Object> param=new HashMap<String, Object>();
			param.put("_parametro", _parametro);
			param.put("_valor", _valor+"%");
			
			listadoUsuario=session.selectList("UsuarioSQL.SQL_listadoUsuarios", param);
			
			


		} 
		catch (Exception e) 
		{
			System.out.println("Error en buscarUsuarios() -->" +e);
		}
		finally
		{
			session.close();
		}
       return listadoUsuario;
	}

}
