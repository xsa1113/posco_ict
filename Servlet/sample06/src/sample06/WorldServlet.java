package sample06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectDto dto = (ObjectDto)req.getAttribute("myfruits");
		
		
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>hello servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>worldservlet</h3>");
		
		pw.println("�̸�:" + dto.getName());
		pw.println("����:" + dto.getAge());
		
		for(int i=0; i<dto.getFruits().length; i++) {
			pw.println("����:" + dto.getFruits()[i]);
		}
		
//		for(String f : dto.getFruits()) {
//			pw.println(" �����ϴ� ���� : "+ f);
//		}
		
		
		pw.println("</body>");
		pw.println("<html>");
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
