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

import io.renren.modules.core.entity.ContentsEntity;
import io.renren.modules.core.service.ContentsService;
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
@RequestMapping("/core/contents")
public class ContentsController {
	@Autowired
	private ContentsService contentsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("core:contents:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ContentsEntity> contentsList = contentsService.queryList(query);
		int total = contentsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(contentsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{cid}")
	@RequiresPermissions("core:contents:info")
	public R info(@PathVariable("cid") Long cid){
		ContentsEntity contents = contentsService.queryObject(cid);
		
		return R.ok().put("contents", contents);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("core:contents:save")
	public R save(@RequestBody ContentsEntity contents){
		contentsService.save(contents);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("core:contents:update")
	public R update(@RequestBody ContentsEntity contents){
		contentsService.update(contents);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("core:contents:delete")
	public R delete(@RequestBody Long[] cids){
		contentsService.deleteBatch(cids);
		
		return R.ok();
	}
	
}
