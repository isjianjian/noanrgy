package io.renren.modules.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-10 18:35:50
 */
public class CommentsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long coid;
	//文章id
	private Long cid;
	//评论生成时的GMT unix时间戳
	private Integer created;
	//作者名称
	private String author;
	//作者id
	private Long authorId;
	//所有者
	private Long ownerId;
	//邮箱
	private String mail;
	//超链接
	private String url;
	//ip
	private String ip;
	//评论者客户端
	private String agent;
	//内容
	private String content;
	//类型
	private String type;
	//状态
	private String status;
	//父id
	private Long parent;

	private String puser;
	/**
	 * 设置：
	 */
	public void setCoid(Long coid) {
		this.coid = coid;
	}
	/**
	 * 获取：
	 */
	public Long getCoid() {
		return coid;
	}
	/**
	 * 设置：文章id
	 */
	public void setCid(Long cid) {
		this.cid = cid;
	}
	/**
	 * 获取：文章id
	 */
	public Long getCid() {
		return cid;
	}
	/**
	 * 设置：评论生成时的GMT unix时间戳
	 */
	public void setCreated(Integer created) {
		this.created = created;
	}
	/**
	 * 获取：评论生成时的GMT unix时间戳
	 */
	public Integer getCreated() {
		return created;
	}
	/**
	 * 设置：作者名称
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：作者名称
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 设置：作者id
	 */
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	/**
	 * 获取：作者id
	 */
	public Long getAuthorId() {
		return authorId;
	}
	/**
	 * 设置：所有者
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	/**
	 * 获取：所有者
	 */
	public Long getOwnerId() {
		return ownerId;
	}
	/**
	 * 设置：邮箱
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * 获取：邮箱
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * 设置：超链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：超链接
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 获取：ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 设置：评论者客户端
	 */
	public void setAgent(String agent) {
		this.agent = agent;
	}
	/**
	 * 获取：评论者客户端
	 */
	public String getAgent() {
		return agent;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
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
	 * 设置：父id
	 */
	public void setParent(Long parent) {
		this.parent = parent;
	}
	/**
	 * 获取：父id
	 */
	public Long getParent() {
		return parent;
	}

    public String getPuser() {
        return puser;
    }

    public void setPuser(String puser) {
        this.puser = puser;
    }
}
