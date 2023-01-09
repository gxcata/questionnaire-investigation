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
 * @Date 2022-12-27 
 */

@Data
@TableName("c_user")
public class CUser  implements Serializable {

	private static final long serialVersionUID =  6459449157247898198L;

	@ApiModelProperty(value = "用户id")
	@TableId
	private String userId;

	@ApiModelProperty(value = "用户名")
	private String userName;

	@ApiModelProperty(value = "手机号码(登录账号)")
	private String phoneNumber;

	@ApiModelProperty(value = "登录密码")
	private String password;

	@ApiModelProperty(value = "盐")
	private String salt;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "修改时间")
	private Date updateTime;

}
