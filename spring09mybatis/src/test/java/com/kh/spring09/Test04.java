package com.kh.spring09;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kh.spring09.entity.ItemDto;



public class Test04 {
	
private SqlSession sqlSession;
	
	@Before
	public void before() throws IOException {
		InputStream in=Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		sqlSession=factory.openSession(false);
	}
	
	@Test
	public void test() {
		List<ItemDto> list=sqlSession.selectList("item.select1");
		
		for(ItemDto itemDto:list) {
			System.out.println(itemDto);
		}
	}
	
	
	@After
	public void after() {
		//sqlSession.commit();
		sqlSession.rollback();
		
	}

}
