package sample09;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String eee = req.getParameter("eee");
		String []hobby = req.getParameterValues("hobby");
		String salary = req.getParameter("salary");
		String date = req.getParameter("date");
		
		
		// 데이터 모으기 
		HumanDto dto = new HumanDto(name, age,eee, hobby,date,salary);
		
		//짐싸 
		req.setAttribute("human", dto);
		
		//보내기
		
		RequestDispatcher rd = req.getRequestDispatcher("humanservlet");
		rd.forward(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
