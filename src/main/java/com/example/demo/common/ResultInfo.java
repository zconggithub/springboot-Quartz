package com.example.demo.common;
/**
 * 
		* @methodDesc: 功能描述:(数据返回类)
        * @author: 周聪  
		* @param: @return   
        * @createTime:2017年7月26日 上午11:26:38
        *
 */
public class ResultInfo {
	
	public String code;//返回码枚举类
	
	public String message;//错误信息
	
	public Object data;//返回数据
	
	
	

	public ResultInfo(String code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultInfo [code=" + code + ", message=" + message + ", data=" + data + "]";
	}

	
	

}
