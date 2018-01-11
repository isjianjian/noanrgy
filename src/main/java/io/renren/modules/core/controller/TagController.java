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

import io.renren.modules.core.entity.TagEntity;
import io.renren.modules.core.service.TagService;
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
@RequestMapping("/core/tag")
public class TagController {
	@Autowired
	private TagService tagService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("core:tag:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TagEntity> tagList = tagService.queryList(query);
		int total = tagService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tagList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("core:tag:info")
	public R info(@PathVariable("id") Long id){
		TagEntity tag = tagService.queryObject(id);
		
		return R.ok().put("tag", tag);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("core:tag:save")
	public R save(@RequestBody TagEntity tag){
		tagService.save(tag);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("core:tag:update")
	public R update(@RequestBody TagEntity tag){
		tagService.update(tag);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("core:tag:delete")
	public R delete(@RequestBody Long[] ids){
		tagService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
