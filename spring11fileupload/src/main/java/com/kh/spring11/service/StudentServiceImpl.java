package com.kh.spring11.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring11.entity.StudentDto;
import com.kh.spring11.entity.StudentProfileDto;
import com.kh.spring11.entity.StudentVO;
import com.kh.spring11.repository.StudentDao;
import com.kh.spring11.repository.StudentProfileDao;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private StudentProfileDao studentProfileDao;
	
	@Override
	public void studentRegistration(StudentVO studentVO) throws IllegalStateException, IOException {
		//1. 학생 번호를 획득
		int studentNo = studentDao.sequence();
		
		//2. 학생을 등록
		StudentDto studentDto = StudentDto.builder()
												.studentNo(studentNo)
												.studentName(studentVO.getStudentName())
												.studentEmail(studentVO.getStudentEmail())
											.build();
		studentDao.insert(studentDto);
		
		if(!studentVO.getStudentProfile().isEmpty()) {
			//3. 학생 프로필 파일 등록(파일이 있을 경우에만)
			// = 파일 이름을 학생 번호로 설정(파일이 1개이기 때문)
			File dir = new File("/Users/silverz/git/upload/student");
			dir.mkdirs();//폴더 생성 명령
			String fileName = String.valueOf(studentNo);
			File target = new File(dir, fileName);
			studentVO.getStudentProfile().transferTo(target);
			
			//4. 학생 프로필 정보 등록(파일이 있을 경우에만)
			StudentProfileDto studentProfileDto = 
					StudentProfileDto.builder()
					.profileUploadName(studentVO.getStudentProfile().getOriginalFilename())
					.profileSaveName(fileName)
					.profileContentType(studentVO.getStudentProfile().getContentType())
					.profileSize(studentVO.getStudentProfile().getSize())
					.profileOrigin(studentNo)
					.build();
			studentProfileDao.insert(studentProfileDto);
		}
	}


}
