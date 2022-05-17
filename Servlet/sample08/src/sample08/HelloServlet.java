package sample08;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =req.getSession(false);
		
		/*
		 * getSession(false)
		 * session 객체가 존재하면, HttpSession을 반환한다
		 * 존재하지 않으면 그냥 null을 반환한다.
		 * 
		 * getSession(true) <- default getsession()
		 * session 객체가 존재하면, httpsession을 반환한다
		 * 존재하지 않으면 새로 session을 생성한다
		 * 
		 * */
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>hello servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		if(session == null) {
			// 세션이 존재하지않으면 세션을 생성한다
			session = req.getSession(true); // 새로 session을 생성
			session.setMaxInactiveInterval(60 ); // 세션 시간 설정
			session.setAttribute("visited", "1");
			
			pw.println("<p> 세션이 존재하지 않습니다. 새로 세션을 생성합니다</p>");
			
		}else {
			// 세션이 있으면 생성 x
			String visited = (String)session.getAttribute("visited");
			int count = Integer.parseInt(visited);
			
			count++;
			pw.println("<p> 방문회수는 " +  count +  "</p>");

			session.setAttribute("visited", count + "");
		}
		
		pw.println("<a href='deleteServlet'>세션삭제</a>");
		
		pw.println("</body>");
		pw.println("<html>");
		pw.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
