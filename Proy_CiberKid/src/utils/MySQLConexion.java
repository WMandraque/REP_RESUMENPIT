package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion 
{
	
	//Constante para localizar la url de conexion con la bd
	static final String URL_BD_MYSQL="jdbc:mysql://localhost:3306/base?user=root&password=mysql";
	
	/**
	 * Carga en Memoria el Driver de MySQL
	 */
	static 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException ex) 
		{
		    System.out.println("No hay Driver!!"+ex);
		}
	}
	
	
	/**
	 * Retorna una conexión de la Base de Datos MySQL
	 */
	public static Connection getConnection()
	{
		//Creamos un objeto de tipo connection e inicializamos en null
		Connection connection=null;
		try 
		{
			connection = DriverManager.getConnection(URL_BD_MYSQL);
			//Desabilitamos el autocommit en modo false, para ya nostros trabajarlo
			connection.setAutoCommit(false);
	    }
		catch(SQLException ex)
		{
		 System.out.println("Error con la BD");
		}
		
		return connection;
	}


}
