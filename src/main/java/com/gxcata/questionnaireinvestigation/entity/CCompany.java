package com.gxcata.questionnaireinvestigation.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * @Description  
 * @Author  wanghailun
 * @Date 2022-12-29 
 */

@Data
@TableName("c_company")
public class CCompany  implements Serializable {

	private static final long serialVersionUID =  6398004746978477501L;

	@ApiModelProperty(value = "单位id")
	@TableId
	private String companyId;

	@ApiModelProperty(value = "单位名称")
	private String companyName;

	@ApiModelProperty(value = "单位性质")
	private String companyNatureCode;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "修改时间")
	private Date updateTime;

}
