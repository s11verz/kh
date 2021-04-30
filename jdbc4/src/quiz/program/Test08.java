package quiz.program;

import quiz.beans.MusicDao;
import quiz.beans.MusicDto;

public class Test08 {
	public static void main(String[] args) throws Exception {
		
		long music_no=1L;
		
		MusicDao musicDao=new MusicDao();
		MusicDto musicDto=musicDao.get(music_no);
		
		if(musicDto==null) {
			System.out.println("해당 음원정보가 존재하지 않습니다");
		}else {
			System.out.println(musicDto);
		}
	}

}
