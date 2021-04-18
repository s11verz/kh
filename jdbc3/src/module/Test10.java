package module;

import java.util.List;

import beans.AcademyDao;
import beans.AcademyDto;

public class Test10 {
	public static void main(String[] args) throws Exception {
		
//		데이터 준비
		String keyword = "부산점";
		
//		데이터베이스 검색
		AcademyDao academyDao = new AcademyDao();
		List<AcademyDto> list = academyDao.searchList(keyword);
		
//		출력
		if(list.isEmpty()) {//list.size() == 0
			System.out.println("검색결과가 존재하지 않습니다");
		}
		else {
			System.out.println("검색결과 : "+list.size()+"개");
			for(AcademyDto academyDto : list) {
				System.out.print(academyDto.getAcademyNo());
				System.out.print("/");
				System.out.print(academyDto.getAcademyName());
				System.out.println();
			}
		}
	}
}