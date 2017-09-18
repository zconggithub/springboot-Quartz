package com.example.demo.common;

import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

import net.minidev.json.JSONObject;

/**
 * 
		* @methodDesc: 功能描述:(集合或bean判断是否为空)
        * @author: 周聪  
		* @param: @return   
        * @createTime:2017年7月26日 上午11:26:38
        *
 */
public class CommonUtil {
	
	private static Logger logger = Logger.getLogger("CommonUtil"); 
	
	
	/**
	 * 
	 * @param 判断list是否为空,返回一个json字符串
	 * @return
	 */
	@SuppressWarnings("null")
	public static String ListJudge(List<?> list){
	//下面判断list集合是否为空(数据量大，效率高)
		ResultInfo resultInfo=null;
		if(list==null && list.isEmpty()){
			logger.info("集合为空，{}"+list+"==null");
			resultInfo.setCode(ResultCodeEnum.Code400.getCode());
			resultInfo.setData(null);
			resultInfo.setMessage(ResultCodeEnum.Code400.getCodeMessage());//查询结果集为空
			return JSON.toJSONString(resultInfo);//javaBean转为json字符串
		}
		return JSON.toJSONString(list);//list<?>装换为json字符串
		}
	/**
	 * 
	 * @param 判断对象是否为空,返回为json格式
	 * @return
	 */
	@SuppressWarnings("null")
	public static String BeanJudge(Object object){
		ResultInfo resultInfo=null;
		if (object==null) {
			logger.info("对象为空，{}"+object+"==null");
			resultInfo.setCode(ResultCodeEnum.Code400.getCode());
			resultInfo.setData(null);
			resultInfo.setMessage(ResultCodeEnum.Code400.getCodeMessage());//查询结果为空
			return JSON.toJSONString(resultInfo);
		}
		return JSON.toJSONString(object);
	}


	
}
