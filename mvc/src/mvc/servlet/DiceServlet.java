package mvc.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/dice.kh")
public class DiceServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		Random r=new Random();
		int dice=r.nextInt(6)+1;
		
		req.setAttribute("dice", dice);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/dice.jsp");
		dispatcher.forward(req, resp);
	}catch(Exception e) {
		e.printStackTrace();
		resp.sendError(500);
	}
}
	
}
