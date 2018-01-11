package io.renren.modules.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.core.dao.ClassifyDao;
import io.renren.modules.core.entity.ClassifyEntity;
import io.renren.modules.core.service.ClassifyService;



@Service("classifyService")
public class ClassifyServiceImpl implements ClassifyService {
	@Autowired
	private ClassifyDao classifyDao;
	
	@Override
	public ClassifyEntity queryObject(Long id){
		return classifyDao.queryObject(id);
	}
	
	@Override
	public List<ClassifyEntity> queryList(Map<String, Object> map){
		return classifyDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return classifyDao.queryTotal(map);
	}
	
	@Override
	public void save(ClassifyEntity classify){
		classifyDao.save(classify);
	}
	
	@Override
	public void update(ClassifyEntity classify){
		classifyDao.update(classify);
	}
	
	@Override
	public void delete(Long id){
		classifyDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		classifyDao.deleteBatch(ids);
	}
	
}
