package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author wanghailun
 * @date 2023年01月04日 15:00
 */
@Data
public class WriteQuestionnairePO {

    @ApiModelProperty(value = "答案id",hidden = true)
    private String answerId;

    @ApiModelProperty(value = "答案值",required = true)
    @NotEmpty(message = "答案选项id不能为空")
    private String answerValue;

    @ApiModelProperty(value = "答案选项id",required = true)
    @NotEmpty(message = "答案选项id不能为空")
    private String optionId;

    @ApiModelProperty(value = "创建时间",hidden = true)
    private Date createTime;

}
