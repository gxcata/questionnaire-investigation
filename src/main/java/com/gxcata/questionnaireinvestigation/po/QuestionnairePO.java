package com.gxcata.questionnaireinvestigation.po;

import com.gxcata.questionnaireinvestigation.common.web.controller.PageDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author wanghailun
 * @date 2023年01月03日 14:56
 */
@Data
public class QuestionnairePO extends PageDomain {

    @ApiModelProperty(value = "问卷名称")
    private String questionnaireName;

    @ApiModelProperty(value = "单位名称")
    private String companyName;

    @ApiModelProperty(value = "生成状态code（已生成：10000301；未生成：10000302）",required = true)
    @NotEmpty(message = "生成状态code不能为空")
    private String generateStatusCode;

    @ApiModelProperty(value = "是否为模板（0：是，1：不是）",required = true)
    @NotNull(message = "isTemplate不能为空！")
    private Integer isTemplate;

}
