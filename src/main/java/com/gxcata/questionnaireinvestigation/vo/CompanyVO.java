package com.gxcata.questionnaireinvestigation.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author wanghailun
 * @date 2022年12月29日 16:24
 */
@Data
public class CompanyVO {
    @ApiModelProperty(value = "单位id")
    private String companyId;

    @ApiModelProperty(value = "单位名称")
    private String companyName;

    @ApiModelProperty(value = "单位性质code")
    private String companyNatureCode;
    @ApiModelProperty(value = "单位性质name")
    private String companyNatureName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
