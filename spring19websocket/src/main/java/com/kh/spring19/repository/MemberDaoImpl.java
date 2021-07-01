package com.kh.spring19.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring19.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberDto login(MemberDto memberDto) {
		
		return sqlSession.selectOne("member.login",memberDto);
	}
	
	@Override
	public MemberDto get(int memberNo) {
		return sqlSession.selectOne("member.get",memberNo);
	}
}
