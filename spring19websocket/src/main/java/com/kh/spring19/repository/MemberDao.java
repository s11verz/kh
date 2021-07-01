package com.kh.spring19.repository;

import com.kh.spring19.entity.MemberDto;

public interface MemberDao {
	MemberDto login(MemberDto memberDto);
	MemberDto get(int memberNo);
}
