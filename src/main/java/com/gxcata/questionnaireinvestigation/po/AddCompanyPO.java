package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author wanghailun
 * @date 2022年12月29日 15:18
 */
@Data
public class AddCompanyPO {
    @ApiModelProperty(value = "单位id",hidden = true)
    private String companyId;

    @ApiModelProperty(value = "单位名称",required = true)
    private String companyName;

    @ApiModelProperty(value = "单位性质（政府部门：10000101；国资企业：10000102；科研机构：10000103；" +
            "医疗机构：10000104；金融机构：10000105；权力机构：10000106；" +
            "民营企业：10000107；其他客户：10000108）",required = true)
    private String companyNatureCode;

    @ApiModelProperty(value = "创建时间",hidden = true)
    private Date createTime;
}
