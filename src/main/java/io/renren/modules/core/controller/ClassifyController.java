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

import io.renren.modules.core.entity.ClassifyEntity;
import io.renren.modules.core.service.ClassifyService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 
 * 
 * @author wz
 * @email 798378318@qq.com
 * @date 2018-01-10 18:35:50
 */
@RestController
@RequestMapping("/core/classify")
public class ClassifyController {
	@Autowired
	private ClassifyService classifyService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("core:classify:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ClassifyEntity> classifyList = classifyService.queryList(query);
		int total = classifyService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(classifyList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("core:classify:info")
	public R info(@PathVariable("id") Long id){
		ClassifyEntity classify = classifyService.queryObject(id);
		
		return R.ok().put("classify", classify);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("core:classify:save")
	public R save(@RequestBody ClassifyEntity classify){
		classifyService.save(classify);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("core:classify:update")
	public R update(@RequestBody ClassifyEntity classify){
		classifyService.update(classify);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("core:classify:delete")
	public R delete(@RequestBody Long[] ids){
		classifyService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
