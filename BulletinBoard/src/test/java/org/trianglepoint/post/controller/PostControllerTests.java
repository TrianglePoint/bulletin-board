package org.trianglepoint.post.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class PostControllerTests {
	/**
	 * @param ctx
	 */
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	/**
	 * Setup for web test
	 */
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	/**
	 * @throws Exception
	 */
	public void testRegister() throws Exception{
		String resultPage = 
				mockMvc.perform(MockMvcRequestBuilders.post("/post/register")
				.param("title", "Title")
				.param("text", "hi")
				.param("writer", "kdkd")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
	
	/**
	 * @throws Exception
	 */
	public void testGet() throws Exception{
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/post/get")
				.param("pono", "5")
				).andReturn().getModelAndView().getModelMap());
	}
	
	/**
	 * @throws Exception
	 */
	public void testList() throws Exception{
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/post/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	/**
	 * @throws Exception
	 */
	public void testModify() throws Exception{
		String resultPage = 
				mockMvc.perform(MockMvcRequestBuilders.post("/post/modify")
				.param("pono", "5")
				.param("title", "MODIFY5")
				.param("text", "modified")
				.param("writer", "modi")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
	
	/**
	 * @throws Exception
	 */
	public void testRemove() throws Exception{
		String resultPage = 
				mockMvc.perform(MockMvcRequestBuilders.post("/post/remove")
				.param("pono", "6")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
}
