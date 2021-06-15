package mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.MemberDao;
import mvc.beans.MemberDto;

public class MemberJoinController implements Controller{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equals("GET")) {
			return "/WEB-INF/jsp/member/memberJoin.jsp";
		}
		else if(req.getMethod().equals("POST")) {
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId(req.getParameter("memberId"));
			memberDto.setMemberPw(req.getParameter("memberPw"));
			memberDto.setMemberNick(req.getParameter("memberNick"));
			memberDto.setMemberBirth(req.getParameter("memberBirth"));
			memberDto.setMemberPhone(req.getParameter("memberPhone"));
			memberDto.setMemberEmail(req.getParameter("memberEmail"));
			
			MemberDao memberDao = new MemberDao();
			memberDao.regist(memberDto);
			
			return "redirect:memberList.it";
		}
		return null;
	}

}