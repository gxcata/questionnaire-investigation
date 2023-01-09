package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wanghailun
 * @date 2022年12月29日 16:50
 */
@Data
public class DeleteCompanyPO {

    @ApiModelProperty(value = "单位id",required = true)
    @NotEmpty(message = "单位id不能为空")
    private String companyId;

}
