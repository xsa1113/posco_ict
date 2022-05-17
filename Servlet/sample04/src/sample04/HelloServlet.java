package sample04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * servlet -> java(thml)
		 * jsp -> html(java)
		 * */
		
		String name = req.getParameter("name");
		System.out.println("get name : " +name);
		
		String code = req.getParameter("code");
		
		
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>hello servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>hello servlet</h3>");
		
		pw.println("<a href='sample'> sample servlet으로 이동</a>");
		
		pw.println("<p>이름:" + name + "</p>");
		
		if(code.equals("200")) {
			pw.println("<p>200:OK</p>");
		}else if(code.equals("404")) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, "찾을 수 없습니다");
		}else if(code.equals("500")){
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"구문에러입니다");
		}
		
		
		pw.println("</body>");
		pw.println("<html>");
		pw.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		System.out.println("post name : " +name);
		
	}
	
}
