package org.trianglepoint.post.mapper;

import java.util.List;

import org.trianglepoint.post.domain.PageInfo;
import org.trianglepoint.post.domain.PostVO;

public interface PostMapper {
	/**
	 * @param post : Post data from client
	 * @return : How many change on DB?
	 */
	public int insert(PostVO post);
	
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
	public List<PostVO> getListWithPaging(PageInfo pageInfo);
	
	/**
	 * @param post : Modified post data from client
	 * @return : How many change on DB?
	 */
	public int update(PostVO post);
	
	/**
	 * @param pono : Request number of post from client
	 * @return : How many change on DB?
	 */
	public int delete(Long pono);
	
	/**
	 * @param pageInfo : Search condition
	 * @return : Total page count
	 */
	public int getTotal(PageInfo pageInfo);
}
