package io.renren.modules.core.service;

import io.renren.modules.core.entity.CommentsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-10 18:35:50
 */
public interface CommentsService {
	
	CommentsEntity queryObject(Long coid);
	
	List<CommentsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CommentsEntity comments);
	
	void update(CommentsEntity comments);
	
	void delete(Long coid);
	
	void deleteBatch(Long[] coids);
}
