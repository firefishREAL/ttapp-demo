package com.zr.ttappdemo.commons.util;

/**
 * @author yuyi
 * @description 响应信息枚举
 * @date 17:11 2018/10/25
 */

public enum ResultEnum {
	SUCCESS(0, "成功"),
 
	SAVE_ERROR(1, "保存失败!"),
 
	SMS_ERROR(3, "短信错误!"),
 
	SMS_TIMED_OUT_ERROR(4, "短信超时或验证码失效!"),
 
	SMS_VERIFY_ERROR(5, "验证码错误!"),
 
	EXISTED_USER(6, "该用户已存在!"),
 
	DELETE_ERROR(10, "删除失败"),

	NODATA(11, "查询成功无记录"),

	SELECT_ERROR(12, "查询失败"),

	ACCOUNT_ERROR(13, "账户不存在或被禁用"),

	API_NOT_EXISTS(14, "请求的接口不存在"),

	API_NOT_PER(15, "没有该接口的访问权限"),

	PARAMS_ERROR(16, "参数为空或格式错误"),

	SIGN_ERROR(17, "数据签名错误"),

	API_DISABLE(18, "查询权限已被限制"),

	UNKNOWN_IP(19, "非法IP请求"),

	SYSTEM_ERROR(500, "系统异常");
 
	private Integer code;
 
	private String message;
	
	public Integer getCode() {
		return code;
	}
 
	public void setCode(Integer code) {
		this.code = code;
	}
 
	public String getMessage() {
		return message;
	}
 
	public void setMessage(String message) {
		this.message = message;
	}
 
	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
