package fullstack7.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnPool {
	public Connection con;
	public Statement stmt;
	public PreparedStatement pstm;
	public ResultSet rs;
	
	public DBConnPool() {
		try {
			Context initCtx = new InitialContext();
			Context ctx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)ctx.lookup("jdbc_fullstack7");
			con = ds.getConnection();
			
			System.out.println("=================================");
			System.out.println("커넥션풀 접속 성공");
			System.out.println("con String : " + con);
			System.out.println("=================================");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("=================================");
			System.out.println("DB 커넥션풀 접속 에러");
			System.out.println(e.getMessage());
			System.out.println("=================================");
		}
		
	}
	
	
	//연결 해제 (리소스 자원 반납)
		public void close() {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(pstm != null) pstm.close();
				if(con != null) con.close();
				
				System.out.println("=================================");
				System.out.println("커넥션 풀 자원해제<br>");
				System.out.println("=================================");
				
			} catch(Exception e) {
				System.out.println("=================================");
				System.out.println(e.getMessage()+"<br>");
				System.out.println("=================================");
				
			} 
		}
}