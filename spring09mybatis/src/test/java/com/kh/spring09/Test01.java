package com.kh.spring09;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

//마이바티스(mybatis)를 사용할 수 있도록 필요한 도구를 생성 
//sqlSessionFactory: 마이바티스 작업을 위한 기본 환경을 구축하는 역할 
public class Test01 {

	@Test
	public void test() throws IOException {
		//마이바티스에서 제고하는 설정 파일 로드 방법 
		InputStream in= Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		
		//도구 생성 
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		System.out.println(factory);
		
		assertNotNull(factory);
	}
}
