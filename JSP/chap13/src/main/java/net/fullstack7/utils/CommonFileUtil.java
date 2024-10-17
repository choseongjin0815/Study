package net.fullstack7.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class CommonFileUtil {
	public CommonFileUtil() {}
	//파일 업로드
	public static String UploadFile(HttpServletRequest req, String saveDir, String inFileTagName)
				throws ServletException, IOException {
		System.out.println("=======================================================");
		System.out.println("CommonFileUtil >> UploadFile Start");
		//part 객체를 사용
		Part part = req.getPart("file");
		//헤더값에서 파일 객체 부분 읽어 오기
		String partHeader = part.getHeader("content-disposition");
		//파일객체부분:form-data;name="attachFile"; filename="파일명"
		System.out.println("partHeader : " +partHeader);
		
		String[] arrPartHeader = partHeader.split("filename=");
		String orgFileName = arrPartHeader[1].trim().replace("\"","");
		
		if(!orgFileName.isEmpty()) {
			System.out.println("orgFileName : " + orgFileName);
			
			//파일을 업로드하는 경로
			//D:\java7\JSP\chap13\src\main\webapp\Uploads
			part.write(saveDir + File.separator + orgFileName);
		}
		
		
		System.out.println("CommonFileUtil >> UploadFile End");
		System.out.println("=======================================================");
		
		return orgFileName;
	}
	
	public static List<String> multiUploadFile(HttpServletRequest req, String saveDir, String inFileTagName)
			throws ServletException, IOException {
		List<String> fileNameList = new ArrayList<String>();
	
		Collection<Part> parts = req.getParts();
		
		for(Part part : parts) {
			if(!part.getName().equals(inFileTagName)) continue;
			//헤더값에서 파일 객체 부분 읽어 오기
			String partHeader = part.getHeader("content-disposition");
			//파일객체부분:form-data;name="attachFile"; filename="파일명"
			System.out.println("parts >> part >>Header : " +partHeader);
			
			String[] arrPartHeader = partHeader.split("filename=");
			String orgFileName = arrPartHeader[1].trim().replace("\"","");
			
			if(!orgFileName.isEmpty()) {
				System.out.println("orgFileName : " + orgFileName);
				
				//파일을 업로드하는 경로
				//D:\java7\JSP\chap13\src\main\webapp\Uploads
				part.write(saveDir + File.separator + orgFileName);
				fileNameList.add(orgFileName);
			}
			
		}
	
	
	System.out.println("CommonFileUtil >> multiUploadFile End");
	System.out.println("=======================================================");
	
	return fileNameList;
}
	
	//업로드된 파일명 변경
	public static Map<String,String> fileRename(String saveDir, String fileName) {
			//파일 확장자 추출
		String fileExt = fileName.substring(fileName.lastIndexOf(".")); //마지막 . ~ 끝
		//임시 파일명 생성
		String tmpName = new SimpleDateFormat("yyyymmdd_HHmmssS").format(new Date());
		
		//새로운 파일명 조합
		String newFileName = tmpName + fileExt;
		//기존 파일명 - > 새로운 파일명으로 변경
		File oldFile = new File(saveDir + File.separator + fileName);
		File newFile = new File(saveDir + File.separator + newFileName);
		oldFile.renameTo(newFile);
		
		 Map<String, String> fmap = new HashMap<String, String>();
		 fmap.put("filePath", saveDir);
		 fmap.put("orgFileName", fileName);
		 fmap.put("newFileName", newFileName);
		 fmap.put("orgFileName", fileName);
		 fmap.put("fileExt", fileExt);
		 fmap.put("fileSize", String.valueOf(oldFile.length()));
		 

		return fmap;
	}
	
	public static void DownloadFile(HttpServletRequest req,
			HttpServletResponse res,
			String dir, String orgFileName, String outFileName) { 
		
			//dir  D:\java7\JSP\chap13\src\main\webapp\Uploads
			//dir  Uploads
			String realPath = req.getServletContext().getRealPath(dir);
			try {
				File file = new File(realPath, orgFileName);
				InputStream inputStream = new FileInputStream(file);
				
				//클라이언트의 브라우저 체크
				String userAgent = req.getHeader("User-Agent");
				if(userAgent.indexOf("WOW64") == -1) {
					outFileName = new String(outFileName.getBytes("UTF-8"), "ISO-8859-1");
				}else {
					outFileName = new String(outFileName.getBytes("KSC5601"), "ISO-8859-1"); 
				}
				//다운로드할 파일의 응답 헤더 설정
				res.reset();
				res.setContentType("application/octet-stream");
				res.setHeader("Content-Disposition", "attach; filename=\"" + outFileName + "\"");
				res.setHeader("Content-Length", "" + file.length());
				//out.clear();
				
				//respose 내장 객체를 이용하여 출력 스트림 생성
				OutputStream outStream = res.getOutputStream();
				// 출력 스트림에 fail 내용을 출력시킴
				byte b[] = new byte[(int)file.length()];
				int readBuffer = 0;
				while((readBuffer = inputStream.read(b)) > 0) {
					outStream.write(b, 0, readBuffer);
					
				}
				//입출력 스트림 닫음
				inputStream.close();
				outStream.close();
				
				
			}catch(FileNotFoundException e) {
				System.out.println("파일을 찾을 수 없습니다 : " + e.getMessage());
				e.printStackTrace(); //실제 배포할때는 ㄴ
			}catch(Exception e) {
				System.out.println("예외가 발생하였습니다. : " + e.getMessage());
				e.printStackTrace(); //실제 배포할때는 ㄴ
			}
		 
			
				
		}
			//파일 삭제
		public static void fileDelete(HttpServletRequest req, String dir, String fileName) {
			System.out.println("=======================================================");
			System.out.println("CommonFileUtil >> fileDelete Start");
			
			//파일이 존재할 경우 삭제
			try {
				File file = new File(dir + File.separator + fileName);
				if(file.exists()) {
					file.delete();
					System.out.println(dir + File.separator + fileName);
				}
			}catch(Exception e){
				System.out.println("파일 삭제시 에러가 발생하였습니다. : " + e.getMessage());
				e.printStackTrace();
			}
			System.out.println("CommonFileUtil >> fileDelete End");
			System.out.println("=======================================================");
				
		}
}
