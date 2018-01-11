package io.renren.modules.core.service;

import io.renren.modules.core.entity.UserTokenEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户Token
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-10 18:35:49
 */
public interface UserTokenService {
	
	UserTokenEntity queryObject(Long userId);
	
	List<UserTokenEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserTokenEntity userToken);
	
	void update(UserTokenEntity userToken);
	
	void delete(Long userId);
	
	void deleteBatch(Long[] userIds);
}
