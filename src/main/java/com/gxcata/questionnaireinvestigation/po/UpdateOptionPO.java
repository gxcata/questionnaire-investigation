package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wanghailun
 * @date 2023年01月03日 16:12
 */
@Data
public class UpdateOptionPO {

    @ApiModelProperty(value = "答案选项id")
    private String optionId;

    @ApiModelProperty(value = "选项文案")
    private String optionValue;

    @ApiModelProperty(value = "问题id")
    private String questionId;

    @ApiModelProperty(value = "状态code(启用：10000401；停用：10000402)",required = true)
    @NotEmpty(message = "状态code不能为空")
    private String statusCode;
}
