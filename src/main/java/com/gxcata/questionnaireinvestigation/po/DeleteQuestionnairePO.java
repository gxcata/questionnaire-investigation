package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wanghailun
 * @date 2023年01月04日 11:00
 */
@Data
public class DeleteQuestionnairePO {

    @ApiModelProperty(value = "问卷id",required = true)
    @NotEmpty(message = "问卷id不能为空")
    private String questionnaireId;

}
