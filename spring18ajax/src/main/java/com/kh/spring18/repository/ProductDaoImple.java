package com.kh.spring18.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.kh.spring18.entity.ProductDto;

@Repository
public class ProductDaoImple implements ProductDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ProductDto> list() {
		
//		return sqlSession.selectList("product.select01");
		return sqlSession.selectList("product.select03");
	}
	
	@Override
	public List<ProductDto> search(String name){
//		return sqlSession.selectList("product.select02",name);
		return sqlSession.selectList("product.select03",name);
	}
}
