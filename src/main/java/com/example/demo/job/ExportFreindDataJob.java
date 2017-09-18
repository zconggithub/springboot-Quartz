package com.example.demo.job;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.example.demo.bean.Friend;
import com.example.demo.common.StaticAppContext;
import com.example.demo.dataExport.FriendExport;
import com.example.demo.service.FriendService;

/**
 * 功能描述【每1分钟将数据库数据更新到本地磁盘，以excel表格存储。并不是每分钟会创建一个excel表格】
 * 造成这种原因的是：ExcelExportUtil类中的时间设置，static修饰的【如下】:
 * 
 * 	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
	static String time=dateFormat.format(Calendar.getInstance().getTime());
 * 
 * 
 * @author zhoucong、
 *	定时从数据库中更新数据并以Excel表格保存在本地某文件夹中【每1分钟将数据更新到本地磁盘======》定时任务【采用quartz】】
 */
@Component("ExportFreindDataJob")
public class ExportFreindDataJob {
	
	//注入service的时候注意【重点】
  	@Autowired
	private FriendService	friendService;
	static Log logger = org.apache.commons.logging.LogFactory.getLog(ExportFreindDataJob.class);
	// 日期格式化  
  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日  HH 时 mm 分 ss 秒"); 

	
	public void execute() {
		// TODO Auto-generated method stub
		// 要执行的任务
		//System.out.println("--------->>{} This is ThirdJob..."+context.getJobDetail().getKey());
		logger.info("StarTime :"+dateFormat.format(Calendar.getInstance().getTime()));
		//导出朋友表的数据
		List<Friend> listData=	friendService.getAllFriend();
		try {
			FriendExport.FriendExcel(listData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info(e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.info(e);
		}
		}
}
