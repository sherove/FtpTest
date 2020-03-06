package com.ftptest.login.vo;

public class LoginVo {
	
	private String userNo;
	private String userAuth;
	private String userId;
	private String userPwd;
	
	private String actorId;
	private String firstName;
	private String lastName;
	private String lastUpdate;
	
	
	public String getActorId() {
		return actorId;
	}
	public void setActorId(String actorId) {
		this.actorId = actorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getUserNo() {
		return userNo;
	}
	@Override
	public String toString() {
		return "LoginVo [userNo=" + userNo + ", userAuth=" + userAuth + ", userId=" + userId + ", userPwd=" + userPwd
				+ ", actorId=" + actorId + ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdate="
				+ lastUpdate + "]";
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(String userAuth) {
		this.userAuth = userAuth;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
}
