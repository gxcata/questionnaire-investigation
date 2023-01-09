package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author wanghailun
 * @date 2022年12月30日 9:33
 */
@Data
public class AddSystemPO {

    @ApiModelProperty(value = "系统id",hidden = true)
    private String systemId;

    @ApiModelProperty(value = "系统名称",required = true)
    @NotEmpty(message = "系统名称不能为空")
    private String systemName;

    @ApiModelProperty(value = "公司id",required = true)
    @NotEmpty(message = "公司id不能为空")
    private String companyId;

    @ApiModelProperty(value = "项目id",required = true)
    @NotEmpty(message = "项目id不能为空")
    private String projectId;

    @ApiModelProperty(value = "创建时间",hidden = true)
    private Date createTime;

}
