package com.kh.spring20.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kh.spring20.entity.CryptoMemberDto;

@Repository
public class CryptoMemberDaoImpl implements CryptoMemberDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void join(CryptoMemberDto cryptoMemberDto) {
		//비밀번호 암호화 코드를 추가
		String password = cryptoMemberDto.getMemberPw();
		String encrypt = passwordEncoder.encode(password);
		cryptoMemberDto.setMemberPw(encrypt);
		sqlSession.insert("cryptoMember.join", cryptoMemberDto);
	}

	@Override
	public CryptoMemberDto login(CryptoMemberDto cryptoMemberDto) {
		CryptoMemberDto find=sqlSession.selectOne("cryptoMember.get",cryptoMemberDto.getMemberId());
		boolean match=passwordEncoder.matches(cryptoMemberDto.getMemberPw(), find.getMemberPw());
		if(match) {
			return find;
		}else {
			return null;
		}
	}

}