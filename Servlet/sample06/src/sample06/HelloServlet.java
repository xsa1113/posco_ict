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
			System.out.println("�����ϴ� ����" + x);
		}
		
		
		// ������ ������
		ObjectDto dto = new ObjectDto(name, age, fruits);
		
		// ���� 
		req.setAttribute("myfruits", dto);
		
		// �߰�!
		RequestDispatcher rd = req.getRequestDispatcher("world");
		rd.forward(req, resp);
		
		
		// sendRedirect�� ���빰�� �������� ���� -> ���� ������ �̵��Ҷ� ���� ����Ѵ�
		// ���빰�� �������� ���ؼ�
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
		pw.println("<p>�̸�:" + name + "</p>");
		pw.println("<p>����:" + age + "</p>");
		pw.println("<p>����:" + fr + "</p>");
		pw.println("</body>");
		pw.println("<html>");
		
		System.out.println("s");
		
		
		
	}
}
