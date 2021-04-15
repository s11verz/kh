package module;



import beans.MemberDao;

public class Test01 {
	public static void main(String[] args) throws Exception {
		
		String memberId="test12345";
		String memberPw="test12345";
		
		MemberDao memberDao=new MemberDao();
		int count=memberDao.exit(memberId,memberPw);
		
		if(count>0) {
			System.out.println("회원탈퇴가 완료되었습니다.");
		}else {
			System.out.println("정보가 일치하지 않습니다.");
		}
	}

}
