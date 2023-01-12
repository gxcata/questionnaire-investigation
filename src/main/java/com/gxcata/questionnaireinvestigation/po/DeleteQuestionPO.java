package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wanghailun
 * @date 2023年01月12日 11:48
 */
@Data
public class DeleteQuestionPO {

    @ApiModelProperty(value = "问题id",required = true)
    @NotEmpty(message = "问题id不能为空")
    private String questionId;

}
