package com.zr.ttappdemo.commons.exception;

import com.zr.ttappdemo.commons.util.ResultEnum;

/**
 * @author yuyi
 * @description 通用业务 Exception类  RuntimeException 会进行事务回滚 但是Exception不会
 * @date 16:38 2018/10/25
 */
public class ServiceException extends RuntimeException {
 
private static final long serialVersionUID = 1L;
	
	private final Integer code;
 
	public Integer getCode() {
		return code;
	}
 
	public ServiceException(Integer code, String message) {
		super(message);
		this.code = code;
	}
	
	/***
	 * 自定义错误类
	 * @param resultEnum
	 */
	public ServiceException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
}
