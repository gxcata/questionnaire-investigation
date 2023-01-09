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
@TableName("p_project")
public class PProject  implements Serializable {

	private static final long serialVersionUID =  4642230818094196901L;

	@ApiModelProperty(value = "项目id")
	@TableId
	private String projectId;

	@ApiModelProperty(value = "项目名称")
	private String projectName;

	@ApiModelProperty(value = "单位id")
	private String companyId;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "修改时间")
	private Date updateTime;

}
