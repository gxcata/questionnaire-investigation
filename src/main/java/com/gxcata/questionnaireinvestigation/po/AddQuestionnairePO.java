package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * @author wanghailun
 * @date 2022年12月31日 10:37
 */
@Data
public class AddQuestionnairePO {

    @ApiModelProperty(value = "问卷id",hidden = true)
    private String questionnaireId;

    @ApiModelProperty(value = "问卷名称",required = true)
    @NotEmpty(message = "问卷名称不能为空")
    private String questionnaireName;

    @ApiModelProperty(value = "单位id",required = true)
    @NotEmpty(message = "单位id不能为空")
    private String companyId;

    @ApiModelProperty(value = "项目id",required = true)
    @NotEmpty(message = "项目id不能为空")
    private String projectId;

    @ApiModelProperty(value = "系统id",required = true)
    @NotEmpty(message = "系统id不能为空")
    private String systemId;

    @ApiModelProperty(value = "创建时间",hidden = true)
    private Date createTime;

    @ApiModelProperty(value = "问题")
    private List<AddQuestionPO> list;
}
