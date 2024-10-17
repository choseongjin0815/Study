package net.fullstack7.bbs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.fullstack7.utils.CommonFileUtil;

import java.io.IOException;
import java.util.Map;


@WebServlet("/bbs/modify")
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 1,
		maxRequestSize = 1024 * 102
)

public class BbsModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String memberId = request.getParameter("memberId");
//		int idx = Integer.parseInt(request.getParameter("idx"));
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String fileCategory = request.getParameter("fileCategory");
//		
//		String saveDir = "D:\\java7\\JSP\\mvc\\src\\main\\webapp\\upload";
//		
//
//		String orgFileName = CommonFileUtil.UploadFile(request, saveDir, "newFile");
//		Map<String, String> fmap = CommonFileUtil.fileRename(saveDir, orgFileName);
//
//		
//		BbsDTO dto = new BbsDTO();
//		dto.setMemberId(memberId);
//		dto.setIdx(idx);
//		dto.setTitle(title);
//		dto.setContent(content);
//		dto.setFileCategory(fileCategory);
//		if(fmap!=null) {
//			dto.setFilePath(fmap.get("filePath"));
//			dto.setFileName(fmap.get("newFileName"));
//			dto.setFileExt(fmap.get("fileExt"));
//			dto.setFileSize(Integer.parseInt(fmap.get("fileSize")));
//		}
//		
//		
//		BbsDAO dao = new BbsDAO();
//		dao.modify(dto);
//		
//		dao.close();
//		
//		request.getRequestDispatcher("list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String fileCategory = request.getParameter("fileCategory");
		
		String saveDir = "D:\\java7\\JSP\\mvc\\src\\main\\webapp\\upload";
		

		String orgFileName = CommonFileUtil.UploadFile(request, saveDir, "newFile");
		Map<String, String> fmap = CommonFileUtil.fileRename(saveDir, orgFileName);

		
		BbsDTO dto = new BbsDTO();
		dto.setMemberId(memberId);
		dto.setIdx(idx);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setFileCategory(fileCategory);
		if(fmap!=null) {
			dto.setFilePath(fmap.get("filePath"));
			dto.setFileName(fmap.get("newFileName"));
			dto.setFileExt(fmap.get("fileExt"));
			dto.setFileSize(Integer.parseInt(fmap.get("fileSize")));
		}
		
		
		BbsDAO dao = new BbsDAO();
		dao.modify(dto);
		
		dao.close();
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

}
