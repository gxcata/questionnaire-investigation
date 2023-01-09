package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author wanghailun
 * @date 2022年12月29日 11:33
 */
@Data
public class UpdateUserByPhonePO {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "手机号码(登录账号)",required = true)
    @NotEmpty(message = "手机号不能为空")
    private String phoneNumber;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "盐",hidden = true)
    private String salt;

    @ApiModelProperty(value = "修改时间",hidden = true)
    private Date updateTime;

}
