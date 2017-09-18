package com.example.demo.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.demo.job.ExportFreindDataJob;
//以下是FirstJob引用的相关包
import com.example.demo.job.FirstJob;
import org.apache.commons.logging.Log;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

//以下是任务二要引用的包
import com.example.demo.job.SecondJob;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.DateBuilder.*;


/**
 * 功能描述：任务调度器类
 * @author zhoucong、
 *
 */
public class SchedulerTask {
	
	static Log logger = org.apache.commons.logging.LogFactory.getLog(SchedulerTask.class);  
	
	
	
	public SchedulerTask(){}
	//Create and Schedule a ScanDirectoryJob with the Scheduler  
		private static Scheduler createScheduler() throws SchedulerException{
			return StdSchedulerFactory.getDefaultScheduler();
		}
		/**
		 * 启动第一个job
		 */
		public static void startFirstJob(){
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日  HH 时 mm 分 ss 秒");  
		       // String jobRunTime = dateFormat.format(Calendar.getInstance().getTime());
			
			try {
				Scheduler scheduler=SchedulerTask.createScheduler();
				scheduler.start();//启动调度器
				
				//2、jobDetail[job实例]任务详情
				JobDetail jobDetailOne=JobBuilder.newJob(FirstJob.class)// 任务执行类
						.withIdentity("Job1", "JGroup1")// 任务名，任务组 
						.build();
				//3、构建一个trigger 
				@SuppressWarnings("static-access")
				SimpleScheduleBuilder builder=SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(5)//设置间隔执行时间
						.repeatSecondlyForTotalCount(5);//设置执行次数 
				Trigger trigger=TriggerBuilder.newTrigger().withIdentity("trigger1_1","tGroup1").startNow().withSchedule(builder).build();
				
				//4、调度执行
				 Date ft = scheduler.scheduleJob(jobDetailOne, trigger);  // 把job1 和 trigger加入计划   .  ft:此任务要执行的时间 
				 
			        System.out.println(jobDetailOne.getKey().getName() + " 将在 : " + dateFormat.format(ft) + " 时运行.并且重复: "  
			                + ((SimpleTrigger) trigger).getRepeatCount() + " 次, 每次间隔 "  
			                + ((SimpleTrigger) trigger).getRepeatInterval() /1000+" 秒");
				scheduler.start();
				
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				logger.info(e);;
			}
			
			
		}
		/**
		 * 第二个job2
		 */
		public static void startSecondJob(){
			try {
				Scheduler schd=SchedulerTask.createScheduler();//获取scheduler
				
				JobDetail jobDetail2=newJob(SecondJob.class)
			             .withIdentity("Job2")
			             .build();//detail详情
				
				// 初始化传入的参数  
				jobDetail2.getJobDataMap().put(SecondJob.EXECUTION_COUNT, 0); //初始化执行次数 
				jobDetail2.getJobDataMap().put("name", "周聪");//存储一个姓名属性
				
				
				
			//	创建一个在未来第10秒的时候开始执行触发器，每5秒执行一次，共5次
			//	使用DateBuilder的futureDate方法可以指定在未来时间执行。
				Trigger	trigger = (SimpleTrigger) newTrigger()
					    .withIdentity("trigger2", "group2")
					    .startAt(futureDate(10, IntervalUnit.SECOND))
					    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
		        .withIntervalInSeconds(5)//执行间隔时间
		        .withRepeatCount(5)) //执行次数，执行5次后EXECUTION_COUNT便是5了
					    .forJob("Job2") /* job的jobKey*/
					    .build();
				schd.scheduleJob(jobDetail2, trigger);
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
}
