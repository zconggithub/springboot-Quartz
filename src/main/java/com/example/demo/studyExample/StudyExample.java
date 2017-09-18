package com.example.demo.studyExample;
import java.util.Date;

import org.apache.commons.logging.Log;       
import org.apache.commons.logging.LogFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;
/**
 * 
 * 理解帮助quartz类，
 *
 */
@Component
public class StudyExample {
	
	static Log logger = LogFactory.getLog(StudyExample.class);   
	
	/**
	 * scheduler的学习，①启动调动器
	 */
	public Scheduler studyScheduler(){
		//1.创建调度工厂
		SchedulerFactory sf=new StdSchedulerFactory();
		//2.创建scheduler对象
		Scheduler scheduler=null;
		try {
			//.创建scheduler对象
			scheduler = sf.getScheduler();
			//3.start the scheduler
			scheduler.start();
			logger.info("Scheduler started at " + new Date()); 
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return scheduler;
	}

	/**
	 * 暂停调度器，然后再次启动②设置调度器为暂停模式
	 */
	public void pauseScheduler(Scheduler scheduler){
		
		try {
			if(!scheduler.isInStandbyMode()){
				// pause the scheduler  
				scheduler.standby();//启用暂停模式
				// Do something interesting here       
			      
		         // and then restart it       
		         scheduler.start();//然后再次启动
			}
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			 logger.error(e); 
		}
	}

	
	
}
