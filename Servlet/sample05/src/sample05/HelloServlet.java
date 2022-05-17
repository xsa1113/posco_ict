package sample05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	@Override			// 내장 객체 : 생성안하고 바로 사용가능
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String url = req.getParameter("url");
		System.out.println("url :" + url);
		
		// java 
		// sendRedirect
//		if(url.equals("naver.com")) {
//			resp.sendRedirect("http://www.naver.com");
//		}else if(url.equals("google.com")) {
//			resp.sendRedirect("http://www.google.com");
//		}else if(url.equals("zum.com")) {
//			resp.sendRedirect("http://www.zum.com");
//		}
		
		
		// setHeader
		resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		
		
		if(url.equals("naver.com")) {
			resp.setHeader("Location", "http://www.naver.com");
		}else if(url.equals("google.com")) {
			resp.setHeader("Location", "http://www.google.com");
		}else if(url.equals("zum.com")) {
			resp.setHeader("Location", "http://www.zum.com");
		}
	}
	
}
