package sample09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/humanservlet")
public class HumanServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HumanDto dto = (HumanDto)req.getAttribute("human");
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>hello servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h3>worldservlet</h3>");
		
		pw.println("�̸�:" + dto.getName() + "<br>") ;
		pw.println("����:" + dto.getAge()+ "<br>");
		pw.println("����:" + dto.getEee()+ "<br>");
		
		for(int i=0; i<dto.getHobby().length; i++) {
			pw.println("���:" + dto.getHobby()[i]);
		}
		
		pw.println("<br>");

		pw.println("����:" + dto.getSalary()+ "<br>");
		pw.println("������:" + dto.getDate() + "<br>");
		
		pw.println("</body>");
		pw.println("<html>");
		pw.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
