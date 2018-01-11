package io.renren.modules.core.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.core.entity.UserTokenEntity;
import io.renren.modules.core.service.UserTokenService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 用户Token
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-10 18:35:49
 */
@RestController
@RequestMapping("/core/usertoken")
public class UserTokenController {
	@Autowired
	private UserTokenService userTokenService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("core:usertoken:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<UserTokenEntity> userTokenList = userTokenService.queryList(query);
		int total = userTokenService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userTokenList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("core:usertoken:info")
	public R info(@PathVariable("userId") Long userId){
		UserTokenEntity userToken = userTokenService.queryObject(userId);
		
		return R.ok().put("userToken", userToken);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("core:usertoken:save")
	public R save(@RequestBody UserTokenEntity userToken){
		userTokenService.save(userToken);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("core:usertoken:update")
	public R update(@RequestBody UserTokenEntity userToken){
		userTokenService.update(userToken);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("core:usertoken:delete")
	public R delete(@RequestBody Long[] userIds){
		userTokenService.deleteBatch(userIds);
		
		return R.ok();
	}
	
}
