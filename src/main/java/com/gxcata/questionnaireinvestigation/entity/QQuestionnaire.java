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
 * @Date 2022-12-31 
 */

@Data
@TableName("q_questionnaire")
public class QQuestionnaire  implements Serializable {

	private static final long serialVersionUID =  1058140130990294190L;

	@ApiModelProperty(value = "问卷id")
	@TableId
	private String questionnaireId;

	@ApiModelProperty(value = "问卷名称")
	private String questionnaireName;

	@ApiModelProperty(value = "单位id")
	private String companyId;

	@ApiModelProperty(value = "项目id")
	private String projectId;

	@ApiModelProperty(value = "系统id")
	private String systemId;

	@ApiModelProperty(value = "生成状态code（已生成：10000301；未生成：10000302）")
	private String generateStatusCode;

	@ApiModelProperty(value = "生成的url")
	private String generatedUrl;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "修改时间")
	private Date updateTime;

}
