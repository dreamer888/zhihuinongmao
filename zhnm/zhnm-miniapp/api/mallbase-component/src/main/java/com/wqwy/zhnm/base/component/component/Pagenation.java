package com.wqwy.zhnm.base.component.component;

public class Pagenation {
	// 当前页
	private int pageNum = 1;
	// 每页的数量
	private int pageSize = 777777777;
	// 总数
	private long total;
    
    
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
}
