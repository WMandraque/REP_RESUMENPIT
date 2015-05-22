package com.resumenpit.dao;


import java.util.ArrayList;
import java.util.List;







import mybatis.MyBatisFactorySqlSession;

import org.apache.ibatis.session.SqlSession;

import com.resumenpit.interfaces.EstadoDAO;
import com.resumenpit.models.EstadoDTO;

public class MySqlEstadoDAO extends MyBatisFactorySqlSession  implements EstadoDAO {


	
	
	@Override
	public List<EstadoDTO> listarEstados() 
	{
		List<EstadoDTO> listadoEstados=new ArrayList<EstadoDTO>();		
		try 
		{
			//Creamos un Objeto de tipo SqlSessionFactory e inicializamos
			listadoEstados=abrirSession().selectList("EstadoSQL.SQL_listaEstados");
			
		} 
		catch (Exception e) 
		{
			System.out.println("Error en listarEstados() ---> "+e);
		}
		finally
		{
		 cerrarSession();
		}

		return listadoEstados;
	}

}
