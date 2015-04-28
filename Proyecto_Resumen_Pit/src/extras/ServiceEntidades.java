package extras;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.rowset.CachedRowSet;

import org.apache.catalina.webresources.CachedResource;

import com.resumenpit.utils.GenericDAOImpl;
import com.sun.rowset.CachedRowSetImpl;


public class ServiceEntidades extends GenericDAOImpl 
{

	 PreparedStatement pst=null;
	 ResultSet         rs=null;
	
	public CachedRowSet QueryTemporales(String query) throws Exception
	{
		CachedRowSet crs=null;
		
		try 
		{
			abrirConexion();
			String sql=query;
			pst=getConection().prepareStatement(sql);
			rs=pst.executeQuery();
			crs=new CachedRowSetImpl();
			crs.populate(rs);
		} catch (Exception e) 
		{
			System.out.println("Error en crs() ---> "+e);
			cerrarConexion();
		}
		  return crs;  
	}
	

}
