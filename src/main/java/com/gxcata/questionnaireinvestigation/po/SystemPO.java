package com.gxcata.questionnaireinvestigation.po;

import com.gxcata.questionnaireinvestigation.common.web.controller.PageDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wanghailun
 * @date 2022年12月30日 9:47
 */
@Data
public class SystemPO extends PageDomain {

    @ApiModelProperty(value = "项目id",required = true)
    @NotEmpty(message = "项目id不能为空")
    private String projectId;

}
