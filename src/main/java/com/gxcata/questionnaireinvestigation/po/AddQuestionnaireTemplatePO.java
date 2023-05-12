package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * @author wanghailun
 * @date 2023年05月12日 11:27
 */
@Data
public class AddQuestionnaireTemplatePO {

    @ApiModelProperty(value = "问卷id",hidden = true)
    private String questionnaireId;

    @ApiModelProperty(value = "问卷名称",required = true)
    @NotEmpty(message = "问卷名称不能为空")
    private String questionnaireName;

    @ApiModelProperty(value = "问卷头")
    private String questionnaireHead;

    @ApiModelProperty(value = "是否为模板（0：是，1：不是）",hidden = true)
    private Integer isTemplate;

    @ApiModelProperty(value = "创建时间",hidden = true)
    private Date createTime;

    @ApiModelProperty(value = "问题")
    private List<AddQuestionPO> list;
}
