package study.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/subway.kh")
public class SubwayServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int birth=Integer.parseInt(req.getParameter("birth"));
		int year=Calendar.getInstance().get(Calendar.YEAR);
		int age=(year-birth+1);
		int fare;
		if(age<8)
			fare=0;
		else if(age>=8 && age<14)
			fare=450;
		else if(age>=14 && age<20)
			fare=720;
		else if(age>=20 && age<64)
			fare=1250;
		else
			fare=0;
		
		resp.getWriter().println(fare);
			
		
}
}
