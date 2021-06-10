package study.servlet.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/insert.kh")
public class InsertServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String itemName=req.getParameter("itemName");
			int itemPrice=Integer.parseInt(req.getParameter("itemPrice"));
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","study","study");
		
		String sql="insert into item values(item_seq.nextval,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, itemName);
		ps.setInt(2, itemPrice);
		ps.execute();
		
		con.close();
		
		resp.setCharacterEncoding("MS949");
		resp.getWriter().println("item 등록 완료!");
		
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
			
		
}
	
}
