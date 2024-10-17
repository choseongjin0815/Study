package net.fullstack7.bbs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.fullstack7.common.DBConnPool;

public class BbsDAO extends DBConnPool{
	public BbsDAO() {}
	//게시글 등록
	public int regist(BbsDTO dto) {
		System.out.println("============================");
		int registSuccess = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO tbl_bbs (");
		sb.append("`memberId`, `title`, `content`, `displayDate`,");
		sb.append("`filePath`, `fileName`, `fileExt`, `fileSize`, `fileCategory`)");
		sb.append("VALUES(?, ?, ?, ?,");
		sb.append("?, ?, ?, ?, ?)");
		
		try {
			String sql = sb.toString();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMemberId());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			pstm.setString(4, dto.getDisplayDate());
			pstm.setString(5, dto.getFilePath() != null ? dto.getFilePath() : "");
			pstm.setString(6, dto.getFileName() != null ? dto.getFileName() : "");
			pstm.setString(7, dto.getFileExt() != null ? dto.getFileExt() : "");
			pstm.setInt(8, dto.getFileSize());
			pstm.setString(9, dto.getFileCategory() != null ? dto.getFileCategory() : "");
		
			registSuccess = pstm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("regist() error : " + e.getMessage());
		}
		System.out.println("============================");
		return registSuccess;
	}
	
