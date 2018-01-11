package io.renren.modules.core.service;

import io.renren.modules.core.entity.ClassifyEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-10 18:35:50
 */
public interface ClassifyService {
	
	ClassifyEntity queryObject(Long id);
	
	List<ClassifyEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ClassifyEntity classify);
	
	void update(ClassifyEntity classify);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
