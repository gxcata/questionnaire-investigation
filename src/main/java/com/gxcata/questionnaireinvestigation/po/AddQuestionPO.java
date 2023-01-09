package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月31日 10:40
 */
@Data
public class AddQuestionPO {

    @ApiModelProperty(value = "问题id",hidden = true)
    private String questionId;

    @ApiModelProperty(value = "问题题目",required = true)
    @NotEmpty(message = "问题题目不能为空")
    private String questionTitle;

    @ApiModelProperty(value = "问题类型（多选：10000201；单选：10000202；问答：10000203）",required = true)
    @NotEmpty(message = "问题类型不能为空")
    private String questionTypeCode;

    @ApiModelProperty(value = "问卷id",hidden = true)
    private String questionnaireId;

    @ApiModelProperty(value = "状态类型",hidden = true)
    private String statusCode;

    @ApiModelProperty(value = "问题选项")
    private List<AddOptionPO> list;
}
