package com.kh.spring09;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class Test02 {
	
	@Test
	public void test() throws IOException {
		
		InputStream in=Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		
		//SqlSession sqlSession=factory.openSession();//openSesiion(false)와 동일 
		//SqlSession sqlSession=factory.openSession(true);//자동커밋 사용 
		SqlSession sqlSession=factory.openSession(false);//자동커밋 미사용 
		//System.out.println(sqlSession);
		
		sqlSession.insert("item.insert");
		sqlSession.commit();
		
	}

}
