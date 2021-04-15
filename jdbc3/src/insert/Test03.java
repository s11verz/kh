package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Test03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("아이디:"); String memberId=sc.nextLine();
		if(!Pattern.matches("^\\w{8,20}$",memberId)) {
			System.out.println("아이디는 영문 소문자, 대문자, 숫자로 구성된 8~20자로 작성하세요.");
			System.exit(-1);
		}
		System.out.println("비밀번호:"); String memberPassword=sc.nextLine();
		System.out.println("닉네임:"); String memberNickname=sc.nextLine();
		System.out.println("생년월일:"); String memberBirth=sc.nextLine();
		System.out.println("전화번호:"); String memberPhone=sc.nextLine();
		System.out.println("이메일:"); String memberEmail=sc.nextLine();
	
		
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","study","study");
		
		String sql="insert into member "
				+"values(member_seq.nextval,?,?,?,?,?,sysdate,?,0,'일반')";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, memberId);
		ps.setString(2, memberPassword);
		ps.setString(3, memberNickname);
		ps.setString(4, memberBirth);
		ps.setString(5, memberPhone);
		ps.setString(6, memberEmail);
		
		ps.execute();
		con.close();
		System.out.println("회원가입 완료");
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("이미 사용중인 아이디입니다.");
			System.out.println("이미 사용중인 닉네임입니다.");
		}
		
	
	}

}
