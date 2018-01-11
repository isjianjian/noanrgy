package io.renren.modules.core.service.impl;

import io.renren.common.exception.RRException;
import io.renren.common.validator.Assert;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.renren.modules.core.dao.UserDao;
import io.renren.modules.core.entity.UserEntity;
import io.renren.modules.core.service.UserService;



@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserEntity queryObject(Long userId){
		return userDao.queryObject(userId);
	}
	
	@Override
	public List<UserEntity> queryList(Map<String, Object> map){
		return userDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userDao.queryTotal(map);
	}
	
	@Override
	public void save(UserEntity user){
		user.setCreateTime(new Date());
		user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
		userDao.save(user);
	}
	
	@Override
	public void update(UserEntity user){
		userDao.update(user);
	}
	
	@Override
	public void delete(Long userId){
		userDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Long[] userIds){
		userDao.deleteBatch(userIds);
	}

	@Override
	public long login(String account, String password) {
		UserEntity user = userDao.login(account);
		Assert.isNull(user,"账户不存在");
		if(!user.getPassword().equals(DigestUtils.sha256Hex(password))){
			throw new RRException("密码错误");
		}
		return user.getUserId();
	}

}
