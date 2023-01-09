package com.gxcata.questionnaireinvestigation.common.app;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author  wanghailun
 * @Date 2022-6-23
 */

@Data
@TableName("app_config")
public class AppConfig implements Serializable {

	private static final long serialVersionUID =  8899854007195333433L;

	@ApiModelProperty(value = "主键")
	private String key;

	@ApiModelProperty(value = "值")
	private String value;

	@ApiModelProperty(value = "描述")
	private String des;

	@ApiModelProperty(value = "模块")
	private String module;

	@ApiModelProperty(value = "类型")
	private String type;

}
