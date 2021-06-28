package com.kh.spring17.repository;

import com.kh.spring17.entity.CertDto;

public interface CertDao {

	void insert(CertDto certDto);
	boolean check(CertDto certDto); 
	void deleteByEmail(String email);
	void clear();
}
