package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


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

    @ApiModelProperty(value = "问题id",hidden = true)
    private String questionId;

    @ApiModelProperty(value = "状态code(启用：10000401；停用：10000402)",hidden = true)
    private String statusCode;
}
