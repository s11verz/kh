package com.kh.spring18.repository;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring18.entity.StudentProfileDto;

@Repository
public class StudentProfileDaoImpl implements StudentProfileDao{
	@Autowired
	private SqlSession sqlSession;
	
	private final File baseDir=new File("/Users/silverz/git/upload/student");
	
	@Override
	public StudentProfileDto add(StudentProfileDto studentProfileDto) {
		int profileNo=sqlSession.selectOne("studentProfile.sequence");
		studentProfileDto.setProfileNo(profileNo);
		sqlSession.insert("studentProfile.add",studentProfileDto);
		return studentProfileDto;
	}
	
	  @Override
	   public void save(String fileName, MultipartFile file) throws IllegalStateException, IOException {
	      File target = new File(baseDir, fileName);
	      file.transferTo(target);
	   }
	  
	  @Override
		public StudentProfileDto get(int profileNo) {
			return sqlSession.selectOne("studentProfile.get", profileNo);
		}

		@Override
		public ByteArrayResource getFile(String fileName) throws IOException {
			File target = new File(baseDir, fileName);
			byte[] data = FileUtils.readFileToByteArray(target);
			ByteArrayResource resource = new ByteArrayResource(data);
			return resource;
		}
}
