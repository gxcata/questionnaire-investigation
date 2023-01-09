package com.gxcata.questionnaireinvestigation.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author wanghailun
 * @date 2022年12月31日 12:00
 */
@Data
public class QuestionnaireVO {

    @ApiModelProperty(value = "问卷id")
    private String questionnaireId;

    @ApiModelProperty(value = "问卷名称")
    private String questionnaireName;

    @ApiModelProperty(value = "单位id")
    private String companyId;
    @ApiModelProperty(value = "单位名称")
    private String companyName;

    @ApiModelProperty(value = "项目id")
    private String projectId;
    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "系统id")
    private String systemId;
    @ApiModelProperty(value = "系统名称")
    private String systemName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "生成状态code（已生成：10000301；未生成：10000302）")
    private String generateStatusCode;
    @ApiModelProperty(value = "生成状态name（已生成：10000301；未生成：10000302）")
    private String generateStatusName;

    @ApiModelProperty(value = "生成的url")
    private String generatedUrl;

}
