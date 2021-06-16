package com.kh.home.repository;

import com.kh.home.entity.MemberDto;

public interface MemberDao {

	void insert(MemberDto memberDto);
	MemberDto login(MemberDto memberDto);
	MemberDto myinfo(MemberDto memberDto);
}
