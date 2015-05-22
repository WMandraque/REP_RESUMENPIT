package mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;

public class MyBatisFactorySqlSession 
{
	//Definimos la ruta del mybatis-config.xml
	private String            resource="mybatis/mybatis-config.xml";
	private SqlSessionFactory sqlSessionFactory=null;
	private SqlSession        session;
	

	private SqlSessionFactory getSession()
	{
		try 
		{
			Reader reader=Resources.getResourceAsReader(resource);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader); 
		} 
		catch (Exception e) 
		{
			System.out.println("Error en SessionFactory getSession() --->"+e);
		}
		
		return sqlSessionFactory;
	}
	
	
	public SqlSession abrirSession()
	{
		session=getSession().openSession();
		return session;
		
	}
	
	public void cerrarSession()
	{
		session.close();
	}
	
	public void commit()
	{
		session.commit();
	}
	
	public void rollback()
	{
		session.rollback();
	}


}