	//댓글추가
	public int addComment(int idx, String currentId, String content) {
		int addCommentResult = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO tbl_bbs");
		sb.append("(refIdx, levelIdx, memberId, content)");
		sb.append("VALUES(?, ?, ?, ?)");
		
		try {
			String sql = sb.toString();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idx);
			pstm.setInt(2, 1);
			pstm.setString(3, currentId);
			pstm.setString(4, content);
			
			addCommentResult = pstm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("addComment()" + e.getMessage());
		}
		
		
		return addCommentResult;
	}
	
	
	
	
	//게시글 조회
	public BbsDTO view(int bbsNo) {
		System.out.println("============================");
		BbsDTO dto = new BbsDTO();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT idx, title, memberId, content, regDate, modifyDate, readCnt ");
		sb.append("FROM tbl_bbs ");
		sb.append("WHERE idx = ?");
		System.out.println("==================");
		System.out.println(sb.toString());
		System.out.println("==================");
		try {
			//PSTM 작성
			String sql = sb.toString();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, bbsNo);
			//결과 리턴
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto.setIdx(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setMemberId(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegDate(rs.getObject("regDate", LocalDateTime.class));
				dto.setModifyDate(rs.getObject("modifyDate", LocalDateTime.class));
				dto.setReadCnt(rs.getInt("readCnt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("view error : " + e.getMessage());
		}
		System.out.println("============================");
		
		return dto;
		
	}
	
	//
	public BbsDTO view(int refNo, String currentId, int levelIdx) {
		System.out.println("============================");
		BbsDTO dto = new BbsDTO();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT idx, title, memberId, content, regDate, modifyDate, readCnt ");
		sb.append("FROM tbl_bbs ");
		sb.append("WHERE refIdx = ? AND memberId = ? AND levelIdx ");
		System.out.println("==================");
		System.out.println(sb.toString());
		System.out.println("==================");
		try {
			//PSTM 작성
			String sql = sb.toString();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, refNo);
			pstm.setString(2, currentId);
			pstm.setInt(3, levelIdx);
			//결과 리턴
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto.setIdx(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setMemberId(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegDate(rs.getObject("regDate", LocalDateTime.class));
				dto.setModifyDate(rs.getObject("modifyDate", LocalDateTime.class));
				dto.setReadCnt(rs.getInt("readCnt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("view error : " + e.getMessage());
		}
		System.out.println("============================");
		
		return dto;
		
	}
	
	//게시글 조회수 증가
	public int addReadCnt(int bbsNo) {
		int addResult = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE tbl_bbs ");
		sb.append("SET readCnt = readCnt + 1 ");
		sb.append("WHERE idx = ?");
		
		try {
			String sql = sb.toString();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, bbsNo);
			addResult = pstm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("addReadCnt : " + e.getMessage());
		}
		
		return addResult;
	}
	//게시글 목록
	public List<BbsDTO> list(int page, int pageSize, String searchCategory, String searchWord, String sortCategory, String soryOrder) {
		return null;
	}
	
	
	
	
	//게시글 목록
	public List<BbsDTO> list(Map<String, Object> pMap) {
		List<BbsDTO> bbsList = new ArrayList<BbsDTO>();
		StringBuilder sb = new StringBuilder();
		int pageSize = (int)pMap.get("pageSize");
		int currentPage = (int)pMap.get("currentPage");
		sb.append("SELECT idx, title, memberId, content, regDate, modifyDate, readCnt, filePath, fileName ");
		sb.append("FROM tbl_bbs ");
	
		if(pMap.get("searchCategory") != null && pMap.get("searchCategory") != "") {
			sb.append("WHERE " + pMap.get("searchCategory") + " ");
			sb.append("LIKE '%" + pMap.get("searchWord") +"%'");
		}
		sb.append("ORDER BY idx ASC LIMIT ? OFFSET ?");
		System.out.println(sb.toString());
		System.out.println(pageSize +"  " + currentPage);
		try {
			String sql = sb.toString();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, pageSize);
			pstm.setInt(2, (currentPage - 1) * pageSize);
			
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				BbsDTO dto = new BbsDTO();
				dto.setIdx(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setMemberId(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegDate(rs.getObject("regDate", LocalDateTime.class));
				dto.setModifyDate(rs.getObject("modifyDate", LocalDateTime.class));
				dto.setReadCnt(rs.getInt("readCnt"));
				dto.setFilePath(rs.getString("filePath"));
				dto.setFileName(rs.getString("fileName"));
				bbsList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("list() : " + e.getMessage());
		}
		return bbsList;
	}
	//검색된 게시글의 개수
	public int searchedBbsCount(Map<String, Object> pMap) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(idx) ");
		sb.append("FROM tbl_bbs ");
		if(pMap.get("searchCategory") != null && pMap.get("searchCategory") != "") {
			sb.append("WHERE " + pMap.get("searchCategory") + " ");
			sb.append("LIKE '%" + pMap.get("searchWord") +"%'");
		}
		try {
			String sql = sb.toString();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("searchedBbsCount() : " + e.getMessage());
		}
		return count;
	}
	
	
	//게시글 수정
	public int modify(BbsDTO dto) {
		
		int result = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE tbl_bbs SET title =?, content=?, modifyDate=NOW()");
		sb.append(" WHERE idx=? and memberId=?");
		System.out.println(dto.getTitle());
		try {
			String sql = sb.toString();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getIdx());
			pstm.setString(4, dto.getMemberId());
			
			result = pstm.executeUpdate();
			
		} catch(Exception e) {
			System.out.print("게시글 수정에 실패하였습니다.");
			e.printStackTrace();
		}
		return result;
	}
	//게시글 삭제
	public int delete(Integer[] idxs) {
		int result = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM tbl_bbs");
		sb.append(" WHERE idx = ?");
		
		try {
			String sql = sb.toString();
			for(int idx : idxs) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, idx);
				
				result = pstm.executeUpdate();
			}
		} catch(Exception e) {
			System.out.print("게시글 삭제에 실패하였습니다.");
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete(Integer[] idxs, String id) {
		int result = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM tbl_bbs");
		sb.append(" WHERE idx = ? AND memberId = ?");
		
		try {
			String sql = sb.toString();
			for(int idx : idxs ) {
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, idx);
				pstm.setString(2, id);
				
				result = pstm.executeUpdate();
				if(result <= 0) {
					System.out.println("삭제실패");
					return result;
				}
			}
		} catch(Exception e) {
			System.out.print("게시글 삭제에 실패하였습니다.");
			e.printStackTrace();
		}
		return result;
	}
	//로그인 프로세스
	public int Login(Map<String, Object> loginMap) {
		StringBuilder sb = new StringBuilder();
		int loginResult = 0;
		sb.append("SELECT MB.memberID, MB.pwd ");
		sb.append("FROM tbl_bbs AS TB ");
		sb.append("RIGHT OUTER JOIN tbl_member AS MB ");
		sb.append("ON MB.memberId = TB.memberId ");
		sb.append("WHERE MB.memberId = '" + loginMap.get("memberId") + "' ");
		sb.append("AND ");
		sb.append("pwd = '" + loginMap.get("pwd")+"'");
		System.out.println(sb.toString());
		try {
			String sql = sb.toString();  
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(1) != null && rs.getString(1).equals(loginMap.get("memberId"))
					&&rs.getString(2) != null && rs.getString(2).equals(loginMap.get("pwd"))) {
					loginResult = 1;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("login Exception" + e.getMessage());
		}
			
		return loginResult;
	}
	//게시글 총개수
	public int totalBbsCount() {
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(idx) ");
		sb.append("FROM tbl_bbs ");
		try {
			String sql = sb.toString();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("totalBbsCount() : " + e.getMessage());
		}
		
		return cnt;
	}
	
	
	
}
