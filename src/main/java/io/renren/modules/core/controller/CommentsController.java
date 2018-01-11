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

import io.renren.modules.core.entity.CommentsEntity;
import io.renren.modules.core.service.CommentsService;
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
@RequestMapping("/core/comments")
public class CommentsController {
	@Autowired
	private CommentsService commentsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("core:comments:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CommentsEntity> commentsList = commentsService.queryList(query);
		int total = commentsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(commentsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{coid}")
	@RequiresPermissions("core:comments:info")
	public R info(@PathVariable("coid") Long coid){
		CommentsEntity comments = commentsService.queryObject(coid);
		
		return R.ok().put("comments", comments);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("core:comments:save")
	public R save(@RequestBody CommentsEntity comments){
		commentsService.save(comments);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("core:comments:update")
	public R update(@RequestBody CommentsEntity comments){
		commentsService.update(comments);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("core:comments:delete")
	public R delete(@RequestBody Long[] coids){
		commentsService.deleteBatch(coids);
		
		return R.ok();
	}
	
}
