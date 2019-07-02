package org.trianglepoint.post.service;

import java.util.List;

import org.trianglepoint.post.domain.PageInfo;
import org.trianglepoint.post.domain.PostVO;

public interface PostService {
	/**
	 * @param post : Post data from client
	 * @return : success of register?
	 */
	public boolean register(PostVO post);
	
	/**
	 * @param pono : Request number of post from client
	 * @return : Requested post data
	 */
	public PostVO get(Long pono);
	
	/**
	 * @return : Post data list
	 */
	public List<PostVO> getList();
	
	/**
	 * @param pageInfo : Request number of page from client
	 * @return : Post data list
	 */
	public List<PostVO> getListPaging(PageInfo pageInfo);
	
	/**
	 * @param post : Modified post data from client
	 * @return : success of modify?
	 */
	public boolean modify(PostVO post);
	
	/**
	 * @param pono : Request number of post from client
	 * @return : success of remove?
	 */
	public boolean remove(Long pono);
	
	/**
	 * @param pageInfo : Search condition
	 * @return : Total page count
	 */
	public int getTotal(PageInfo pageInfo);
}
