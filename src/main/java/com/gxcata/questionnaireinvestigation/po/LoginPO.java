package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wanghailun
 * @date 2022年12月27日 10:57
 */
@Data
public class LoginPO {

    @ApiModelProperty(value = "手机号码(登录账号)")
    @NotEmpty(message = "账号不能为空！")
    private String phoneNumber;

    @ApiModelProperty(value = "登录密码")
    @NotEmpty(message = "密码不能为空！")
    private String password;

}
