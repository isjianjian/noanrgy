package io.renren.modules.app.controller;

import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.modules.core.entity.UserEntity;
import io.renren.modules.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/app")
@Api("APP注册接口")
public class ApiRegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(String email, String password){
        Assert.isBlank(email, "手机号或邮箱不能为空");
        Assert.isBlank(password, "密码不能为空");
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setPassword(password);
        userService.save(user);
        return R.ok();
    }
}
