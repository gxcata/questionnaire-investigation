package com.gxcata.questionnaireinvestigation.po;

import com.gxcata.questionnaireinvestigation.common.web.controller.PageDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wanghailun
 * @date 2022年12月30日 16:37
 */
@Data
public class CompanyPO extends PageDomain {

    @ApiModelProperty(value = "单位名称")
    private String companyName;

}
