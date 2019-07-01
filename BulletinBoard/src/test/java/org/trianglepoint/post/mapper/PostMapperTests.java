package org.trianglepoint.post.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.trianglepoint.post.domain.PageInfo;
import org.trianglepoint.post.domain.PostVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class PostMapperTests {
	/**
	 * @param mapper
	 */
	@Setter(onMethod_ = @Autowired)
	private PostMapper mapper;
	
	/**
	 * 
	 */
	public void testInsert() {
		PostVO post = new PostVO();
		post.setTitle("new post");
		post.setText("ha");
		post.setWriter("user22");
		
		mapper.insert(post);
		
		log.info(post);
	}
	
	/**
	 * 
	 */
	public void testGet() {
		PostVO post = mapper.get(2L);
		
		log.info(post);
	}
	
	/**
	 * 
	 */
	public void testGetList() {
		mapper.getList().forEach(post -> log.info(post));
	}
	
	/**
	 * 
	 */
	public void testGetListPaging() {
		mapper.getListPaging(new PageInfo()).forEach(post -> log.info(post));
	}

	/**
	 * 
	 */
	public void testUpdate() {
		PostVO post = mapper.get(2L);
		post.setTitle("HAHA");
		post.setText("IHIIH");
		post.setWriter("NIAHO");
		
		log.info("UPDATE COUNT : " + mapper.update(post));
	}
	
	/**
	 * 
	 */
	public void testDelete() {
		log.info("DELETE COUNT : " + mapper.delete(3L));
	}
	
	/**
	 * 
	 */
	public void testGetTotal() {
		log.info("POST COUNT : " + mapper.getTotal());
	}
}
