package com.bkap.entity;

public class Paging {
	private int pageNo;
	private int pageOffset;
	public Paging(int pageNo, int pageOffset) {
		super();
		this.pageNo = pageNo;
		this.pageOffset = pageOffset;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageOffset() {
		return pageOffset;
	}
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	
	
}
