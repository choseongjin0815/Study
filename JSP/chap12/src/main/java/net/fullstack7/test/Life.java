package net.fullstack7.test;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Life
 */
@WebServlet("/Life.do")
public class Life extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void myPostConstruct() {
		System.out.println("========================================");
		System.out.println("@PostConstruct : myPostConstruct 호출");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 메서드 호출");
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		System.out.println("service() 메서드 호출");
		super.service(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet() 메서드 호출");
		request.getRequestDispatcher("./life.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("doPost() 메서드 호출");
		request.getRequestDispatcher("./life.jsp").forward(request, response);
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy() 메서드 호출");
	}
	@PreDestroy
	public void myPreDestroy() {
		System.out.println("@PreDestroy : myPreDestroy() 호출");
		System.out.println("=================================");
		
	}

}
