package io.renren.modules.core.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-10 18:35:50
 */
public class ClassifyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String name;
	//
	private String desc;
	//
	private String slug;
	//
	private Integer count;
	//
	private Long authorId;
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
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 设置：
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}
	/**
	 * 获取：
	 */
	public String getSlug() {
		return slug;
	}
	/**
	 * 设置：
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * 获取：
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * 设置：
	 */
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	/**
	 * 获取：
	 */
	public Long getAuthorId() {
		return authorId;
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
