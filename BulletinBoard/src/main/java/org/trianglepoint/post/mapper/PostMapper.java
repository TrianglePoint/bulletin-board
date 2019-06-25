package org.trianglepoint.post.mapper;

import java.util.List;

import org.trianglepoint.post.domain.PostVO;

public interface PostMapper {
	/**
	 * @param post : Clientからのpostデータ
	 * @return : DBでどのくらい変わったか？
	 */
	public int insert(PostVO post);
	
	/**
	 * @param pono : Clientからのpostの要望の数字
	 * @return : 要望のpostデータ
	 */
	public PostVO get(Long pono);
	
	/**
	 * @return : Postデータリスト
	 */
	public List<PostVO> getList();
	
	/**
	 * @param post : Clientからの修正されたpostデータ
	 * @return : DBでどのくらい変わったか？
	 */
	public int update(PostVO post);
	
	/**
	 * @param pono : Clientからのpostの要望の数字
	 * @return : DBでどのくらい変わったか？
	 */
	public int delete(Long pono);
}
