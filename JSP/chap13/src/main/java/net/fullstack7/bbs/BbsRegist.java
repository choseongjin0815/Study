package net.fullstack7.bbs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.fullstack7.utils.CommonFileUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;



public class BbsRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		System.out.println("BbsRegistOk >> doPost START");
		//파일 업로드 경로 지정
		//String saveDir1 = getServletContext().getRealPath("/Uploads"); 이건 서버에 배포할 때
		String saveDir = "D:\\java7\\JSP\\chap13\\src\\main\\webapp\\Uploads";
		System.out.println("saveDir : " + saveDir);
		//요청받은 파라미터 처리
		String memberId = request.getParameter("memberId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String fileCategory = request.getParameter("fileCategory");
		//String fileCategory = request.getParameter("fileCategory"); 체크밗
		
		//파일 업로드
//		String orgFileName = CommonFileUtil.UploadFile(request, saveDir, "file");
		List<String> orgFileName = CommonFileUtil.multiUploadFile(request, saveDir, "file2");
		Map<String, String> fmap = CommonFileUtil.fileRename(saveDir, orgFileName);
	
		
		//DTO설정
		BbsDTO dto = new BbsDTO();
		dto.setMemberId(memberId);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setFileCategory(fileCategory);
		dto.setFilePath(fmap.get("filePath"));
		dto.setFileName(fmap.get(dto));
		dto.setFileSize(Integer.parseInt(fmap.get("fileSize")));
		
		BbsDAO dao = new BbsDAO();
		int result = dao.regist(dto);
		dao.close();
		if(result > 0) {
			response.sendRedirect("./list.jsp");
		}
		else if(result < 0) {
			CommonFileUtil.fileDelete(request, saveDir, orgFileName);
			CommonFileUtil.fileDelete(request, saveDir, fmap.get("newFileName"));
			request.setAttribute("errMsg", "게시글 등록시 오류가 발생하였습니다.");
			request.getRequestDispatcher("./regist.jsp").forward(request, response);
		}
		
		System.out.println("BbsRegistOk >> doPost END");
	}

}
