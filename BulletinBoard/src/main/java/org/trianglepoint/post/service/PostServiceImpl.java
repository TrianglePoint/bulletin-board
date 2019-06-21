package org.trianglepoint.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trianglepoint.post.domain.PostVO;
import org.trianglepoint.post.mapper.PostMapper;

import lombok.Setter;

@Service
public class PostServiceImpl implements PostService {
	
	@Setter(onMethod_ = @Autowired)
	private PostMapper mapper;
	
	@Override
	public void register(PostVO post) {
		mapper.insert(post);
	}

	@Override
	public PostVO get(Long pono) {
		return mapper.get(pono);
	}

	@Override
	public List<PostVO> getList() {
		return mapper.getList();
	}

	@Override
	public boolean modify(PostVO post) {
		return mapper.update(post) == 1;
	}

	@Override
	public boolean remove(Long pono) {
		return mapper.delete(pono) == 1;
	}

}