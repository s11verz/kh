package quiz.program;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import quiz.beans.MusicDao;
import quiz.beans.MusicDto;

public class Test05 {
	public static void main(String[] args) throws Exception {
		
		MusicDao musicDao=new MusicDao();
		List<MusicDto> musicList=musicDao.list();
		
		for(MusicDto musicDto:musicList) {
			System.out.println(musicDto);
		}
	}

}
