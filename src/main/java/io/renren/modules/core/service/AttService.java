package io.renren.modules.core.service;

import io.renren.modules.core.entity.AttEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-12 15:44:04
 */
public interface AttService {
	
	AttEntity queryObject(Long id);
	
	List<AttEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AttEntity att);
	
	void update(AttEntity att);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

    boolean isAtt(Long uid, Long attid);

    void unAtt(Long uid, Long attid);
}
