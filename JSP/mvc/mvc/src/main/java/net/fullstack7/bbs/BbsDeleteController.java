package net.fullstack7.bbs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.fullstack7.utils.CommonFileUtil;

import java.io.IOException;

@WebServlet("/bbs/delete")
public class BbsDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int idx = Integer.parseInt(request.getParameter("idx"));
//		BbsDAO dao = new BbsDAO();
//		dao.delete(idx);
		//request.getRequestDispatcher("list.jsp?searchCategory=&searchWord=").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String[] arrIdx = request.getParameterValues("idx");
		
		String id = (String)session.getAttribute("id");
		Integer[] idxs = null;

		if (arrIdx != null) {
		    idxs = new Integer[arrIdx.length];
		    for (int i = 0; i < arrIdx.length; i++) {
		        idxs[i] = Integer.parseInt(arrIdx[i]);
		    }
		}
		BbsDAO dao = new BbsDAO();
		int deleteResult = dao.delete(idxs, id);
		CommonFileUtil.fileDelete(request, id, id);
		
		//dao.delete(idxs);
		
		response.sendRedirect("list.jsp");
	}
}
