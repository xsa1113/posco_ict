package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BbsDao;
import dto.BbsDto;

@WebServlet("/bbs")
public class BbsController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("BbsController doProcess");
		req.setCharacterEncoding("utf-8");
		
		String param = req.getParameter("param");
		if(param.equals("bbslist")) {
			String spageNumber = req.getParameter("pageNumber");
			int pageNumber = 0;
			
			if(spageNumber != null && spageNumber.equals("") == false) {
				// spagenumber 값이 있고, 빈칸이 아니라고 한다면 
				// pagenumber을 지정해준다
				pageNumber = Integer.parseInt(spageNumber);
			}
			
			String choice = req.getParameter("choice");
			String search = req.getParameter("search");
			
			if(choice == null) {
				choice = "";
			}
			if(search ==  null) {
				search = "";
			}
			
			BbsDao dao = BbsDao.getInstance();
			List<BbsDto> list = dao.getBbsPagingList(choice,search,pageNumber);
			req.setAttribute("pageNumber", pageNumber);
			req.setAttribute("choice", choice);
			req.setAttribute("search", search);
			
			// 글의 총수
			int len = dao.getAllBbs(choice, search);
			System.out.println("글의 총수:" + len);
			
			// 페이지수
			int bbsPage = len / 10;
			if(len % 10 > 0){
				bbsPage = bbsPage + 1;	
			}
			
			req.setAttribute("bbsPage", bbsPage);
			
			req.setAttribute("list", list);		// 짐싸!
//			req.getSession().setAttribute(param, list);
			
		//	RequestDispatcher dispatch = req.getRequestDispatcher("bbslist.jsp");
		//	dispatch.forward(req, resp);
			forward("bbs/bbslist.jsp", req, resp);	// 잘가!
			
		}
		
		//글쓰기
		else if(param.equals("bbswrite")) {
			resp.sendRedirect("bbs/bbswrite.jsp");
		}else if(param.equals("bbswriteAf")) {
			String id = req.getParameter("id");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			BbsDao dao = BbsDao.getInstance();

			boolean isS = dao.insertBbs(new BbsDto(id, title, content));
			String msg = "OK";
			if(isS == false){
				msg = "NG";
			}
			
			resp.sendRedirect("message.jsp?proc=write&msg=" + msg);
		}
		//글 세부 목록 확인하기 
		else if(param.equals("bbsdetail")) {
			BbsDao dao = BbsDao.getInstance();
			int seq = Integer.parseInt(req.getParameter("seq"));
			dao.count(seq);
			BbsDto dto = dao.selectWriter(seq);
			req.setAttribute("dto", dto);
			forward("bbs/bbsdetail.jsp", req, resp);
		}
		//글 수정 
		else if(param.equals("update")) {
			int seq = Integer.parseInt(req.getParameter("seq"));
			
			resp.sendRedirect("bbs/update.jsp?seq=" + seq);
		}else if(param.equals("updateAf")) {
			
			int seq = Integer.parseInt(req.getParameter("seq"));
			 String id = req.getParameter("id");
		     String title = req.getParameter("title");
		     String content = req.getParameter("content");
		     
		     BbsDao dao = BbsDao.getInstance();
	         
	         boolean isS = dao.writeUpdate(seq, title, content);
	         String msg = "OK";
	         if (isS == false) {
	             msg = "NG";
	          }
	          resp.sendRedirect("message.jsp?proc=writeUpdate&msg=" + msg);
		}else if(param.equals("delete")) {
			int seq = Integer.parseInt(req.getParameter("seq"));
			BbsDao dao  = BbsDao.getInstance();
			boolean isS = dao.writeDelete(seq);
			String msg = "OK";
			if(isS == false) {
				msg = "NG";
				
			}
			resp.sendRedirect("message.jsp?proc=writeDelete&msg=" + msg);
		}
		
	}
	
	public void forward(String arg, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(arg);
		dispatch.forward(req, resp);
	}
	
}




