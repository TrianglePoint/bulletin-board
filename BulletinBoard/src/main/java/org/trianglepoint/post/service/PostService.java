package org.trianglepoint.post.service;

import java.util.List;

import org.trianglepoint.post.domain.PostVO;

public interface PostService {
	/**
	 * @param post : Clientからのpostデータ
	 * @return : 登録の成功？
	 */
	public boolean register(PostVO post);
	
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
	 * @return : 修正の成功？
	 */
	public boolean modify(PostVO post);
	
	/**
	 * @param pono : Clientからのpostの要望の数字
	 * @return : 削除の成功？
	 */
	public boolean remove(Long pono);
}