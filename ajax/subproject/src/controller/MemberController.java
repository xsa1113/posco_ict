package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dto.MemberDto;
import net.sf.json.JSONObject;

@WebServlet("/member")
public class MemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
		
		
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("MemberController doProcess");
		req.setCharacterEncoding("utf-8");
		String param = req.getParameter("param");
		
		if(param.equals("login")) {
			MemberDto dto =(MemberDto)req.getSession().getAttribute("login");
			if(dto != null) {
				req.getSession().invalidate();
				System.out.println("세션 삭제 성공 로그아웃 성공");
			}else {
				System.out.println("세션 비었슴");
			}
			resp.sendRedirect("member/subject.jsp");
			
			
		}else if(param.equals("regi")){
			resp.sendRedirect("member/create.jsp");
		}
		//회원 탈퇴
		else if(param.equals("delete")) {
			System.out.println("회원탈퇴진행 1");
			String id = req.getParameter("id");
			MemberDao dao = MemberDao.getInstance();
			boolean isS = dao.delete(id);
			
			String msg = "OK";
			if(isS==false) {
				msg="NG";
			}
			resp.sendRedirect("message.jsp?proc=delete&msg=" + msg +"&id=" + id);
		}
		//회원등록
		else if(param.equals("createAf")) {
			System.out.println("createAf");
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			int age =  Integer.parseInt(req.getParameter("age"));
			String birth = req.getParameter("birth");
			String email = req.getParameter("sample4_roadAddress");
			System.out.println(email);
			int tall = Integer.parseInt(req.getParameter("tall"));
			
			MemberDao dao = MemberDao.getInstance();
			MemberDto dto = new MemberDto(id, pwd, name, email, tall,birth,age);
			boolean isS = dao.addMemeber(dto);
			
			String msg = "OK";
			if(isS==false) {
				msg="NG";
			}
			resp.sendRedirect("message.jsp?proc=regi&msg=" + msg +"&id=" + id);
		}
		
		// 로그인 
		else if(param.equals("loginAf")) {
			String id = req.getParameter("id");
			
			String pwd = req.getParameter("pwd");
			
			MemberDao dao = MemberDao.getInstance();
			MemberDto dto = dao.login(new MemberDto(id,pwd));
			
			String msg = "";
			if(dto!=null) {
				req.getSession().setAttribute("login", dto);
				msg = "OK";
			}else {
				msg = "NG";
			}
			
			resp.sendRedirect("message.jsp?proc=login&msg=" + msg);;
		}
		
		else if(param.equals("bbslist")) {
			resp.sendRedirect("member/bblist.jsp");
		}
		else if(param.equals("mypage")) {
			String id =  ((MemberDto)req.getSession().getAttribute("login")).getId();
//			req.setAttribute(param, id);
			resp.sendRedirect("member/mypage.jsp?id=" + id);
		}
		//아이디 체크
		else if(param.equals("checkId")) {
			String id = req.getParameter("id");
			//DB 접속 Data를 산출
			MemberDao dao = MemberDao.getInstance();
			boolean b = dao.getId(id);
			
			String str = "NO";
			if(b == false) {
				str = "OK";
			}
			
			JSONObject obj = new JSONObject();
			obj.put("str", str);
			
			resp.setContentType("application/x-json; charset=utf-8");
			resp.getWriter().print(obj);
			
		}
		
	}
		
}
