package org.trianglepoint.post.domain;

import lombok.Data;

@Data
public class PageListInfo {
	
	private int startPage;
	private int endPage;
	
	private boolean previous;
	private boolean next;
	
	/**
	 * @param pageRequester : Current page, amount
	 * @param total : Total pages count
	 */
	public PageListInfo(PageInfo pageInfo, int total) {
		
		final double ONE_DECIMAL_POINT = 10.0;
		final int PAGES_AMOUNT = 10;
		final int ONE_PAGE = 1;
		final int FIRST_PAGE = 1;
		
		int realEndPage; 
		
		endPage = (int)(Math.ceil(pageInfo.getPageNum() / ONE_DECIMAL_POINT) * 
						ONE_DECIMAL_POINT);
		startPage = endPage - PAGES_AMOUNT + ONE_PAGE;
		
		realEndPage = (int)Math.ceil((double)total / pageInfo.getAmount());
		
		if(endPage > realEndPage) {
			endPage = realEndPage;
		}
		
		next = endPage != realEndPage;
		previous = startPage != FIRST_PAGE;
	}
}
