package org.trianglepoint.post.mapper;

import java.util.List;

import org.trianglepoint.post.domain.PostVO;

public interface PostMapper {
	public void insert(PostVO post);
	
	public PostVO get(Long pono);
	
	public List<PostVO> getList();
	
	public int update(PostVO post);
	
	public int delete(Long pono);
}
