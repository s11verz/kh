package module;

import java.util.List;

import beans.AcademyDao;
import beans.AcademyDto;

public class Test08 {
	public static void main(String[] args) throws Exception {
//		Q : AcademyDao, AcademyDto를 활용한 데이터베이스 조회(Read) 작업을 수행할 수 있는가?
//		= 데이터베이스 조회를 통해서 얻고 싶은 데이터는 ??? 형태이다.
		
//		준비 데이터 : 없음
		
//		데이터베이스 조회
		AcademyDao academyDao = new AcademyDao();
		List<AcademyDto> list = academyDao.select();
		
//		출력
		System.out.println("데이터 개수 : " + list.size());
	}
}