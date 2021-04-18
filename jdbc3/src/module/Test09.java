package module;

import java.util.List;

import beans.MemberDao;
import beans.MemberDto;

public class Test09 {
	public static void main(String[] args) throws Exception {
		
		MemberDao memberDao=new MemberDao();
		List<MemberDto> list=memberDao.selectList();
		
		for(MemberDto memberDto : list) {
			System.out.println(memberDto.getNo());
			System.out.println("/");
			System.out.println(memberDto.getId());
			System.out.println();
		}
	}

}
