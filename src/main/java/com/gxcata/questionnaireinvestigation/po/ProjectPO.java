package com.gxcata.questionnaireinvestigation.po;

import com.gxcata.questionnaireinvestigation.common.web.controller.PageDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wanghailun
 * @date 2022年12月29日 17:26
 */
@Data
public class ProjectPO extends PageDomain {

    @ApiModelProperty(value = "单位id",required = true)
    @NotEmpty(message = "单位id不能为空")
    private String companyId;
}
