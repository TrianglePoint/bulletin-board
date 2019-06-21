package org.trianglepoint.post.service;

import java.util.List;

import org.trianglepoint.post.domain.PostVO;

public interface PostService {
	public void register(PostVO post);
	
	public PostVO get(Long pono);
	
	public List<PostVO> getList();
	
	public boolean modify(PostVO post);
	
	public boolean remove(Long pono);
}