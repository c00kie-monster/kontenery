package com.kikolski.model.service;

import java.util.List;

import com.kikolski.model.dao.GenericDAO;
import com.kikolski.model.exception.ServiceException;
import com.kikolski.model.persistence.Exercise;
import com.kikolski.model.validator.Validator;

public class ExerciseService {
	
	private Validator<Exercise> exerciseValidator;
	private GenericDAO<Exercise> exerciseDAO;
	
	public void add(Exercise exercise) throws ServiceException{
		if(exerciseValidator.validate(exercise)) 
			exerciseDAO.add(exercise);
		else 
			throw new ServiceException();
	}
	
	public List<Exercise> getAll() {
		return exerciseDAO.getAll();
	}

	public void setExerciseValidator(Validator<Exercise> exerciseValidator) {
		this.exerciseValidator = exerciseValidator;
	}

	public void setExerciseDAO(GenericDAO<Exercise> exerciseDAO) {
		this.exerciseDAO = exerciseDAO;
	}
}