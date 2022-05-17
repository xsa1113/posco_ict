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
		 * session ��ü�� �����ϸ�, HttpSession�� ��ȯ�Ѵ�
		 * �������� ������ �׳� null�� ��ȯ�Ѵ�.
		 * 
		 * getSession(true) <- default getsession()
		 * session ��ü�� �����ϸ�, httpsession�� ��ȯ�Ѵ�
		 * �������� ������ ���� session�� �����Ѵ�
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
			// ������ �������������� ������ �����Ѵ�
			session = req.getSession(true); // ���� session�� ����
			session.setMaxInactiveInterval(60 ); // ���� �ð� ����
			session.setAttribute("visited", "1");
			
			pw.println("<p> ������ �������� �ʽ��ϴ�. ���� ������ �����մϴ�</p>");
			
		}else {
			// ������ ������ ���� x
			String visited = (String)session.getAttribute("visited");
			int count = Integer.parseInt(visited);
			
			count++;
			pw.println("<p> �湮ȸ���� " +  count +  "</p>");

			session.setAttribute("visited", count + "");
		}
		
		pw.println("<a href='deleteServlet'>���ǻ���</a>");
		
		pw.println("</body>");
		pw.println("<html>");
		pw.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
