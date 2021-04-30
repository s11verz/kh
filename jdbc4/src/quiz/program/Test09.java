package quiz.program;

import quiz.beans.MusicDao;

public class Test09 {
	public static void main(String[] args) throws Exception {
		
		long music_no=2L;
		
		MusicDao musicDao=new MusicDao();
		boolean result=musicDao.delete(music_no);
		
		if(result) {
			System.out.println("음원 삭제 완료");
		}else {
			System.out.println("해당 번호의 음원은 존재하지 않습니다.");
		}
	}

}
