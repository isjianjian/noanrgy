package io.renren.modules.app.controller;

import io.renren.common.utils.DateUtils;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.app.annotation.LoginUser;
import io.renren.modules.core.entity.CollectEntity;
import io.renren.modules.core.entity.UserEntity;
import io.renren.modules.core.service.CollectService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-12 15:44:04
 */
@RestController
@RequestMapping("/app/collect")
@Api("收藏接口")
public class ApiCollectController {
	@Autowired
	private CollectService collectService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@LoginUser UserEntity user,@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		query.put("uid",user.getUserId());
		List<CollectEntity> collectList = collectService.queryList(query);
		int total = collectService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(collectList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		CollectEntity collect = collectService.queryObject(id);
		
		return R.ok().put("collect", collect);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/collect")
	public R save(@LoginUser UserEntity user,Long tid){
		if (collectService.isCollect(user.getUserId(),tid)){
			return R.error("已收藏");
		}
		CollectEntity collect = new CollectEntity();
		collect.setCreated(DateUtils.nowUnix());
		collect.setTags(tid);
		collect.setUid(user.getUserId());
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/uncollect")
	public R delete(@LoginUser UserEntity user,@RequestBody Long tid){
		collectService.unCollect(user.getUserId(),tid);
		return R.ok();
	}
	
}
