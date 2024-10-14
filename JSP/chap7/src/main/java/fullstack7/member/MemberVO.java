package fullstack7.member;

import java.time.LocalDateTime;

public class MemberVO {
	private int idx;
	private String name;
	private String pwd;
	private String jumin;
	private String addr1;
	private String addr2;
	private String birth;
	private String jobCode;
	private int mileage;
	private String memberState;
	private LocalDateTime regDate;
	private LocalDateTime leaveDage;
	private LocalDateTime pwdChangeDate;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getMemberState() {
		return memberState;
	}
	public void setMemberState(String memberState) {
		this.memberState = memberState;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public LocalDateTime getLeaveDage() {
		return leaveDage;
	}
	public void setLeaveDage(LocalDateTime leaveDage) {
		this.leaveDage = leaveDage;
	}
	public LocalDateTime getPwdChangeDate() {
		return pwdChangeDate;
	}
	public void setPwdChangeDate(LocalDateTime pwdChangeDate) {
		this.pwdChangeDate = pwdChangeDate;
	}
}
