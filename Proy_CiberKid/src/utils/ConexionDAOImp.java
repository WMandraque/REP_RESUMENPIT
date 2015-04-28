package utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionDAOImp implements ConexionDao 
{

	private Connection conexion=null;
	@Override
	public Connection getConexion() 
	{
	      return conexion;	
	}

	@Override
	public void abriConexion() 
	{
	    try 
	    {
	        conexion=MySQLConexion.getConnection();
		} 
	    catch (Exception e) 
	    {
			System.out.println("Error al abrir Conexion: "+e);
		}	
	}

	@Override
	public void cerrarConexion() 
	{
			try 
			{
		       conexion.close();
			} 
			catch (Exception e) 
			{
				System.out.println("Error al cerrar conexion: "+e);
			}
	}

	@Override
	public void commit() 
	{
		try 
		{
			conexion.commit();
		} catch (SQLException e) 
		{
			System.out.println("Error al hacer commit: "+e);
		}
		
	}

	@Override
	public void rollback() 
	{
	    try 
	    {
			conexion.rollback();
		} catch (SQLException e) 
	    {
			System.out.println("Error al hacer rollback: "+e);
		}
		
	}

	
}
