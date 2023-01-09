package com.gxcata.questionnaireinvestigation.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wanghailun
 * @date 2023年01月04日 15:47
 */
@Data
public class StatisticsAnswerVO {

    @ApiModelProperty(value = "问题id")
    private String questionId;
    @ApiModelProperty(value = "问题题目")
    private String questionTitle;

    @ApiModelProperty(value = "选项id")
    private String optionId;
    @ApiModelProperty(value = "选项文案")
    private String optionValue;

    @ApiModelProperty(value = "答案数量")
    private Long answerCount;

}
