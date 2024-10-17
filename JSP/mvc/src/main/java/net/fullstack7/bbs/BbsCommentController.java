package net.fullstack7.bbs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/bbs/comment")
public class BbsCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BbsDAO dao = new BbsDAO();
		int result = 0;
		int idx = 0;
		String content = "";
		String id = "";
		//댓글을 작성할 대상 게시글의 인덱스
		//댓글의 내용
		//현재 로그인 되어있는 회원의 id를 불러옴
		if(request.getParameter("idx") != null
		 &&request.getParameter("content") != null
		 &&session.getAttribute("id") != null) {
			idx = Integer.parseInt(request.getParameter("idx"));
			content = request.getParameter("content");
			id = (String)session.getAttribute("id");
			if(id != null & content !=null && id != null) {
				result = dao.addComment(idx, id, content);
			}
			
		}
		//댓글을 조회하기 위한 프로세스
		BbsDTO dto = dao.view(idx, id, 1);
		request.setAttribute("comment", dto);
		
		dao.close();
		request.getRequestDispatcher("view.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
