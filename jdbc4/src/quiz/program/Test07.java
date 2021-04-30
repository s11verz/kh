package quiz.program;

import java.util.List;

import quiz.beans.MusicDao;
import quiz.beans.MusicDto;

public class Test07 {
public static void main(String[] args) throws Exception {
	
	String keyword="아이유";
	
	MusicDao musicDao=new MusicDao();
	List<MusicDto> searchList=musicDao.searchByArtist(keyword);
	
	if(searchList.isEmpty()) {
		System.out.println("검색 결과가 존재하지 않습니다.");
	}else {
		System.out.println("총"+searchList.size()+"개의 검색 결과가 존재합니다.");
		for(MusicDto musicDto:searchList) {
			System.out.println(musicDto);
		}
	}
}
}
