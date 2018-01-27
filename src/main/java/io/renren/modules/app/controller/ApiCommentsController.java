package io.renren.modules.app.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.modules.app.annotation.LoginUser;
import io.renren.modules.core.entity.CommentsEntity;
import io.renren.modules.core.entity.UserEntity;
import io.renren.modules.core.service.CommentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/app/comments")
@Api("评论操作接口")
public class ApiCommentsController {
	@Autowired
	private CommentsService commentsService;
	
	/**
	 * 列表
	 */
	@ApiOperation("评论列表")
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		Assert.isNull(query.get("cid"),"参数有误");
		List<CommentsEntity> commentsList = commentsService.queryList(query);
		int total = commentsService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(commentsList, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}

	/**
	 * 保存
	 */
	@ApiOperation("增加评论")
	@RequestMapping("/save")
	public R save(@LoginUser UserEntity user, @RequestBody CommentsEntity comments){
		comments.setOwnerId(user.getUserId());
	    commentsService.save(comments);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@ApiOperation("删除评论")
	@RequestMapping("/delete")
	public R delete(@LoginUser UserEntity user,Long coid){
		CommentsEntity comments = commentsService.queryObject(coid);
		if (comments.getAuthorId() != user.getUserId() && comments.getOwnerId() != user.getUserId()){
		    return R.error("无权限");
        }
        commentsService.delete(coid);
		return R.ok();
	}
	
}
