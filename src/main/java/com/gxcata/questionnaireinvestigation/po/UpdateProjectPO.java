package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author wanghailun
 * @date 2022年12月29日 17:31
 */
@Data
public class UpdateProjectPO {

    @ApiModelProperty(value = "项目id",required = true)
    @NotEmpty(message = "项目id不能为空")
    private String projectId;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "修改时间",hidden = true)
    private Date updateTime;

}
