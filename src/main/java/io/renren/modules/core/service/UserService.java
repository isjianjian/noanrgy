package io.renren.modules.core.service;

import io.renren.modules.core.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-10 18:35:57
 */
public interface UserService {
	
	UserEntity queryObject(Long userId);
	
	List<UserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserEntity user);
	
	void update(UserEntity user);
	
	void delete(Long userId);
	
	void deleteBatch(Long[] userIds);

    long login(String account, String password);
}
