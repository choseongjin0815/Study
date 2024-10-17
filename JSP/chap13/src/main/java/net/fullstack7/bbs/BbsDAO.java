package net.fullstack7.bbs;

import java.util.List;
import java.util.Map;

import net.fullstack7.common.DBConnPool;

public class BbsDAO extends DBConnPool{
	//게시글 등록 처리	
	public int regist(BbsDTO dto) {
		System.out.println("=============================");
		System.out.println("BbsDAO >> regist START");
		//1.request --> BbsDTO
		//2. 파일 존재시 validator 체크
		//3. DB등록
		//3-1. sql 문 생성
		//3-2. pstm생성
		//3-3. 등록/수정/삭제 
		//4. 파일 처리
		//5. 결과에 대한 리턴값
		//2,4는 commonutil에서 처리 했음
		int rtnResult = 0;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO tbl_bbs(memberId, title, content"
					+ ", filePath, fileName, fileExt, fileSize, fileCategory)");
			sb.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?");
			
			System.out.println("sql : " + sb.toString());
			
			pstm = con.prepareStatement(sb.toString());
			pstm.setString(1, dto.getMemberId());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
			pstm.setString(4, dto.getFilePath());
			pstm.setString(5, dto.getFileName());
			pstm.setString(6, dto.getFileExt());
			pstm.setInt(7, dto.getFileSize());
			pstm.setString(8, dto.getFileCategory());
			
			rtnResult = pstm.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시글 등록시 에러가 발생하였습니다.");
			System.out.println(e.getMessage());
		}
		System.out.println("BbsDAO >> regist END");
		System.out.println("==============================");
		return rtnResult;
	}
	//게시글 수정 처리
	public int modify(BbsDTO dto) {
		return 0;
	}
	//게시글 삭제 처리
	public int delete(BbsDTO dto) {
		return 0;
	}
	//게시글 목록
	public List<BbsDTO> list(Map<String, String> pmap){//검색 카테고리, 정렬 방법 등등....
		//1.pmap 상태에 따라서 sql 생성
		//2.preparedStatement 실행
		//3.결과 리턴
		return null;
	}				
}
