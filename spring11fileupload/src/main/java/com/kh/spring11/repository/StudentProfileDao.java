package com.kh.spring11.repository;

import com.kh.spring11.entity.StudentProfileDto;

public interface StudentProfileDao {
	
	void insert(StudentProfileDto studentProfileDto);

	StudentProfileDto getByOrigin(int studentProfileOrigin);

}
