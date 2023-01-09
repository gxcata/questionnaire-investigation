package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * @author wanghailun
 * @date 2023年01月03日 16:01
 */
@Data
public class UpdateQuestionnairePO {

    @ApiModelProperty(value = "问卷id",required = true)
    @NotEmpty(message = "问卷id不能为空")
    private String questionnaireId;

    @ApiModelProperty(value = "单位id")
    private String companyId;

    @ApiModelProperty(value = "项目id")
    private String projectId;

    @ApiModelProperty(value = "系统id")
    private String systemId;

    @ApiModelProperty(value = "问卷名称")
    private String questionnaireName;

    @ApiModelProperty(value = "修改时间",hidden = true)
    private Date updateTime;

    @ApiModelProperty(value = "问题list")
    private List<UpdateQuestionPO> list;

}
