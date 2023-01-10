package com.gxcata.questionnaireinvestigation.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author wanghailun
 * @date 2023年01月10日 16:39
 */
@Data
public class QuerySystemByIdVO {

    @ApiModelProperty(value = "系统id")
    private String systemId;

    @ApiModelProperty(value = "系统名称")
    private String systemName;

    @ApiModelProperty(value = "公司id")
    private String companyId;

    @ApiModelProperty(value = "项目id")
    private String projectId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
}
