package net.fullstack7.bbs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bbs/view")
public class BbsViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int resultReadCnt = 0;
		BbsDAO dao = new BbsDAO();
		//조회할 경우 조회수 증가
		resultReadCnt = dao.addReadCnt(idx);
		//조회수 증가가 성공할 경우 view해주는 로직 실행
		if(resultReadCnt > 0) {
			BbsDTO dto = dao.view(idx);
			request.setAttribute("bbs", dto);
			System.out.println("==============");
			System.out.println(idx);
			System.out.println("==============");
		}
		dao.close();
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
