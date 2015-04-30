package com.resumenpit.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;

public class SQLMyBatisMapper 
{
	private String     resource="mybatis-config.xml";
	private SqlSessionFactory sqlMapper=null;
	

	public SqlSessionFactory getSession()
	{
		try 
		{
			Reader reader=Resources.getResourceAsReader(resource);
			sqlMapper=new SqlSessionFactoryBuilder().build(reader);
           
		} 
		catch (Exception e) 
		{
			System.out.println("Error en SessionFactory getSession() --->"+e);
		}
		
		return sqlMapper;
	}

}
