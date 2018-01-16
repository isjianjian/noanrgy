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

import io.renren.modules.core.entity.AttEntity;
import io.renren.modules.core.service.AttService;
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
@RequestMapping("/core/att")
public class AttController {
	@Autowired
	private AttService attService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("core:att:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AttEntity> attList = attService.queryList(query);
		int total = attService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(attList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("core:att:info")
	public R info(@PathVariable("id") Long id){
		AttEntity att = attService.queryObject(id);
		
		return R.ok().put("att", att);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("core:att:save")
	public R save(@RequestBody AttEntity att){
		attService.save(att);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("core:att:update")
	public R update(@RequestBody AttEntity att){
		attService.update(att);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("core:att:delete")
	public R delete(@RequestBody Long[] ids){
		attService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
