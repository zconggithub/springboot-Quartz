package com.example.demo.junit;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.demo.SpringQuarzeApplication;
import com.example.demo.studyExample.StudyExample;

/**
 * 
 * SpringBoot单元测试类
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
@SpringBootTest(classes = SpringQuarzeApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class JunitTest {
	
	@Autowired
	private StudyExample studyExample;
	
	
	

	@Test
	public void StudySchedulerExample(){
		System.out.println("{}############## Scheduler启动 {调度器启动} #########################");
		studyExample.studyScheduler();
	}
	/**
	 * 运行上面测试的代码【run as Junit】，会有日志输出，你会看到类似如下的输出：
INFO [main] (SimpleScheduler.java:30) - Scheduler started at Mon Sep 05 13:06:38 EDT 2005
上面展示了启动一个 Quartz 调度器是那么的简单。
当调度器起来之后，你可以利用它做很多事情或者获取到它的许多信息。
例如，你也许需要安排一些 Job  或者改变又安排在调度器上 Job 的执行次数。
你也许需要让调度器处于暂停模式，接着再次启动它以便重新执行在其上安排的作业。
当调度器处于暂停模式时，不执行任何作业，即使是作业到了它所期待的执行时间。
下面 展示了怎么把调度器置为暂停模式然后又继续运行，这样调度器会从中止处继续执行。
	 */
	@Test
	public void pauseSchedulerExample(){
		System.out.println("{}############## Scheduler {调度器将暂停} #########################");
		studyExample.pauseScheduler(studyExample.studyScheduler());
		System.out.println("{}############## Scheduler启动 {调度器再次启动} #########################");
		studyExample.studyScheduler();
	}

}
