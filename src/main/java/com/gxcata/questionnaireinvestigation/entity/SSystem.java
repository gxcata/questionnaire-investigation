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
@TableName("s_system")
public class SSystem  implements Serializable {

	private static final long serialVersionUID =  6027251103190126698L;

	@ApiModelProperty(value = "系统id")
	@TableId
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
