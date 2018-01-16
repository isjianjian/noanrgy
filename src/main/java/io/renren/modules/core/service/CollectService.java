package io.renren.modules.core.service;

import io.renren.modules.core.entity.CollectEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-12 15:44:04
 */
public interface CollectService {
	
	CollectEntity queryObject(Long id);
	
	List<CollectEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CollectEntity collect);
	
	void update(CollectEntity collect);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

    boolean isCollect(Long uid, Long clid);

	void unCollect(Long uid, Long tid);
}
