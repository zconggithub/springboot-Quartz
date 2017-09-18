package com.example.demo.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
//对jobDateMap实现持久化   将上次处理过得值存入jobDateMap  

@PersistJobDataAfterExecution  
@DisallowConcurrentExecution 
//通过JobDataMap实现数据的传输【注意静态数据类型和非静态数据类型】
public class SecondJob implements Job{
	

	// 静态变量  
    public static final String EXECUTION_COUNT = "count";  //执行次数
	
    /**
     * Quartz 将每次将会重新实例化对象 ，非静态的成员变量不能用来保持状态 
     */
	int ticket=100;
	
	static Log logger = org.apache.commons.logging.LogFactory.getLog(SecondJob.class);  
	 // 日期格式化  
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日  HH 时 mm 分 ss 秒"); 
   
	public SecondJob(){}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// 要执行的任务
		System.out.println("--------->>{} This is MySecondJob..."+context.getJobDetail().getKey());
		logger.info("StarTime :"+dateFormat.format(Calendar.getInstance().getTime()));

		JobDataMap dataMap =context.getJobDetail().getJobDataMap();//通过JobDataMap 获取传递的参数
		int count = dataMap.getInt(EXECUTION_COUNT); 
	
		// 每次+1 并放回Map 中  
		//System.out.println("执行次数  EXECUTION_COUNT ："+count);
		logger.info("传递过来的参数值为 "+ "param【"+dataMap.getString("name")+"】");
		logger.info("票数 ticket【非静态】 剩余："+this.returnTicket(ticket)+"执行次数  EXECUTION_COUNT 【静态属性】 ："+count);
		dataMap.put(EXECUTION_COUNT, this.returnCount(count));  //将静态参数放回到JobDataMap中
		//当执行次数达到5次的时候，次数直接归-1；
		if (count==5) {
			count=-1;
			logger.info("票数 ticket【非静态】 剩余："+this.returnTicket(ticket)+"===》执行次数  EXECUTION_COUNT 【静态属性】已达到5次 ："+count);
			return;
		}
		
		
	}

	public int returnTicket(int ticket){
		ticket--;
		return ticket;
	}
	public int returnCount(int count){
		count++;
		return count;
	}
}
