package com.kh.home.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.home.entity.MemberDto;

@Repository
public class MemberDaoMybatis implements MemberDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(MemberDto memberDto) {
		sqlSession.insert("member.regist", memberDto);
	}

	@Override
	public MemberDto login(MemberDto memberDto) {
		return sqlSession.selectOne("member.login", memberDto);
	}

	@Override
	public MemberDto get(int memberNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int memberNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(int memberNo, String curPassword, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeInformation(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
