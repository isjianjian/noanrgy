package io.renren.modules.core.dao;

import io.renren.modules.core.entity.ContentsEntity;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-10 18:35:50
 */
@Mapper
public interface ContentsDao extends BaseDao<ContentsEntity> {
    List<ContentsEntity> search(Map<String, Object> map);
    int searchTotal(Map<String, Object> map);
}
