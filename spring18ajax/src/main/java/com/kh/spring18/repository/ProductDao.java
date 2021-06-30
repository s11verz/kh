package com.kh.spring18.repository;

import java.util.List;

import com.kh.spring18.entity.ProductDto;

public interface ProductDao {

	List<ProductDto> list();
	List<ProductDto> search(String name);
	
}
