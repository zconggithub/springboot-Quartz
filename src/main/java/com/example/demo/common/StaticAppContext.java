package com.example.demo.common;

import org.springframework.context.ConfigurableApplicationContext;

public class StaticAppContext {

	private static ConfigurableApplicationContext context;
	
	public static ConfigurableApplicationContext getContext(){
	
			return context;
	}
	
	public static void setContext(ConfigurableApplicationContext context){
		
		StaticAppContext.context=context;
	}
}
