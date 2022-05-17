package ajax4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id= req.getParameter("id");
		String pw = req.getParameter("pw");
		
		System.out.println("id :" + id);
		System.out.println("pw :" + pw);
		
		// 전송 데이터(Database)
		JSONObject jObj = new JSONObject();
		
		// 문자열
//		String str = "안녕하세요";
//		jObj.put("str", str);
		
		
		// 다수 데이터
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("title", "여기는 제목입니다");
//		map.put("content", "이것은 내용입니다");
//		jObj.put("mydatas",map);	
		
		
		
		// list 전송
		List<HumanDto> list = new ArrayList<HumanDto>();
		list.add(new HumanDto(1001, "정수동"));
		list.add(new HumanDto(1002, "김영희"));
		list.add(new HumanDto(1003, "강수동"));
		jObj.put("list", list);
		
		
		resp.setContentType("application/x-json; charset=utf-8");
		resp.getWriter().print(jObj);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	
	
}
