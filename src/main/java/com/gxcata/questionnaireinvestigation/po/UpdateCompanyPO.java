package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author wanghailun
 * @date 2022年12月29日 16:42
 */
@Data
public class UpdateCompanyPO {

    @ApiModelProperty(value = "单位id")
    @NotEmpty(message = "单位id不能为空")
    private String companyId;

    @ApiModelProperty(value = "单位名称")
    private String companyName;

    @ApiModelProperty(value = "单位性质")
    private String companyNatureCode;

    @ApiModelProperty(value = "修改时间",hidden = true)
    private Date updateTime;
}
