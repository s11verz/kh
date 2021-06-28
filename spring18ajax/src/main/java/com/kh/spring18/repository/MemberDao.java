package com.kh.spring18.repository;

import java.util.List;

import com.kh.spring18.entity.MemberDto;

public interface MemberDao {
	MemberDto get(String memberId);
	boolean exist(String memberId);
	List<MemberDto> list();
}