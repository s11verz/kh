package com.kh.spring21.repository;

import java.util.List;

import com.kh.spring21.entity.ProductDto;

public interface ProductDao {
	//목록 기능
	List<ProductDto> list();
	//상세조회 기능
	ProductDto get(int no);
	//특정번호 조회 기능
	List<ProductDto> list(int[] no);
}