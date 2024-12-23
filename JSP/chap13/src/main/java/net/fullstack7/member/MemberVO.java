package net.fullstack7.member;

import java.time.LocalDateTime;

public class MemberVO {
	private String memberId;
	private String name;
	private String pwd;
	private String jumin;
	private String addr1;
	private String addr2;
	private String birthday;
	private String jobCode;
	private int mileage;
	private String memberStatue;
	private LocalDateTime regDate;
	private LocalDateTime leaveDate;
	private LocalDateTime pwdChangeDate;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	public String getMemberStatue() {
		return memberStatue;
	}
	public void setMemberStatue(String memberStatue) {
		this.memberStatue = memberStatue;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public LocalDateTime getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(LocalDateTime leaveDate) {
		this.leaveDate = leaveDate;
	}
	public LocalDateTime getPwdChangeDate() {
		return pwdChangeDate;
	}
	public void setPwdChangeDate(LocalDateTime pwdChangeDate) {
		this.pwdChangeDate = pwdChangeDate;
	}
}
