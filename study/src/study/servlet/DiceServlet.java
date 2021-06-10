package study.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/dice.kh")
public class DiceServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Random random=new Random();
		int dice=random.nextInt(6)+1;
		resp.setCharacterEncoding("EUC-KR");
		resp.getWriter().println("주사위="+dice);
	}

	
	
}
