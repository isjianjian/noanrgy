package io.renren.modules.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.core.dao.TagDao;
import io.renren.modules.core.entity.TagEntity;
import io.renren.modules.core.service.TagService;



@Service("tagService")
public class TagServiceImpl implements TagService {
	@Autowired
	private TagDao tagDao;
	
	@Override
	public TagEntity queryObject(Long id){
		return tagDao.queryObject(id);
	}
	
	@Override
	public List<TagEntity> queryList(Map<String, Object> map){
		return tagDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tagDao.queryTotal(map);
	}
	
	@Override
	public void save(TagEntity tag){
		tagDao.save(tag);
	}
	
	@Override
	public void update(TagEntity tag){
		tagDao.update(tag);
	}
	
	@Override
	public void delete(Long id){
		tagDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		tagDao.deleteBatch(ids);
	}
	
}
