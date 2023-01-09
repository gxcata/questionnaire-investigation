package com.gxcata.questionnaireinvestigation.controller;

import com.gxcata.questionnaireinvestigation.common.jwt.UserLoginToken;
import com.gxcata.questionnaireinvestigation.common.web.domain.Result;
import com.gxcata.questionnaireinvestigation.entity.CUser;
import com.gxcata.questionnaireinvestigation.po.DeleteUserByPhonePO;
import com.gxcata.questionnaireinvestigation.po.LoginPO;
import com.gxcata.questionnaireinvestigation.po.RegisterPO;
import com.gxcata.questionnaireinvestigation.po.UpdateUserByPhonePO;
import com.gxcata.questionnaireinvestigation.service.UserService;
import com.gxcata.questionnaireinvestigation.vo.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author wanghailun
 * @date 2022年12月27日 16:09
 */
@RestController
@RequestMapping("/user")
@Api(value = "/user", tags = "用户管理")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "注册")
    public Result<Boolean> register(@RequestBody @Valid RegisterPO registerPO) {
        return Result.ok(userService.register(registerPO));
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public Result<LoginVO> login(@RequestBody @Valid LoginPO loginPO, HttpServletResponse servletResponse) {
        return Result.ok(userService.login(loginPO,servletResponse));
    }

    @UserLoginToken
    @PostMapping("/queryUserByPhone")
    @ApiOperation(value = "根据账户查询用户信息")
    public Result<CUser> queryUserByPhone(String phone) {
        return Result.ok(userService.queryUserByPhone(phone));
    }

    @UserLoginToken
    @PostMapping("/updateUserByPhone")
    @ApiOperation(value = "根据手机号码修改用户信息")
    public Result<Boolean> updateUserByPhone(@RequestBody @Valid UpdateUserByPhonePO updateUserByPhonePO) {
        return Result.ok(userService.updateUserByPhone(updateUserByPhonePO));
    }

    @UserLoginToken
    @PostMapping("/deleteUserByPhone")
    @ApiOperation(value = "根据手机号码删除用户")
    public Result<Boolean> deleteUserByPhone(@RequestBody @Valid DeleteUserByPhonePO deleteUserByPhonePO) {
        return Result.ok(userService.deleteUserByPhone(deleteUserByPhonePO));
    }

    /*@UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }*/

}
