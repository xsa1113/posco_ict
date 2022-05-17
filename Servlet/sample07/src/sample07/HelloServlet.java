package sample07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello") // annotation(==주석문)
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HEllo servlet do get");
		
		Cookie cookie = new Cookie("id","abc123");
		resp.addCookie(cookie);
		
		cookie = new Cookie("password", "1004");
		resp.addCookie(cookie);
		
		cookie = new Cookie("visited", "1");
		resp.addCookie(cookie);
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>hello servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		pw.println("<a href ='displayCookie'>Cookie를 표시</a>");
		
		pw.println("</body>");
		pw.println("<html>");
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
