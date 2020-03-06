package com.ftptest.login.vo;

public class BaseVo {
	
	private String totcnt;
	private int unitCnt;
	private int nowIdx;
	private int rownum;
	
	@Override
	public String toString() {
		return "BaseVo [totcnt=" + totcnt + ", unitCnt=" + unitCnt + ", nowIdx=" + nowIdx + ", rownum=" + rownum + "]";
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getTotcnt() {
		return totcnt;
	}
	public void setTotcnt(String totcnt) {
		this.totcnt = totcnt;
	}
	public int getUnitCnt() {
		return unitCnt;
	}
	public void setUnitCnt(int unitCnt) {
		this.unitCnt = unitCnt;
	}
	public int getNowIdx() {
		return nowIdx;
	}
	public void setNowIdx(int nowIdx) {
		this.nowIdx = nowIdx;
	}
	
}
