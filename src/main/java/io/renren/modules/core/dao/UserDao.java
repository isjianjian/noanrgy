package io.renren.modules.core.dao;

import io.renren.modules.core.entity.UserEntity;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-10 18:35:57
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {
	UserEntity login(String account);
}
