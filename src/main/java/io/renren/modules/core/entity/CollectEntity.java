package io.renren.modules.core.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-12 15:44:04
 */
public class CollectEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Long tags;
	//
	private Long uid;
	//
	private Integer created;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setTags(Long tags) {
		this.tags = tags;
	}
	/**
	 * 获取：
	 */
	public Long getTags() {
		return tags;
	}
	/**
	 * 设置：
	 */
	public void setUid(Long uid) {
		this.uid = uid;
	}
	/**
	 * 获取：
	 */
	public Long getUid() {
		return uid;
	}
	/**
	 * 设置：
	 */
	public void setCreated(Integer created) {
		this.created = created;
	}
	/**
	 * 获取：
	 */
	public Integer getCreated() {
		return created;
	}
}
