package com.kh.spring09;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kh.spring09.entity.ItemDto;

public class Test08 {
	
	private SqlSession sqlSession;
	
	@Before
	public void before() throws IOException {
		InputStream in=Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		sqlSession=factory.openSession(false);
	}
	
	@Test
	public void update() {
		ItemDto itemDto=ItemDto.builder()
								.itemNo(21)
								.itemName("바뀐상품")
								.itemPrice(10000)
								.build();
		
		int count=sqlSession.update("item.update1",itemDto);
		System.out.println("count="+count);
	}
	
	@Test
	public void delete() {
		int itemNo=21;
		int count=sqlSession.delete("item.delete1",itemNo);
		System.out.println("삭제 count="+count);
	}
	
	
	@After
	public void after() {
		//sqlSession.commit();
		sqlSession.rollback();
		
	}


}
























