package mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.MemberDao;
import mvc.beans.MemberDto;

public class MemberListController implements Controller{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MemberDao memberDao = new MemberDao();
		List<MemberDto> list = memberDao.selectList();
		
		req.setAttribute("list", list);
		
		return "/WEB-INF/jsp/member/memberList.jsp";
	}
	
}