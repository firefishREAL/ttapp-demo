package com.zr.ttappdemo.commons.util;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author yuyi
 * @description http请求返回的最外层对象
 * @date 16:29 2018/10/25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class ResultVo {
 
	/**
	 * 状态码
	 */
	private Integer code;
 
	/**
	 * 提示信息
	 */
	private String msg;

	/**
	 * 具体内容
	 */
	private Object data;
}
