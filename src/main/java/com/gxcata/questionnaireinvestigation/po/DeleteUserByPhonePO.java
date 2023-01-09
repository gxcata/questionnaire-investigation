package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wanghailun
 * @date 2022年12月29日 11:48
 */
@Data
public class DeleteUserByPhonePO {

    @ApiModelProperty(value = "手机号码(登录账号)",required = true)
    @NotEmpty(message = "手机号不能为空")
    private String phoneNumber;
}
