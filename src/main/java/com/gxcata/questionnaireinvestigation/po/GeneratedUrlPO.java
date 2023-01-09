package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author wanghailun
 * @date 2023年01月04日 14:44
 */
@Data
public class GeneratedUrlPO {

    @ApiModelProperty(value = "问卷id",required = true)
    @NotEmpty(message = "问卷id不能为空")
    private String questionnaireId;

    @ApiModelProperty(value = "生成的url",required = true)
    @NotEmpty(message = "生成的url不能为空")
    private String generatedUrl;

    @ApiModelProperty(value = "生成状态code",hidden = true)
    private String generateStatusCode;

    @ApiModelProperty(value = "修改时间",hidden = true)
    private Date updateTime;

}
