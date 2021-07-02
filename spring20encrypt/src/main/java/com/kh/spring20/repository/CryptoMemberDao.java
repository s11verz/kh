package com.kh.spring20.repository;

import com.kh.spring20.entity.CryptoMemberDto;

public interface CryptoMemberDao {
	void join(CryptoMemberDto cryptoMemberDto);
	CryptoMemberDto login(CryptoMemberDto cryptoMemberDto);
}