package net.fullstack7.bbs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.fullstack7.utils.CommonFileUtil;

import java.io.IOException;


@WebServlet("/bbs/download")
public class BbsDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveDir = "D:\\java7\\JSP\\mvc\\src\\main\\webapp\\upload";
		String fileName = request.getParameter("fileName");
		System.out.println("saveDir : " + saveDir);
		CommonFileUtil.DownloadFile(request, response, "/upload", fileName, fileName);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
