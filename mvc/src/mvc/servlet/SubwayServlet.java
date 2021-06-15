package mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/subway.kh")
public class SubwayServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		int birth=Integer.parseInt(req.getParameter("birth"));
		int age=2021-birth+1;
		int price=0;
		if(age>=8&&age<14) {
			price=450;
		}else if(age>=14&&age<20) {
			price=720;
		}else if(age>=20&&age<65) {
			price=1250;
		}else {
			price=0;
		}
		req.setAttribute("age", age);
		req.setAttribute("price", price);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("WEB-INF/jsp/subway.jsp");
		dispatcher.forward(req, resp);
	}catch(Exception e){
		e.printStackTrace();
		resp.sendError(500);
	}
}
}
