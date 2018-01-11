package io.renren.modules.core.dao;

import io.renren.modules.core.entity.UserTokenEntity;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Token
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-10 18:35:49
 */
@Mapper
public interface UserTokenDao extends BaseDao<UserTokenEntity> {
	
}
