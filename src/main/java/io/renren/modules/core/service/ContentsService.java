package io.renren.modules.core.service;

import io.renren.modules.core.entity.ContentsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-10 18:35:50
 */
public interface ContentsService {
	
	ContentsEntity queryObject(Long cid);
	
	List<ContentsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ContentsEntity contents);
	
	void update(ContentsEntity contents);
	
	void delete(Long cid);
	
	void deleteBatch(Long[] cids);
}
