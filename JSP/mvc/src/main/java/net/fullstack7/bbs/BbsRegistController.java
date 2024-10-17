package net.fullstack7.bbs;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.fullstack7.utils.CommonFileUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;
//@MultipartConfig(
//		maxfilesize=20......
//		)
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 1, // 1MB: 메모리 내 저장 크기 임계값
	    maxFileSize = 1024 * 1024 * 10,      // 10MB: 업로드되는 파일의 최대 크기
	    maxRequestSize = 1024 * 1024 * 50    // 50MB: 요청의 최대 크기
	)
@WebServlet("/bbs/regist")
public class BbsRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("bbs/regist.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    BbsDTO dto = new BbsDTO();
	    dto.setMemberId(request.getParameter("memberid"));
	    dto.setTitle(request.getParameter("title"));
	    dto.setContent(request.getParameter("content"));
	    dto.setDisplayDate(request.getParameter("displaydate"));
	    dto.setFileCategory("fileCategory");

	    String saveDir = "D:\\java7\\JSP\\mvc\\src\\main\\webapp\\upload";
	    
	    List<Map<String, String>> uploadedFiles = CommonFileUtil.multiUploadAndRenameFiles(request, saveDir, "file2");
	    
	    String filePaths = "";
	    String newFileNames = "";
	    String fileExts = "";
	    int fileSize = 0;
	    
	    if (uploadedFiles != null && !uploadedFiles.isEmpty()) {
	        for (Map<String, String> fileInfo : uploadedFiles) {
	        	filePaths += fileInfo.get("filePath")+ " ";
	        	newFileNames += fileInfo.get("newFileName")+ " ";
	        	fileExts += fileInfo.get("fileExt") + " ";
	        	fileSize += Integer.parseInt(fileInfo.get("fileSize"));
	        	
	        }
	        dto.setFilePath(filePaths);
			dto.setFileName(newFileNames);
			dto.setFileExt(fileExts);
			dto.setFileSize(fileSize);
            // 여기서 각각의 파일 정보를 DTO에 맞게 처리 (필요시 추가 로직 구현)
            System.out.println("File Path: " + filePaths);
            System.out.println("New File Name: " + newFileNames);
	    }

	    BbsDAO dao = new BbsDAO();
	    int rtnResult = dao.regist(dto);
	    dao.close();
	    
	    if (rtnResult > 0) {
	        // response.sendRedirect("/list.do");
	    } else {
	        for (Map<String, String> fileInfo : uploadedFiles) {
	            CommonFileUtil.fileDelete(request, saveDir, fileInfo.get("newFileName"));
	        }
	        request.setAttribute("errMsg", "게시글 등록시 에러가 발생하였습니다.");
	        request.getRequestDispatcher("./bbs/regist.jsp").forward(request, response);
	    }
	}

/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//response.sendRedirect("/bbs/regist.jsp");
		
		//1.폼 데이터를 전송 받아서 변수에 할당
		//2.파일업로드 처리 --> 실패시에 롤백
		//3. DAO를 통해 DB프로세스 진행 --> INSERT
		//4. INSERT 상태에 따라서 
		//	 성공 --> sendRedirect(); --> list
		//	 실패 --> regist.jsp
		//1. 폼 데이터를 전송 받아서 변수에 할당
		BbsDTO dto = new BbsDTO();
		dto.setMemberId(request.getParameter("memberid"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setDisplayDate(request.getParameter("displaydate"));
		dto.setFileCategory("fileCategory");
		//2.파일 업로드 처리 --> 실패시에 롤백
		String saveDir = "D:\\java7\\JSP\\mvc\\src\\main\\webapp\\upload";
		System.out.println("saveDir : " + saveDir);
		
		String orgFileName = CommonFileUtil.UploadFile(request, saveDir, "file1");
		//String newFileName = CommonFileUtil.fileRename(request, orgFileName, "file1");
		Map<String, String> fmap = CommonFileUtil.fileRename(saveDir, orgFileName);
		if(fmap!=null) {
			dto.setFilePath(fmap.get("filePath"));
			dto.setFileName(fmap.get("newFileName"));
			dto.setFileExt(fmap.get("fileExt"));
			dto.setFileSize(Integer.parseInt(fmap.get("fileSize")));
		}
		System.out.println("orgFileName : " + orgFileName);
		System.out.println("newFileName : " + fmap.get("newFileName"));
		
		BbsDAO dao = new BbsDAO();
		int rtnResult = dao.regist(dto);
		dao.close();
		
		if(rtnResult > 0) {
			//response.sendRedirect("/list.do");
		}
		else {
			CommonFileUtil.fileDelete(request, saveDir, orgFileName);
			CommonFileUtil.fileDelete(request, saveDir, fmap.get("newFileName"));
			
			request.setAttribute("errMsg", "게시글 등록시 에러가 발생하였스비낟.");
			request.getRequestDispatcher("./bbs/regist.jsp").forward(request, response);
		}
	}
*/
}
