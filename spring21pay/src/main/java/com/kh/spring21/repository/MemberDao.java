package com.kh.spring21.repository;

import com.kh.spring21.entity.MemberDto;

public interface MemberDao {
	MemberDto login(MemberDto memberDto);
}