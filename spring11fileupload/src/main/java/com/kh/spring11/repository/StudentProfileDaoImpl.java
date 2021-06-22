package com.kh.spring11.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring11.entity.StudentProfileDto;

@Repository
public class StudentProfileDaoImpl implements StudentProfileDao{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(StudentProfileDto studentProfileDto) {
		sqlSession.insert("studentProfile.insert",studentProfileDto);
	}
	@Override
	public StudentProfileDto getByOrigin(int studentProfileOrigin) {
		return sqlSession.selectOne("stuentProfile.getByOrigin", studentProfileOrigin);
	}

}
