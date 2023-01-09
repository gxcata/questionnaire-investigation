package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wanghailun
 * @date 2022年12月29日 17:37
 */
@Data
public class DeleteProjectPO {

    @ApiModelProperty(value = "项目id",required = true)
    @NotEmpty(message = "项目id不能为空")
    private String projectId;

}
