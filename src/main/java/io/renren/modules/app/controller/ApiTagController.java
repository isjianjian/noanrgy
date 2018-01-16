package io.renren.modules.app.controller;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.app.annotation.LoginUser;
import io.renren.modules.core.entity.TagEntity;
import io.renren.modules.core.entity.UserEntity;
import io.renren.modules.core.service.TagService;
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
 * @date 2018-01-10 18:35:50
 */
@RestController
@RequestMapping("/core/tag")
public class ApiTagController {
	@Autowired
	private TagService tagService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@LoginUser UserEntity user,@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        query.put("uid",user.getUserId());
		List<TagEntity> tagList = tagService.queryList(query);

		int total = tagService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(tagList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		TagEntity tag = tagService.queryObject(id);
		return R.ok().put("tag", tag);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody TagEntity tag){
		tagService.save(tag);
		return R.ok();
	}


}
