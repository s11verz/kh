package com.kh.spring11.repository;

import com.kh.spring11.entity.StudentDto;

public interface StudentDao {

	int sequence();
	void insert(StudentDto studentDto);
}
