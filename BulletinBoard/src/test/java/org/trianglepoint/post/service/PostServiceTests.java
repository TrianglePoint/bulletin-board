package org.trianglepoint.post.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.trianglepoint.post.domain.PostVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class PostServiceTests {
	/**
	 * @param service
	 */
	@Setter(onMethod_ = @Autowired)
	private PostService service;
	
	/**
	 * Test of confirm the exist of service
	 */
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	/**
	 * 
	 */
	public void testRegister() {
		PostVO post = new PostVO();
		post.setTitle("service T");
		post.setText("Service!");
		post.setWriter("Server");
		
		log.info("REGISTERED? " + service.register(post));
	}
	
	/**
	 * 
	 */
	public void testGet() {
		log.info(service.get(2L));
	}
	
	/**
	 * 
	 */
	public void testGetList() {
		service.getList().forEach(post -> log.info(post));
	}
	
	/**
	 * 
	 */
	public void testModify() {
		PostVO post = service.get(2L);
		
		if(post == null) {
			return;
		}
		
		post.setTitle("Modified");
		log.info("MODIFIED? " + service.modify(post));
	}
	
	/**
	 * 
	 */
	public void testRemove() {
		log.info("DELETED? " + service.remove(4L));
	}
	
	/**
	 * 
	 */
	public void testGetTotal() {
		log.info("POST TOTAL in service : " + service.getTotal());
	}
}
