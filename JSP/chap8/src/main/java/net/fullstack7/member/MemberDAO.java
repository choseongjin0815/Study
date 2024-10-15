package net.fullstack7.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.*;
import net.fullstack7.common.DBConnPool;


public class MemberDAO extends DBConnPool{
	public MemberDAO() {
		super();
	}

	/**
	 * @desc 아이디로 회원정보 조회
	 * 
	 * @param user_id String
	 * @return MemberDTO
	 * 
	 * @example getMemberInfo('user1')
	 */
	
	public MemberDTO getMemberInfo(String user_id) {
		
		
		return null;
	}
	
	public MemberDTO getMemberInfo(String user_id, String pwd) {
		MemberDTO dto = new MemberDTO();
		String sql = "SELECT memberId, name, pwd FROM tbl_member WHERE memberId = ?";
		
		DBConnPool dbcp = new DBConnPool();
		
	
		
		try {
			PreparedStatement psmt = dbcp.con.prepareStatement(sql);
			psmt.setString(1, user_id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setMemberId(rs.getString("memberId"));
				dto.setName(rs.getString("name"));
				dto.setPwd(rs.getString("pwd"));
			}

		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("회원정보조회실패");
		}finally {
			close();
		}
		
		return dto;
	}
	
	public MemberDTO getMemberList(int pageNo, int pageSize, String searchField
							, String searchWord, String[] sortField, String[] sortOrder) {
		return null;
	}
	
	public List<MemberDTO> getMemberList() {
		List<MemberDTO> dtoList = new ArrayList<>();
	
		String sql = "SELECT memberId, name, pwd, regDate FROM tbl_member";
		
		DBConnPool dbcp = new DBConnPool();
		
		try {
			PreparedStatement psmt = dbcp.con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setMemberId(rs.getString("memberId"));
				dto.setName(rs.getString("name"));
				dto.setPwd(rs.getString("pwd"));
				dto.setRegDate(rs.getObject("regDate", LocalDateTime.class));
				
				dtoList.add(dto);
				
			}
			for(MemberDTO m : dtoList) {
				System.out.println(m.getMemberId() + " " + m.getName() + " " + m.getPwd());
			}
			
						
			

		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("회원정보조회실패");
		}finally {
			close();
		}
		
		return dtoList;
	}
	
	public int setMemberRegist(Map<String, String> memberInfo) {
		Map<String, String> memInfo = memberInfo;
		String sql = "INSERT INTO tbl_member (`memberId`, `name`, `pwd`) VALUES(?, ?, ?)"; 
		try {
			DBConnPool dbcp = new DBConnPool();
			PreparedStatement psmt = dbcp.con.prepareStatement(sql);
			psmt.setString(1, memInfo.get("memberId"));
			psmt.setString(2, memInfo.get("name"));
			psmt.setString(3, memInfo.get("pwd"));
			//System.out.println(memInfo.get("memberId"));
			psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("회원 정보를 삽입하지 못하였습니다.");
		}
		
		return 0;
	}
	
	public int setMemberModify(MemberDTO memberInfo) {
		DBConnPool dbcp = new DBConnPool();
		MemberDTO memInfo = memberInfo;
		String sql = "UPDATE tbl_member SET name = ?, pwd = ? WHERE memberId = ?";
		try {
		PreparedStatement pstm = dbcp.con.prepareStatement(sql);
		pstm.setString(1, memInfo.getName());
		pstm.setString(2, memInfo.getPwd());
		pstm.setString(3, memInfo.getMemberId());
		pstm.executeUpdate();
		}catch(Exception e) {
			System.out.print("수정실패");
		}
		return 0;
	}
	
	public int setDeleteMember(String[] selected_user_id) {
		DBConnPool dbcp = new DBConnPool();
		String sql = "DELETE FROM tbl_member WHERE memberId = ?";
		try {
			PreparedStatement pstm = dbcp.con.prepareStatement(sql);
			for(String id : selected_user_id) {
				System.out.println("test");
				pstm.setString(1, id);
				pstm.executeUpdate();
			}
		} catch(Exception e) {
			System.out.println("삭제실패");
		}
		return 0;
	}
	
}
