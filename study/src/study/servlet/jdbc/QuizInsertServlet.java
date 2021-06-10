package study.servlet.jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import study.beans.HintDao;
import study.beans.HintDto;
import study.beans.QuizDao;
import study.beans.QuizDto;

@WebServlet(urlPatterns="/quiz/insert.kh")
public class QuizInsertServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			QuizDto quizDto=new QuizDto();
			quizDto.setQuizContent(req.getParameter("quiz_content"));
			
			String[] hintContents=req.getParameterValues("hint_content");
			
			QuizDao quizDao=new QuizDao();
			int quizNo=quizDao.getSequenceNumber();
			quizDto.setQuizNo(quizNo);
			quizDao.insert(quizDto);
			
			HintDao hintDao=new HintDao();
			
			for(int i=0;i<hintContents.length;i++) {
				HintDto hintDto = new HintDto();
				hintDto.setHintContent(hintContents[i]);
				hintDto.setQuizNo(quizNo);
				hintDao.insert(hintDto);
			}
			
			
			resp.setCharacterEncoding("MS949");
			resp.getWriter().println("퀴즈 등록 완료^^");
			
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

	
}
