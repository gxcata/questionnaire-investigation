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
@TableName("q_option")
public class QOption  implements Serializable {

	private static final long serialVersionUID =  3127105541750333429L;

	@ApiModelProperty(value = "答案选项id")
	@TableId
	private String optionId;

	@ApiModelProperty(value = "选项文案")
	private String optionValue;

	@ApiModelProperty(value = "问题id")
	private String questionId;

	@ApiModelProperty(value = "状态code(启用：10000401；停用：10000402)")
	private String statusCode;

}
