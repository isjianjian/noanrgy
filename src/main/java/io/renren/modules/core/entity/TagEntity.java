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
public class TagEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String name;
	//
	private String desc;
	//
	private Long authorId;
	//
	private String icon;
	//
	private String type;
	//
	private Long classifyId;
	//
	private Integer created;


	public static final String SVG = "svg";

	public static final String URL = "url";


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
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setClassifyId(Long classifyId) {
		this.classifyId = classifyId;
	}
	/**
	 * 获取：
	 */
	public Long getClassifyId() {
		return classifyId;
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
