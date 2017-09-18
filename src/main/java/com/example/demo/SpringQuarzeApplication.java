package com.example.demo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages={"com.example.demo.*"})
@MapperScan(basePackages={"com.example.demo.mapper"})
@ImportResource(locations={"classpath:applicationContext.xml"})
public class SpringQuarzeApplication {

	public static void main(String[] args) {	
		SpringApplication.run(SpringQuarzeApplication.class, args);
		//SchedulerTask.startFirstJob();
		//SchedulerTask.startSecondJob();
	}
}
