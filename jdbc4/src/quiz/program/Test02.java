package quiz.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import quiz.beans.MusicDao;
import quiz.beans.MusicDto;

public class Test02 {
	public static void main(String[] args) throws Exception {
		
		MusicDto musicDto=new MusicDto();
		musicDto.setMusicNo(1L);
		musicDto.setMusicName("아아");
		musicDto.setMusicArtist("박은지");
		musicDto.setMusicAlbum("앨범");
		
		MusicDao musicDao=new MusicDao();
		boolean result=musicDao.change(musicDto);
		
		if(result) {
			System.out.println("음원 정보 변경이 완료되었습니다");
			
		}else {
			System.out.println("해당 번호의 음원이 존재하지 않습니다");
		}
		
	}

}
