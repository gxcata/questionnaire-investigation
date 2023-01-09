package com.gxcata.questionnaireinvestigation.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wanghailun
 * @date 2022年12月27日 10:59
 */
@Data
public class LoginVO {
    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "手机号码(登录账号)")
    private String phoneNumber;

    @ApiModelProperty(value = "用户token")
    private String token;
}
