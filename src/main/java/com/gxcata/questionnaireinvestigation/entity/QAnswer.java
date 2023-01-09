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
@TableName("q_answer")
public class QAnswer  implements Serializable {

	private static final long serialVersionUID =  5986650590266603928L;

	@ApiModelProperty(value = "答案id")
	@TableId
	private String answerId;

	@ApiModelProperty(value = "答案值")
	private String answerValue;

	@ApiModelProperty(value = "答案选项id")
	private String optionId;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

}
