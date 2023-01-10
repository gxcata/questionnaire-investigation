package com.gxcata.questionnaireinvestigation.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wanghailun
 * @date 2023年01月10日 9:38
 */
@Data
public class StatisticsOptionVO {

    @ApiModelProperty(value = "选项id")
    private String optionId;

    @ApiModelProperty(value = "选项文案")
    private String optionValue;

    @ApiModelProperty(value = "选择数量")
    private Integer answerCount;
}
