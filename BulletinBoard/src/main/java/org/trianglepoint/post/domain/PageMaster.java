package org.trianglepoint.post.domain;

import lombok.Data;

@Data
public class PageMaster {
	final static int DEFAULT_PAGE_NUM = 1;
	final static int DEFAULT_AMOUNT = 10;
	
	private int pageNum;
	private int amount;
	
	public PageMaster() {
		this(DEFAULT_PAGE_NUM, DEFAULT_AMOUNT);
	}
	
	public PageMaster(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
