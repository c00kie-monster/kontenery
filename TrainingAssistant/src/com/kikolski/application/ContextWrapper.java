package com.kikolski.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public final class ContextWrapper{
	private static ApplicationContext applicationContext;
	
	public static Object getBean(String id) {
		return applicationContext.getBean(id);
	}
	
	public static <T> T getBean(Class<T> type) {
		return applicationContext.getBean(type);
	}
	
	private ContextWrapper(){
		
	}
	
	public static void initialize() {
		if (applicationContext == null)
			applicationContext = new FileSystemXmlApplicationContext("resources/application-context.xml");
	}
}
