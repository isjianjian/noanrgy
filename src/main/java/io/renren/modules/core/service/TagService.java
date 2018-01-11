package io.renren.modules.core.service;

import io.renren.modules.core.entity.TagEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-10 18:35:50
 */
public interface TagService {
	
	TagEntity queryObject(Long id);
	
	List<TagEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TagEntity tag);
	
	void update(TagEntity tag);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
