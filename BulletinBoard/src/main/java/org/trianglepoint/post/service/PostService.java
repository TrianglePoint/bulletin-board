package org.trianglepoint.post.service;

import java.util.List;

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
	 * @param post : Request number of post from client
	 * @return : success of modify?
	 */
	public boolean modify(PostVO post);
	
	/**
	 * @param pono : Request number of post from client
	 * @return : success of remove?
	 */
	public boolean remove(Long pono);
}