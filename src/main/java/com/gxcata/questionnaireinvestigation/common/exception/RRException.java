package com.gxcata.questionnaireinvestigation.common.exception;

import com.gxcata.questionnaireinvestigation.common.web.domain.ErrorCodeEnum;
import lombok.Data;

/**
 * 自定义异常
 *
 * @author wanghailun
 */
@Data
public class RRException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private String code = "500";
    
    public RRException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public RRException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public RRException(String msg, String code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public RRException(String msg, String code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public RRException(ErrorCodeEnum errorCodeEnum) {
		super(errorCodeEnum.getDes());
		this.msg = errorCodeEnum.getDes();
		this.code = String.valueOf( errorCodeEnum.getVal() );
	}

	public RRException(ErrorCodeEnum errorCodeEnum, String msg) {
		super(msg);
		this.msg = msg;
		this.code = String.valueOf( errorCodeEnum.getVal() );
	}

	/**
	* 不打印堆栈信息
	**/
	@Override
	public Throwable fillInStackTrace() {
		return this;
	}
	}
