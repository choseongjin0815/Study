package net.fullstack7.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bbs/memberRegist")
public class MemberRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name =  request.getParameter("name");
		
		if(id != null && pwd != null && name != null) {
			dto.setMemberId(id);
			dto.setPwd(pwd);
			dto.setName(name);
		}
		MemberDAO dao = new MemberDAO();
		
		int registResult = dao.memberRegist(dto);
		
		if(registResult > 0 && registResult == 1) {
			response.sendRedirect("login.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
