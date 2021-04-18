package module;
import beans.MemberDao;
import beans.MemberDto;

public class Test07 {
	public static void main(String[] args) throws Exception {
		MemberDto memberDto=new MemberDto();
		
		memberDto.setId("khstudent");
		memberDto.setPw("khstudent");
		memberDto.setNickname("학생계정");
		memberDto.setBirth("2000-01-01");
		memberDto.setPhone("010-3333-4455");
		memberDto.setEmail("khstudent@iei.or.kr");
		
//		계산(데이터베이스 등록)
		MemberDao memberDao = new MemberDao();
		memberDao.regist(memberDto);
		
//		출력
		System.out.println("회원 등록 완료");
		
	}

}
