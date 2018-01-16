package io.renren.modules.core.service.impl;

import io.renren.modules.core.entity.AttEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.renren.modules.core.dao.CollectDao;
import io.renren.modules.core.entity.CollectEntity;
import io.renren.modules.core.service.CollectService;



@Service("collectService")
public class CollectServiceImpl implements CollectService {
	@Autowired
	private CollectDao collectDao;
	
	@Override
	public CollectEntity queryObject(Long id){
		return collectDao.queryObject(id);
	}
	
	@Override
	public List<CollectEntity> queryList(Map<String, Object> map){
		return collectDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return collectDao.queryTotal(map);
	}
	
	@Override
	public void save(CollectEntity collect){
		collectDao.save(collect);
	}
	
	@Override
	public void update(CollectEntity collect){
		collectDao.update(collect);
	}
	
	@Override
	public void delete(Long id){
		collectDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		collectDao.deleteBatch(ids);
	}

	@Override
	public boolean isCollect(Long uid, Long tid){
		Map query = new HashMap<>();
		query.put("tid",tid);
		query.put("uid",uid);
		List<AttEntity> list = queryList(query);
		return list.size() > 0;
	}

    @Override
    public void unCollect(Long uid, Long tid){
        Map query = new HashMap<>();
        query.put("tid",tid);
        query.put("uid",uid);
        List<CollectEntity> list = queryList(query);
        if (list.size() > 0){
            delete(list.get(0).getId());
        }
    }
}
