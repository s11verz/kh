package mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.Controller;
import mvc.controller.ControllerFactory;
import mvc.controller.MemberJoinController;
import mvc.controller.MemberListController;
import mvc.controller.ProductDetailController;
import mvc.controller.ProductInsertController;
import mvc.controller.ProductListController;

//All-in-one servlet
//= 사용자가 보낸 모든 요청 중에서 .it로 끝나는 요청을 다 처리할 수 있는 서블릿
@WebServlet(urlPatterns = "*.it")
public class MainServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//System.out.println("MainServlet 실행");
			
			String destination = req.getRequestURI();
			//System.out.println("destination = " + destination);
			
			String context = req.getContextPath();
			
			String path = destination.substring(context.length());//목적지 주소에서 context path를 제거
			System.out.println("path = " + path);
			
			String method = req.getMethod();//사용자 요청 방식(GET/POST/등)
			System.out.println("method = " + method);
			
			req.setCharacterEncoding("UTF-8");
			
			Controller controller = ControllerFactory.create(path);
			
			String nextPage = null;
			if(controller != null) {
				nextPage = controller.process(req, resp);
			}

			//모든 작업이 끝난 뒤에 어떤 방식으로 요청을 처리할 지 결정하여 실행
			//[1] 다른 주소로 리다이렉트(redirect) - 주소가 "redirect:" 으로 시작하면 리다이렉트 판정
			//[2] 특정 JSP로 포워드(forward) - 주소가 "redirect:" 로 시작하지 않는다면 포워드 판정
			//[3] 404 not found - 나머지
			if(nextPage == null) {//처리 불가능한 경우
				resp.sendError(404);
			}
			else if(nextPage.startsWith("redirect:")) {//리다이렉트를 해야하는 상황이라면
				nextPage = nextPage.substring("redirect:".length());//주소에서 redirect:을 제거하고
				resp.sendRedirect(nextPage);
			}
			else {//포워드 해야 하는 상황이라면
				RequestDispatcher dispatcher = req.getRequestDispatcher(nextPage);//nextPage의 값으로 forward
				dispatcher.forward(req, resp);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}

