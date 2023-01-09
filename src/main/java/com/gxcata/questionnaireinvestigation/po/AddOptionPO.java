package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wanghailun
 * @date 2022年12月31日 12:52
 */
@Data
public class AddOptionPO {

    @ApiModelProperty(value = "答案选项id",hidden = true)
    private String optionId;

    @ApiModelProperty(value = "选项文案",required = true)
    @NotEmpty(message = "选项文案不能为空")
    private String optionValue;

    @ApiModelProperty(value = "问题id",hidden = true)
    private String questionId;

    @ApiModelProperty(value = "状态类型",hidden = true)
    private String statusCode;

}
