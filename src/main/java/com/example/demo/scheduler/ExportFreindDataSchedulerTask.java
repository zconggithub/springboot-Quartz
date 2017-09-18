/*package com.example.demo.scheduler;

import static org.quartz.JobBuilder.newJob;

import org.apache.commons.logging.Log;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.example.demo.job.ExportFreindDataJob;

public class ExportFreindDataSchedulerTask {

	
static Log logger = org.apache.commons.logging.LogFactory.getLog(ExportFreindDataSchedulerTask.class);  
	
	
	
	public ExportFreindDataSchedulerTask(){}
	//Create and Schedule a ScanDirectoryJob with the Scheduler  
		private static Scheduler createScheduler() throws SchedulerException{
			return StdSchedulerFactory.getDefaultScheduler();
		}
	
	*//**
	 * 第三个job3
	 * 每1分钟将数据导出到本地磁盘======》定时任务【采用quartz】
	 *//*
	public static void startThirdJob(){
		try {
			Scheduler schd=ExportFreindDataSchedulerTask.createScheduler();//获取scheduler
			
			JobDetail jobDetail3=newJob(ExportFreindDataJob.class)
		             .withIdentity("Job3")
		             .build();//detail详情
		//	
			//3、构建一个trigger 
			SimpleScheduleBuilder builder=SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(3);//设置间隔执行时间
			Trigger trigger=TriggerBuilder.newTrigger().withIdentity("trigger3","tGroup3").startNow().withSchedule(builder).build();
			
			schd.scheduleJob(jobDetail3, trigger);
			
			schd.start();
			
			
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
*/