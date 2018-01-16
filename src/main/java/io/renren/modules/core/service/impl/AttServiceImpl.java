package io.renren.modules.core.service.impl;

import io.renren.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.renren.modules.core.dao.AttDao;
import io.renren.modules.core.entity.AttEntity;
import io.renren.modules.core.service.AttService;



@Service("attService")
public class AttServiceImpl implements AttService {
	@Autowired
	private AttDao attDao;
	
	@Override
	public AttEntity queryObject(Long id){
		return attDao.queryObject(id);
	}
	
	@Override
	public List<AttEntity> queryList(Map<String, Object> map){
		return attDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return attDao.queryTotal(map);
	}
	
	@Override
	public void save(AttEntity att){
		attDao.save(att);
	}
	
	@Override
	public void update(AttEntity att){
		attDao.update(att);
	}
	
	@Override
	public void delete(Long id){
		attDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		attDao.deleteBatch(ids);
	}

	@Override
	public boolean isAtt(Long uid, Long attid){
        Map query = new HashMap<>();
        query.put("attid",attid);
        query.put("uid",uid);
        List<AttEntity> list = queryList(query);
		return list.size() > 0;
	}

    @Override
    public void unAtt(Long uid,Long attid){
        Map query = new HashMap<>();
        query.put("attid",attid);
        query.put("uid",uid);
        List<AttEntity> list = queryList(query);
        if (list.size() > 0){
            delete(list.get(0).getId());
        }
    }
	
}
