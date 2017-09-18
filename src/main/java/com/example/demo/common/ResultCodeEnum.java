package com.example.demo.common;

public enum ResultCodeEnum {
	
	Code200("200","成功"),
	Code300("300","入参为空"),
	Code400("400","查询结果为空"),
	Code500("500","错误");
	
	private String code;
	private String codeMessage;
	
	
	private ResultCodeEnum(String code, String codeMessage) {
		this.code = code;
		this.codeMessage = codeMessage;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeMessage() {
		return codeMessage;
	}
	public void setCodeMessage(String codeMessage) {
		this.codeMessage = codeMessage;
	}
	
	@SuppressWarnings("unused")
	private static String getCodeValue(String ResultCodeEnumCode){
		for (ResultCodeEnum resultCode : ResultCodeEnum.values()) {
			if (resultCode.getCode().equals(ResultCodeEnumCode)) {
				return resultCode.getCodeMessage();
			}
		}
		return null;
	}

	
	/*//测试
	public static void main(String[] args) {
		System.out.println(ResultCodeEnum.Code200);
		System.out.println(ResultCodeEnum.Code200.getCodeMessage());
	}*/
}
