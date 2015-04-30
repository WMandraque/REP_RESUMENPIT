package com.resumenpit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;





import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.resumenpit.interfaces.EstadoDAO;
import com.resumenpit.models.EstadoDTO;
import com.resumenpit.utils.GenericDAOImpl;
import com.resumenpit.utils.SQLMyBatisMapper;

public class MySqlEstadoDAO extends GenericDAOImpl implements EstadoDAO {

	PreparedStatement pst=null;
	ResultSet rs=null;
	
	
	
	@Override
	public List<EstadoDTO> listarEstados() 
	{
		List<EstadoDTO> listadoEstados=new ArrayList<EstadoDTO>();
		SqlSession session=new SQLMyBatisMapper().getSession().openSession();
		
		try 
		{
			//Creamos un Objeto de tipo SqlSessionFactory e inicializamos
			listadoEstados=session.selectList("EstadoSQL.SQL_listaEstados");
			
		} 
		catch (Exception e) 
		{
			System.out.println("Error en listarEstados() ---> "+e);
		}
		finally
		{
		 session.close();
		}

		return listadoEstados;
	}

}
