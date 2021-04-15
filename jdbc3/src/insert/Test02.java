package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("아이디를 입력하세요.");
		String user_id=sc.next();
		sc.close();
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","study","study");
		
		String sql="insert into character(character_no,character_name)"+" values (character_seq.nextval,?)";
		//System.out.println(sql);
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,user_id);
		
		ps.execute();
		
		
		con.close();
		System.out.println("아이디 생성 완료");
		
	}catch(SQLIntegrityConstraintViolationException e) {
		System.out.println("아이디가 이미 사용 중입니다.");
		
	}
	}
	

}
