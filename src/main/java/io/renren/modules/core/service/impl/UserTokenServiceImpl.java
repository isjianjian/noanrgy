package io.renren.modules.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.core.dao.UserTokenDao;
import io.renren.modules.core.entity.UserTokenEntity;
import io.renren.modules.core.service.UserTokenService;



@Service("userTokenService")
public class UserTokenServiceImpl implements UserTokenService {
	@Autowired
	private UserTokenDao userTokenDao;
	
	@Override
	public UserTokenEntity queryObject(Long userId){
		return userTokenDao.queryObject(userId);
	}
	
	@Override
	public List<UserTokenEntity> queryList(Map<String, Object> map){
		return userTokenDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userTokenDao.queryTotal(map);
	}
	
	@Override
	public void save(UserTokenEntity userToken){
		userTokenDao.save(userToken);
	}
	
	@Override
	public void update(UserTokenEntity userToken){
		userTokenDao.update(userToken);
	}
	
	@Override
	public void delete(Long userId){
		userTokenDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Long[] userIds){
		userTokenDao.deleteBatch(userIds);
	}
	
}
