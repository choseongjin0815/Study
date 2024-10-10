package net.fullstack7.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class OneProcess
 */
@WebServlet("*.mem")
public class OneProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String uri = request.getRequestURI();
		String menu_kind = uri.substring(uri.lastIndexOf("/"));
		
		if(menu_kind.equals("/regist.mem")) {
			request.setAttribute("menu_kind", "<h3>회원가입</h3>");
			
		}else if(menu_kind.equals("/login.mem")) {
			request.setAttribute("menu_kind", "<h3>로그인</h3>");
		}else if(menu_kind.equals("/bbs.mem")) {
			request.setAttribute("menu_kind", "<h3>회원게시판</h3>");
		}
		
		request.setAttribute("uri", uri);
		request.setAttribute("menu_value", menu_kind);
		
		request.getRequestDispatcher("OneProcess.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
