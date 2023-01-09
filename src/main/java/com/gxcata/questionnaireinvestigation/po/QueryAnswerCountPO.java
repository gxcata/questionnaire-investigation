package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wanghailun
 * @date 2023年01月09日 9:54
 */
@Data
public class QueryAnswerCountPO {

    @ApiModelProperty(value = "答案值")
    private String answerValue;

    @ApiModelProperty(value = "答案选项id")
    private String optionId;

}
