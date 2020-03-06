package com.ftptest.login.vo;

public class UserVo {

	private String staffId;
	private String firstName;
	private String lastName;
	private String email;
	private String storeId;
	private String userName;
	private String password;
	public String getStaffId() {
		return staffId;
	}
	@Override
	public String toString() {
		return "UserVo [staffId=" + staffId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", storeId=" + storeId + ", userName=" + userName + ", password=" + password + "]";
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
