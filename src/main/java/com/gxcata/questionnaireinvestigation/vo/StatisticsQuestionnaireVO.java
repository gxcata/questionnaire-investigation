package com.gxcata.questionnaireinvestigation.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author wanghailun
 * @date 2023年01月04日 15:21
 */
@Data
public class StatisticsQuestionnaireVO {

    @ApiModelProperty(value = "问卷id")
    private String questionnaireId;

    @ApiModelProperty(value = "问卷名称")
    private String questionnaireName;

    @ApiModelProperty(value = "问题list")
    private List<StatisticsQuestionVO> list;

}
