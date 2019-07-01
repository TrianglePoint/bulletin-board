package org.trianglepoint.post.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.trianglepoint.post.domain.PageInfo;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class PageListInfoTests {
	
	private PageListInfo pageListInfo;
	
	/**
	 * 
	 */
	@Before
	public void setup() {
		pageListInfo = new PageListInfo(new PageInfo(), 300);
	}
	
	/**
	 * 
	 */
	public void testCheckVariables() {
		log.info(pageListInfo);
	}
}
