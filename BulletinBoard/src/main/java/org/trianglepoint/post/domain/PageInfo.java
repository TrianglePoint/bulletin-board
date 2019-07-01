package org.trianglepoint.post.domain;

import lombok.Data;

@Data
public class PageInfo {
	final static int DEFAULT_PAGE_NUM = 1;
	final static int DEFAULT_AMOUNT = 10;
	
	private int pageNum;
	private int amount;
	
	/**
	 * 
	 */
	public PageInfo() {
		this(DEFAULT_PAGE_NUM, DEFAULT_AMOUNT);
	}
	
	/**
	 * @param pageNum
	 * @param amount
	 */
	public PageInfo(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
