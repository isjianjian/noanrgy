package io.renren.modules.app.controller;

import io.renren.common.exception.RRException;
import io.renren.common.utils.Constant;
import io.renren.common.utils.ContentsUtil;
import io.renren.common.utils.R;
import io.renren.common.utils.Types;
import io.renren.common.validator.Assert;
import io.renren.modules.app.annotation.LoginUser;
import io.renren.modules.core.entity.ContentsEntity;
import io.renren.modules.core.entity.UserEntity;
import io.renren.modules.core.service.ContentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app/contents")
@Api("文章操作接口")
public class ApiContentsController {
    @Autowired
    ContentsService contentsService;


    @GetMapping("show")
    @ApiOperation("显示文章")
    public R show(Long cid){
        Assert.isNull(cid,"输入文章id");
        ContentsEntity contents = contentsService.queryObject(cid);
        contents.setContent(ContentsUtil.mdToHtml(contents.getContent()));
        if (contents == null || !contents.getStatus().equals(Types.PUBLISH) ){
            return R.error(404,"未找到");
        }
        return R.ok().put("data",contents);
    }


    @GetMapping("edit")
    @ApiOperation("编辑文章")
    public R edit(@LoginUser UserEntity user,Long cid){
        Assert.isNull(user,"请登录");
        ContentsEntity contents = contentsService.queryObject(cid);
        if (user.getUserId() != contents.getAuthorId()){
            return R.error("非作者不能编辑");
        }
        return R.ok().put("data",contents);
    }

    @GetMapping("publish")
    @ApiOperation("发布文章")
    public R publish(@LoginUser UserEntity user,ContentsEntity contents){
        Assert.isNull(user,"请登录后发布文章");
        contents.setType(Types.PAGE);
        contents.setAllowPing(Types.TRUE);
        contents.setAuthorId(user.getUserId());
        contents.setStatus(Types.PUBLISH);
        contentsService.save(contents);
        return R.ok();
    }

    @GetMapping("update")
    @ApiOperation("更新文章")
    public R update(@LoginUser UserEntity user,ContentsEntity contents){
        Assert.isNull(user,"请登录后发布文章");
        contentsService.update(contents);
        return R.ok();
    }


}
