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
public class ContentsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long cid;
	//标题
	private String title;
	//内容缩略名
	private String slug;
	//内容生成时的GMT unix时间戳
	private Integer created;
	//内容更改时的GMT unix时间戳
	private Integer modified;
	//内容文字
	private String content;
	//内容所属用户id
	private Long authorId;
	//内容类别
	private String type;
	//状态
	private String status;
	//标签
	private Long tags;
	//分类列表
	private String categories;
	//点击次数
	private Integer hits;
	// 内容所属评论数
	private Integer commentsNum;
	//是否允许评论
	private Integer allowComment;
	//是否允许ping
	private Integer allowPing;
	//允许出现在聚合中
	private Integer allowFeed;
	//文章缩略图
	private String thumbimg;

	/**
	 * 设置：
	 */
	public void setCid(Long cid) {
		this.cid = cid;
	}
	/**
	 * 获取：
	 */
	public Long getCid() {
		return cid;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：内容缩略名
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}
	/**
	 * 获取：内容缩略名
	 */
	public String getSlug() {
		return slug;
	}
	/**
	 * 设置：内容生成时的GMT unix时间戳
	 */
	public void setCreated(Integer created) {
		this.created = created;
	}
	/**
	 * 获取：内容生成时的GMT unix时间戳
	 */
	public Integer getCreated() {
		return created;
	}
	/**
	 * 设置：内容更改时的GMT unix时间戳
	 */
	public void setModified(Integer modified) {
		this.modified = modified;
	}
	/**
	 * 获取：内容更改时的GMT unix时间戳
	 */
	public Integer getModified() {
		return modified;
	}
	/**
	 * 设置：内容文字
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容文字
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：内容所属用户id
	 */
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	/**
	 * 获取：内容所属用户id
	 */
	public Long getAuthorId() {
		return authorId;
	}
	/**
	 * 设置：内容类别
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：内容类别
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：标签
	 */
	public void setTags(Long tags) {
		this.tags = tags;
	}
	/**
	 * 获取：标签
	 */
	public Long getTags() {
		return tags;
	}
	/**
	 * 设置：分类列表
	 */
	public void setCategories(String categories) {
		this.categories = categories;
	}
	/**
	 * 获取：分类列表
	 */
	public String getCategories() {
		return categories;
	}
	/**
	 * 设置：点击次数
	 */
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getHits() {
		return hits;
	}
	/**
	 * 设置： 内容所属评论数
	 */
	public void setCommentsNum(Integer commentsNum) {
		this.commentsNum = commentsNum;
	}
	/**
	 * 获取： 内容所属评论数
	 */
	public Integer getCommentsNum() {
		return commentsNum;
	}
	/**
	 * 设置：是否允许评论
	 */
	public void setAllowComment(Integer allowComment) {
		this.allowComment = allowComment;
	}
	/**
	 * 获取：是否允许评论
	 */
	public Integer getAllowComment() {
		return allowComment;
	}
	/**
	 * 设置：是否允许ping
	 */
	public void setAllowPing(Integer allowPing) {
		this.allowPing = allowPing;
	}
	/**
	 * 获取：是否允许ping
	 */
	public Integer getAllowPing() {
		return allowPing;
	}
	/**
	 * 设置：允许出现在聚合中
	 */
	public void setAllowFeed(Integer allowFeed) {
		this.allowFeed = allowFeed;
	}
	/**
	 * 获取：允许出现在聚合中
	 */
	public Integer getAllowFeed() {
		return allowFeed;
	}
	/**
	 * 设置：文章缩略图
	 */
	public void setThumbimg(String thumbimg) {
		this.thumbimg = thumbimg;
	}
	/**
	 * 获取：文章缩略图
	 */
	public String getThumbimg() {
		return thumbimg;
	}
}
