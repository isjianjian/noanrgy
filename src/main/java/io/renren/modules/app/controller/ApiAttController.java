package io.renren.modules.app.controller;

import io.renren.common.utils.DateUtils;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.app.annotation.LoginUser;
import io.renren.modules.core.entity.AttEntity;
import io.renren.modules.core.entity.UserEntity;
import io.renren.modules.core.service.AttService;
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
 * @date 2018-01-12 15:44:04
 */
@RestController
@RequestMapping("/app/att")
@Api("关注接口")
public class ApiAttController {
	@Autowired
	private AttService attService;
	
	/**
	 * 列表
	 */
    @ApiOperation("关注列表")
	@RequestMapping("/list")
	public R list(@LoginUser UserEntity user,@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		query.put("uid",user.getUserId());
		List<AttEntity> attList = attService.queryList(query);
		int total = attService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(attList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
    @ApiOperation("关注详细")
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		AttEntity att = attService.queryObject(id);
		
		return R.ok().put("att", att);
	}
	
	/**
	 * 保存
	 */
    @ApiOperation("关注")
	@RequestMapping("/att")
	public R save(@LoginUser UserEntity user,Long uid){
		if (attService.isAtt(user.getUserId(),uid)){
			return R.error("已关注");
		}
		AttEntity att = new AttEntity();
		att.setCreated(DateUtils.nowUnix());
		att.setAttUid(uid);
		att.setUid(user.getUserId());
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ApiOperation("取消关注")
    @RequestMapping("/unatt")
    public R unatt(@LoginUser UserEntity user,Long uid){
        attService.unAtt(user.getUserId(),uid);
        return R.ok();
    }

	
}
