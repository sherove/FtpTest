package com.ftptest.login.vo;

public class RentalVo extends BaseVo {
	private String filmId;
	private String title;
	private String inventoryId;
	private String storeId;
	private String rentalId;
	private String returnDate;
	private String customerId;
	private String customerNm;
	private String searchData;

	
	
	public String getSearchData() {
		return searchData;
	}
	public void setSearchData(String searchData) {
		this.searchData = searchData;
	}
	public String getCustomerNm() {
		return customerNm;
	}
	public void setCustomerNm(String customerNm) {
		this.customerNm = customerNm;
	}
	public String getFilmId() {
		return filmId;
	}
	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getRentalId() {
		return rentalId;
	}
	public void setRentalId(String rentalId) {
		this.rentalId = rentalId;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "RentalVo [filmId=" + filmId + ", title=" + title + ", inventoryId=" + inventoryId + ", storeId="
				+ storeId + ", rentalId=" + rentalId + ", returnDate=" + returnDate + ", customerId=" + customerId
				+ ", customerNm=" + customerNm + ", searchData=" + searchData + "]";
	}
	
	
	
}
