package com.example.demo.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Friend;
import com.example.demo.common.ResultCodeEnum;
import com.example.demo.common.ResultInfo;
import com.example.demo.dataExport.FriendExport;
import com.example.demo.excelUtil.ExcelExportUtil;
import com.example.demo.excelUtil.ExcelExportUtil2;
import com.example.demo.excelUtil.ExcelImportUtil;
import com.example.demo.job.ExportFreindDataJob;
import com.example.demo.service.FriendService;

import jxl.write.WriteException;

@RestController
@RequestMapping(value="/friend")
public class FriendController {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String startTime=null;
	String endTime=null;
	static Log logger = org.apache.commons.logging.LogFactory.getLog(ExportFreindDataJob.class);  
	
	@Autowired
	private FriendService friendService;
	
	/**
	 * 获取所有的list<Friend>
	 * @return
	 */
	@SuppressWarnings("null")
	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	public String getAll(){
	List<Friend> listData=	friendService.getAllFriend();
	if (listData==null&&listData.isEmpty()) {
		return JSON.toJSONString(new ResultInfo(ResultCodeEnum.Code400.getCode(), ResultCodeEnum.Code400.getCodeMessage(),listData));
	}
	return JSON.toJSONString(new ResultInfo(ResultCodeEnum.Code200.getCode(), ResultCodeEnum.Code200.getCodeMessage(), listData));
	}
	
	/**
	 * 将数据导出到本地磁盘
	 * @return
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@RequestMapping(value="/exportFreindBean",method = RequestMethod.GET)
	public void exportFreindBean() throws IOException, ParseException{
		startTime=dateFormat.format(Calendar.getInstance().getTime());
	logger.info("======》导出数据开始 startTime = "+startTime);
		List<Friend> listData=	friendService.getAllFriend();
	FriendExport.FriendExcel(listData);
	endTime=dateFormat.format(Calendar.getInstance().getTime());
	logger.info("======》导出数据结束 endTime = "+endTime);
	}

	/**
	 * 每1分钟将数据导出到本地磁盘======》定时任务【采用quartz】===>采用配置文件配置
	 */
	@RequestMapping(value="/JxlExportFreind",method = RequestMethod.GET)
	public void JxlExportFreind() throws IOException, ParseException, IllegalArgumentException, IllegalAccessException, WriteException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String time=dateFormat.format(Calendar.getInstance().getTime());
		ExcelExportUtil.judeDirExists();//判断本地文件夹是否存在
		String fileName=time;
    	List<Map<String, Object>> listData=	friendService.getAllFriendResultMap();
    	ExcelExportUtil2.excleOut(listData, fileName);
	}
	
	/**
	 * jxl将excel数据转换为List<Map<String,Object>>
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws WriteException
	 */
	@RequestMapping(value="/getDataFromExcel",method = RequestMethod.GET)
	public String getDataFromExcel() throws IOException, ParseException, IllegalArgumentException, IllegalAccessException, WriteException{
		FileInputStream input = new FileInputStream("E:/dataExcel/1234.xls");
    	List<Map<String, Object>> listData=	ExcelImportUtil.getDataFromExcel(input, 0, ExcelImportUtil.Friend_ROW_1_Keys);//ExcelImportUtil.Friend_ROW_1 //表头
	return JSON.toJSONString(listData);
	}
	//getDataFromExcel
}
