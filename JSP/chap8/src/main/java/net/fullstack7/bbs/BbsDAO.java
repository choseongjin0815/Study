package net.fullstack7.bbs;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import net.fullstack7.member.MemberDTO;
import net.fullstack7.common.*;
public class BbsDAO extends DBConnPool{
	public BbsDAO() {
		super();
	}
	public List<BbsDTO> getBbsList(){
		List<BbsDTO> dtoList = new ArrayList<>();
		
		String sql = "SELECT idx, title, memberId, readCnt, regDate FROM tbl_bbs";
		
		DBConnPool dbcp = new DBConnPool();
		
		try {
			PreparedStatement psmt = dbcp.con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BbsDTO dto = new BbsDTO();
				dto.setMemberId(rs.getString("memberId"));
				dto.setTitle(rs.getString("title"));
				dto.setIdx(rs.getInt("idx"));
				dto.setReadCnt(rs.getInt("readCnt"));
				dto.setRegDate(rs.getObject("regDate", LocalDateTime.class));
				
				dtoList.add(dto);
				
			}
			for(BbsDTO m : dtoList) {
				System.out.println(m.getMemberId());
			}			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("게시판정보조회실패");
		}finally {
			close();
		}
		
		return dtoList;	
	}
	
	public BbsDTO getBbsInfo(int idx) {
		BbsDTO dto = new BbsDTO();
		String sql = "SELECT title, memberId, content, idx FROM tbl_bbs WHERE idx = ?";
		
		DBConnPool dbcp = new DBConnPool();
		
	
		
		try {
			PreparedStatement psmt = dbcp.con.prepareStatement(sql);
			psmt.setInt(1, idx);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setMemberId(rs.getString("memberId"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
			}

		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("회원정보조회실패");
		}finally {
			close();
		}
		
		return dto;
	}
	
	public void addReadCnt(int idx) {
		DBConnPool dbcp = new DBConnPool();
		String sql = "UPDATE tbl_bbs SET readCnt = readCnt + 1  WHERE idx = ?";
		try {
			PreparedStatement psmt = dbcp.con.prepareStatement(sql);
			psmt.setInt(1, idx);
			psmt.executeUpdate();
			System.out.println("조회수 추가해봄");
		}catch(Exception e) {
			System.out.println("안됨");
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	
	public int setDeleteBbs(Integer[] selectedIdx) {
		DBConnPool dbcp = new DBConnPool();
		String sql = "DELETE FROM tbl_bbs WHERE idx = ?";
		try {
			System.out.println("test");
			PreparedStatement pstm = dbcp.con.prepareStatement(sql);
			for(int idx : selectedIdx) {
				System.out.println("test");
				pstm.setInt(1, idx);
				pstm.executeUpdate();
			}
		} catch(Exception e) {
			System.out.println("삭제실패");
		}
		return 0;
	}
	
	public int setMemberModify(BbsDTO bbsInfo) {
		DBConnPool dbcp = new DBConnPool();
		BbsDTO dto = bbsInfo;
		String sql = "UPDATE tbl_Bbs SET title = ?, content = ? WHERE idx = ?";
		try {
			System.out.println(dto.getTitle());
			System.out.println("1234551312321");
		PreparedStatement pstm = dbcp.con.prepareStatement(sql);
		pstm.setString(1, dto.getTitle());
		pstm.setString(2, dto.getContent());
		pstm.setInt(3, dto.getIdx());
		pstm.executeUpdate();
		}catch(Exception e) {
			System.out.print("수정실패");
		}
		return 0;
	}
	
	public int setMemberRegist(Map<String, String> memberInfo) {
		Map<String, String> memInfo = memberInfo;
		String sql = "INSERT INTO tbl_member (`title`, `content`, `memberId`) VALUES(?, ?, ?)"; 
		try {
			DBConnPool dbcp = new DBConnPool();
			PreparedStatement psmt = dbcp.con.prepareStatement(sql);
			psmt.setString(1, memInfo.get("title"));
			psmt.setString(2, memInfo.get("content"));
			psmt.setString(3, memInfo.get("memberId"));
			//System.out.println(memInfo.get("memberId"));
			psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("회원 정보를 삽입하지 못하였습니다.");
		}
		
		return 0;
	}
	
	
}
