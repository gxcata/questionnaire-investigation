package com.gxcata.questionnaireinvestigation.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author wanghailun
 * @date 2023年01月10日 9:37
 */
@Data
public class StatisticsQuestionVO {

    @ApiModelProperty(value = "问题id")
    private String questionId;

    @ApiModelProperty(value = "问题题目")
    private String questionTitle;

    @ApiModelProperty(value = "问题题目")
    private List<StatisticsOptionVO> list;

}
