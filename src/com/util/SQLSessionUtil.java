package com.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SQLSessionUtil{
	
	  private static SqlSessionFactory  factory=null;
      // static
	  static Reader read=null;
	  
	  static{
		   String config="mybatis-config.xml";
		   try {
			 read= Resources.getResourceAsReader(config);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	  }
	  
	  /**
	   * 
	   * @return
	   *
	   */
	  private static  SqlSessionFactory  getSqlSessionFactory(){
		   if(factory==null){
			   factory =new SqlSessionFactoryBuilder().build(read);
		   }
		    return factory;
	  }
	  
	  
	  /***
	   * 
	   *  
	   */
	  
	  public  static  SqlSession getSqlSession(){
		  //return getSqlSessionFactory().openSession();
		  return getSqlSessionFactory().openSession(true);
	  }
	
	
}
