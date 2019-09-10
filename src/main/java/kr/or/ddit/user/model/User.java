package kr.or.ddit.user.model;

public class User {
	private String userId;
	private String userNm;
	private String alias;
	
	// 기본 생성자 생성
	public User() {
		
	}
	
	// 사용자 아이디를 인자로 하는 생성자 생성
	public User(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNm=" + userNm + ", alias=" + alias + "]";
	}
	
	
}
