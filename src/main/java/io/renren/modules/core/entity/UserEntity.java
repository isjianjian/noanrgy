package io.renren.modules.core.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-10 18:35:57
 */
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long userId;
	//用户名
	private String nikename;
	//手机号
	private String mobile;
	//密码
	private String password;
	//创建时间
	private Date createTime;
	//
	private String email;
	//账号id
	private String account;
	//头像
	private String headImg;

	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名
	 */
	public void setNikename(String nikename) {
		this.nikename = nikename;
	}
	/**
	 * 获取：用户名
	 */
	public String getNikename() {
		return nikename;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：账号id
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 获取：账号id
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 设置：头像
	 */
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	/**
	 * 获取：头像
	 */
	public String getHeadImg() {
		return headImg;
	}
}
