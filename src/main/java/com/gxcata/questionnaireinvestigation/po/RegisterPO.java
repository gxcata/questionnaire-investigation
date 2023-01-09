package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wanghailun
 * @date 2022年12月28日 15:21
 */
@Data
public class RegisterPO {

    @ApiModelProperty(value = "用户名")
    @NotEmpty(message = "用户名不能为空！")
    private String userName;

    @ApiModelProperty(value = "手机号码(登录账号)")
    @NotEmpty(message = "账号不能为空！")
    private String phoneNumber;

    @ApiModelProperty(value = "登录密码")
    @NotEmpty(message = "密码不能为空！")
    private String password;
}
