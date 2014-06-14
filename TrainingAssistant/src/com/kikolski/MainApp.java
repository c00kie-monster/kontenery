package com.kikolski;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.kikolski.model.exception.ServiceException;
import com.kikolski.model.persistence.Exercise;
import com.kikolski.model.service.ExerciseService;

public class MainApp {
	public static void main(String[] params) throws ServiceException {
		ApplicationContext context = new FileSystemXmlApplicationContext("resources/application-context.xml");
		ExerciseService service = (ExerciseService) context.getBean("exerciseService");
		Exercise exer = new Exercise("Nogi", "Przysiady na jednej nodze");
		
		System.out.println(service.getAll());
	}
}
