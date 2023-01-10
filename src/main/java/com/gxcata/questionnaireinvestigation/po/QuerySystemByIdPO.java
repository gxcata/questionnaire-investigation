package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wanghailun
 * @date 2023年01月10日 16:37
 */
@Data
public class QuerySystemByIdPO {

    @ApiModelProperty(value = "系统id",required = true)
    @NotEmpty(message = "系统id不能为空")
    private String systemId;
}
