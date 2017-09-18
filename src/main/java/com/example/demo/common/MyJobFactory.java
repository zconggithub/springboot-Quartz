/*package com.example.demo.common;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;
//系统默认的SchedulerFactory
@Component
public class MyJobFactory extends AdaptableJobFactory {

    //这个对象Spring会帮我们自动注入进来,也属于Spring技术范畴.
	@Autowired
    private AutowireCapableBeanFactory capableBeanFactory;
     
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
         
        Object jobInstance=super.createJobInstance(bundle);
        capableBeanFactory.autowireBean(jobInstance);
        return super.createJobInstance(bundle);
    
    }
}*/