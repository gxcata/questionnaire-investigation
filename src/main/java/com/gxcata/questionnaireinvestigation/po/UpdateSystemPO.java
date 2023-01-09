package com.gxcata.questionnaireinvestigation.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author wanghailun
 * @date 2022年12月30日 9:56
 */
@Data
public class UpdateSystemPO {

    @ApiModelProperty(value = "系统id",required = true)
    @NotEmpty(message = "系统id不能为空")
    private String systemId;

    @ApiModelProperty(value = "系统名称")
    private String systemName;

    @ApiModelProperty(value = "修改时间",hidden = true)
    private Date updateTime;

}
