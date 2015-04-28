package utils;

import java.sql.Connection;

public interface ConexionDao 
{
	
	Connection getConexion();
	void abriConexion();
	void cerrarConexion();
	void commit();
	void rollback();

}
