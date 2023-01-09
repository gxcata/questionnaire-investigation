package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author wanghailun
 * @date 2022年12月29日 17:14
 */
@Data
public class AddProjectPO {

    @ApiModelProperty(value = "项目id",hidden = true)
    private String projectId;

    @ApiModelProperty(value = "项目名称",required = true)
    @NotEmpty(message = "项目名称不能为空")
    private String projectName;

    @ApiModelProperty(value = "单位id",required = true)
    @NotEmpty(message = "单位id不能为空")
    private String companyId;

    @ApiModelProperty(value = "创建时间",hidden = true)
    private Date createTime;
}
