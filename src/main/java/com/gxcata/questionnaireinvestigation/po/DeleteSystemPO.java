package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wanghailun
 * @date 2022年12月30日 10:09
 */
@Data
public class DeleteSystemPO {

    @ApiModelProperty(value = "系统id",required = true)
    @NotEmpty(message = "系统id不能为空")
    private String systemId;

}
