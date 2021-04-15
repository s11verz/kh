package connect;

public class test01 {
	public static void main(String[] args) throws ClassNotFoundException {
		//JDBC: 자바에서 정보를 파일 대신 데이터베이스에 저장하기 위한 활동
		
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("드라이버 설치 성공!");
	}

}
