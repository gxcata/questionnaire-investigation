package com.gxcata.questionnaireinvestigation.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wanghailun
 * @date 2023年01月03日 17:41
 */
@Data
public class OptionVO {

    @ApiModelProperty(value = "答案选项id")
    private String optionId;

    @ApiModelProperty(value = "选项文案")
    private String optionValue;

    @ApiModelProperty(value = "问题id")
    private String questionId;

}
