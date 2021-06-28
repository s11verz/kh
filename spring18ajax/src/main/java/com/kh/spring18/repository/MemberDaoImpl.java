package com.kh.spring18.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring18.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberDto get(String memberId) {
		return sqlSession.selectOne("member.get", memberId);
	}

	@Override
	public boolean exist(String memberId) {
		return sqlSession.selectOne("member.get", memberId) != null;
	}
	
	@Override
	public List<MemberDto> list() {
		return sqlSession.selectList("member.list");
	}
	
}
