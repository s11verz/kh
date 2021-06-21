package kh.exam.model.dao;

import org.apache.ibatis.session.SqlSession;

import kh.exam.model.vo.Member;

public class MemberDao {

public int insertMember(SqlSession session, Member m) {

return session.insert("mybatis.insertMember",m);

}

}