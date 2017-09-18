package com.example.demo.job;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.quartz.Job;
import org.quartz.JobDetail.*;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 此类主要就是：要执行的任务【最简单的一个job实例】
 * 作业通过实现 org.quartz.job 接口，可以使 Java 类变成可执行的。
 * 这个类用一条非常简单的输出语句覆盖了 execute(JobExecutionContext context) 方法。
 * 
 *
 */
public class FirstJob implements Job{
	
	static Log logger = org.apache.commons.logging.LogFactory.getLog(FirstJob.class);  
	 // 日期格式化  
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日  HH 时 mm 分 ss 秒"); 
    
	public FirstJob(){}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// 要执行的任务
		logger.info("===={} This is MyFirstQuartzJob... {FirstQuartzJob} "+dateFormat.format(Calendar.getInstance().getTime()));
    }
	
	
	
    
	 
} 