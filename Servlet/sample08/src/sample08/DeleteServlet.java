package sample08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>Hello Servlet</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		HttpSession session = req.getSession();
		
		session.invalidate();  // session �궘�젣
		
		if(req.getSession(false) == null) {
			pw.println("<p>세션이 삭제 되었습니다</p>");
		}
		
		pw.println("</body>");
		
		pw.println("</html>");
		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
