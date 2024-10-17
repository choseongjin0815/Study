package net.fullstack7.bbs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/bbs/loginProc")
public class BbsLoginProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	//post로 받으면 로그인
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> loginMap = new HashMap<String, Object>();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		loginMap.put("memberId", id);
		loginMap.put("pwd", pwd);
		
		BbsDAO dao = new BbsDAO();
		int loginResult = dao.Login(loginMap);
		
		PrintWriter out = response.getWriter(); 
		response.setContentType("text/html;charset=UTF-8");
		
		if(id != null && pwd != null && loginResult > 0 && loginResult == 1) {
			HttpSession session = request.getSession();
			
			session.setAttribute("id", id);
			  
		    out.println("<script>");
		    out.println("alert('로그인완료!');"); 
		    out.println("window.location.href = 'list.jsp';");
		    out.println("</script>");
		    out.close();
		}else {
			out.println("<script>");
			out.println("alert('로그인실패!');"); 
			out.println("window.location.href = 'login.jsp';");
			out.println("</script>");
			out.close();
		}

	}
	//get으로 받으면 로그아웃
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

}
