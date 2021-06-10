package quiz.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import quiz.beans.MusicDao;

public class Test03 {
	public static void main(String[] args) throws Exception {
		
		long music_no=1L;
		
		MusicDao musicDao=new MusicDao();
		boolean result=musicDao.play(music_no);
		
		if(result) {
			System.out.println("음원 재생이 완료되었습니다");
		}else {
			System.out.println("해당 번호의 음원이 존재하지 않습니다");
		}
		
	}
}
