package quiz.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import quiz.beans.MusicDao;
import quiz.beans.MusicDto;

public class Test01 {

	public static void main(String[] args) throws Exception {
		
		
		try {
		MusicDto musicDto=new MusicDto();
		musicDto.setMusicName("헬로");
		musicDto.setMusicArtist("헬로헬로");
		musicDto.setMusicAlbum("hello");
		
		MusicDao musicDao=new MusicDao();
		musicDao.insert(musicDto);
		
		System.out.println("등록 완료");
		}
		catch(Exception e) {
			System.err.println("등록 오류 발생");
			e.printStackTrace();
		}
		
	}
}
