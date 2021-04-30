package quiz.program;

import java.util.List;

import quiz.beans.MusicDao;
import quiz.beans.MusicDto;

public class Test06 {
	public static void main(String[] args) throws Exception {
		
		MusicDao musicDao=new MusicDao();
		List<MusicDto> musicChart=musicDao.top3();
		
		for(MusicDto musicDto:musicChart) {
			System.out.println(musicDto);
		}
	}

}
