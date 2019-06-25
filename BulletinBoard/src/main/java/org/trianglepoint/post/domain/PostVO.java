package org.trianglepoint.post.domain;

import java.util.Date;

import lombok.Data;

/**
 * 関数 : 
 *   Constructor,
 *   getter, setter, equals, canEqual,
 *   hashCode, toString
 */
@Data
public class PostVO {
	private Long pono;
	private String title;
	private String text;
	private String writer;
	private Date regDate;
	private Date updateDate;
}
