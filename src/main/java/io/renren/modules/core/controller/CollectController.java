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

import io.renren.modules.core.entity.CollectEntity;
import io.renren.modules.core.service.CollectService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-12 15:44:04
 */
@RestController
@RequestMapping("/core/collect")
public class CollectController {
	@Autowired
	private CollectService collectService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("core:collect:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CollectEntity> collectList = collectService.queryList(query);
		int total = collectService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(collectList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("core:collect:info")
	public R info(@PathVariable("id") Long id){
		CollectEntity collect = collectService.queryObject(id);
		
		return R.ok().put("collect", collect);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("core:collect:save")
	public R save(@RequestBody CollectEntity collect){
		collectService.save(collect);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("core:collect:update")
	public R update(@RequestBody CollectEntity collect){
		collectService.update(collect);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("core:collect:delete")
	public R delete(@RequestBody Long[] ids){
		collectService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
