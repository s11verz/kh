package com.kh.spring18.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.spring18.entity.ProductDto;

@Repository
public class ProductDaoImple implements ProductDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ProductDto> list() {
		
		return sqlSession.selectList("product.select01");
	}
	
	
}
