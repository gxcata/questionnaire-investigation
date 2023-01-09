package com.gxcata.questionnaireinvestigation.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author wanghailun
 * @date 2023年01月03日 17:38
 */
@Data
public class QuestionVO {

    @ApiModelProperty(value = "问题id")
    private String questionId;

    @ApiModelProperty(value = "问题题目")
    private String questionTitle;

    @ApiModelProperty(value = "问题类型code（多选：10000201；单选：10000202；问答：10000203）")
    private String questionTypeCode;
    @ApiModelProperty(value = "问题类型name（多选：10000201；单选：10000202；问答：10000203）")
    private String questionTypeName;

    @ApiModelProperty(value = "问卷id")
    private String questionnaireId;

    @ApiModelProperty(value = "选项list")
    private List<OptionVO> list;

}
