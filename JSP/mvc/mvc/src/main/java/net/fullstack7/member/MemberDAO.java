package net.fullstack7.member;

import net.fullstack7.common.DBConnPool;

public class MemberDAO extends DBConnPool{
	public int memberRegist(MemberDTO dto) {
		int registResult = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO tbl_member(");
		sb.append("`memberId`, `pwd`, `name`)");
		sb.append("VALUES(?, ?, ?)");
		try {
			String sql = sb.toString();
			if(dto != null) {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, dto.getMemberId());
				pstm.setString(2, dto.getPwd());
				pstm.setString(3, dto.getName());
				registResult = pstm.executeUpdate();
			}else {
				registResult = -1;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("memberRegist() : " + e.getMessage());
		}
		
		return registResult;
	}
}
