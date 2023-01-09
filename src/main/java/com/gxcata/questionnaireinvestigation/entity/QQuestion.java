package com.gxcata.questionnaireinvestigation.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @Description  
 * @Author  wanghailun
 * @Date 2022-12-31 
 */

@Data
@TableName("q_question")
public class QQuestion  implements Serializable {

	private static final long serialVersionUID =  2094079160616200551L;

	@ApiModelProperty(value = "问题id")
	@TableId
	private String questionId;

	@ApiModelProperty(value = "问题题目")
	private String questionTitle;

	@ApiModelProperty(value = "问题类型（多选：10000201；单选：10000202；问答：10000203）")
	private String questionTypeCode;

	@ApiModelProperty(value = "问卷id")
	private String questionnaireId;

	@ApiModelProperty(value = "状态code(启用：10000401；停用：10000402)")
	private String statusCode;
}
