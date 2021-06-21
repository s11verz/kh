package kh.exam.model.service;

import java.io.IOException;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.session.SqlSessionFactory;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kh.exam.model.dao.MemberDao;

import kh.exam.model.vo.Member;

public class MemberService {

public SqlSession getSqlSession() {

SqlSession session = null;

String resource = "/mybatis-config.xml";

try {

InputStream is = Resources.getResourceAsStream(resource);

SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

SqlSessionFactory factory = builder.build(is);

session = factory.openSession(false);

} catch (IOException e) {

// TODO Auto-generated catch block

e.printStackTrace();

}

return session;

}

public int insertMember(Member m) {

SqlSession session = getSqlSession();

int result = new MemberDao().insertMember(session,m);

if(result>0) {

session.commit();

}else {

session.rollback();

}

session.close();

return result;

}

}