package mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/hello.kh")
public class HelloServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/hello.jsp");
			dispatcher.forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
