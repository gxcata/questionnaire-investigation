package com.gxcata.questionnaireinvestigation.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author wanghailun
 * @date 2023年01月04日 15:21
 */
@Data
public class StatisticsQuestionnaireVO {

    @ApiModelProperty(value = "问卷id")
    private String questionnaireId;

    @ApiModelProperty(value = "问卷统计list")
    private List<StatisticsAnswerVO> list;

}
