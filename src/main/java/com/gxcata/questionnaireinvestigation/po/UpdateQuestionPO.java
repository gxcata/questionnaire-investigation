package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author wanghailun
 * @date 2023年01月03日 16:06
 */
@Data
public class UpdateQuestionPO {

    @ApiModelProperty(value = "问题id:修改时必传,新增时不传")
    private String questionId;

    @ApiModelProperty(value = "问题题目")
    private String questionTitle;

    @ApiModelProperty(value = "问题类型（多选：10000201；单选：10000202；问答：10000203）")
    private String questionTypeCode;

    @ApiModelProperty(value = "状态code(启用：10000401；停用：10000402)",required = true)
    @NotEmpty(message = "状态code不能为空")
    private String statusCode;

    @ApiModelProperty(value = "选项list")
    private List<UpdateOptionPO> list;

}
