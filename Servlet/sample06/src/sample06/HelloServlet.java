package sample06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String fruits[] = req.getParameterValues("fruit");
		
		
		System.out.println(name);
		System.out.println(age);
		
		for(String x : fruits) {
			System.out.println("좋아하는 과일" + x);
		}
		
		
		// 데이터 모으기
		ObjectDto dto = new ObjectDto(name, age, fruits);
		
		// 짐싸 
		req.setAttribute("myfruits", dto);
		
		// 잘가!
		RequestDispatcher rd = req.getRequestDispatcher("world");
		rd.forward(req, resp);
		
		
		// sendRedirect는 내용물을 가져가지 않음 -> 단지 페이지 이동할때 많이 사용한다
		// 내용물을 가져가기 위해서
		// resp.sendRedirect("world?name=" + name);
		// resp.sendRedirect("world");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("dopost");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.println(name);
		System.out.println(age);
		
		String fr = req.getParameter("fruit");
		System.out.println(fr);
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>hello servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<p>이름:" + name + "</p>");
		pw.println("<p>나이:" + age + "</p>");
		pw.println("<p>과일:" + fr + "</p>");
		pw.println("</body>");
		pw.println("<html>");
		
		System.out.println("s");
		
		
		
	}
}
