package net.fullstack7.bbs;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashPrintRequestAttributeSet;

/**
 * Servlet implementation class BbsListController
 */
//@WebServlet({"aa","sadasd"})
@WebServlet("/bbs/list")
public class BbsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------------doGet List11223");
		BbsDAO dao = new BbsDAO();
		int totalbbs = dao.totalBbsCount();
		int currentPage = 1;
		int pageSize = 5;
		int totalPages = 0;
		int startPage = 1;
		Map<String, Object> pMap = new HashMap<String, Object>();
		String searchCategory = request.getParameter("searchCategory");
		String searchWord = request.getParameter("searchWord");
		if(request.getParameter("page") != null) {
			System.out.println("pagenotnull");
			currentPage = Integer.parseInt(request.getParameter("page"));
			startPage = ((currentPage - 1)/ pageSize) * pageSize + 1;

		}else {
			System.out.println("null");
		}
		
		pMap.put("searchCategory", searchCategory);
		pMap.put("searchWord", searchWord);
		pMap.put("currentPage", currentPage);
		pMap.put("pageSize", pageSize);
		//request.setAttribute("searchCategory", searchCategory);
		List<BbsDTO> bbsList = dao.list(pMap); 
		int totalBbsCnt = dao.searchedBbsCount(pMap);
		totalPages = (totalBbsCnt + pageSize - 1) / pageSize;
		System.out.println(totalPages);
		request.setAttribute("bbsList", bbsList);
		
		
		request.setAttribute("searchCategory", searchCategory);
		request.setAttribute("searchWord", searchWord);
		request.setAttribute("startPage", startPage);
		request.setAttribute("lastPage", Math.min(startPage + (pageSize - 1), totalPages));
		request.setAttribute("totalPages", totalPages);
		
		request.getSession().setAttribute("test", "test");
		
		dao.close();
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
