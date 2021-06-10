package study.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/travel.kh")
public class TravelServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int people=Integer.parseInt(req.getParameter("people"));
		int month=Integer.parseInt(req.getParameter("month"));
		int days=Integer.parseInt(req.getParameter("days"));
		int pay=people*days*100000;
		double total_pay;
		
		if(month>=3&&month<=5) {
			total_pay=(pay*0.9);
		}
		else if(month>=6&&month<=8) {
			total_pay=(pay*0.95);
		}
		else if(month>=9&&month<=11) {
			total_pay=(pay*0.85);
		}
		else {
			total_pay=(pay*0.8);
		}
		
		resp.getWriter().println(total_pay);
			
		
}

}
