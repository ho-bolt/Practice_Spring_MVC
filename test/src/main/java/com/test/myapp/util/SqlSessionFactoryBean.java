package com.test.myapp.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
	private static SqlSessionFactory sessionFactory=null; 
	//이 sqlsessionFactory를 이용하기 위해선 재료를 pom.xml에 넣어주어야 한다. 
	//멤버로 factory를 가지고 있고 그러면 아래에서 session을 만든다. 
	
	static {
		if(sessionFactory==null) {
			try {
				Reader reader=Resources.getResourceAsReader("sql-map-config.xml");// 1. 어떤 config파일을 참조해서 만들지 써주면
				sessionFactory=new SqlSessionFactoryBuilder().build(reader);//2. factory자체를 만들어 낸다음 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//static 객체와 무관하게, 프로그램 수준으로
	public static SqlSession getSqlSessionInstance(){
		return sessionFactory.openSession(); //3. factory에서 session을 만들어 낸다. 
	}
	
}
