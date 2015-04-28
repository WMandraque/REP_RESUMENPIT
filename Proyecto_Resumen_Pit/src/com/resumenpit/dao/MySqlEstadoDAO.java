package com.resumenpit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.resumenpit.interfaces.EstadoDAO;
import com.resumenpit.models.EstadoDTO;
import com.resumenpit.utils.GenericDAOImpl;

public class MySqlEstadoDAO extends GenericDAOImpl implements EstadoDAO {

	PreparedStatement pst=null;
	ResultSet rs=null;
	
	@Override
	public List<EstadoDTO> listarEstados() 
	{
		List<EstadoDTO> listadoEstado=new ArrayList<EstadoDTO>();
		try 
		{
			abrirConexion();
			String sql="select * from tb_estado";
			pst=getConection().prepareStatement(sql);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				listadoEstado.add(new EstadoDTO(rs.getInt(1), rs.getString(2)));
			}

		} 
		catch (Exception e) 
		{
			System.out.println("Error en ");
			
		}
		finally
		{
			try 
			{
				cerrarConexion();
				rs.close();
				pst.close();
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
			
		}
		return listadoEstado;
	}

}
