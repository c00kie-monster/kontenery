package com.kikolski.model.service;

import com.kikolski.model.dao.WorkoutDAO;
import com.kikolski.model.exception.ValidationException;
import com.kikolski.model.persistence.Workout;
import com.kikolski.model.validator.Validator;

public class WorkoutService {
	private WorkoutDAO workoutDAO;
	private Validator<Workout> validator;
	
	public void add(Workout workout) throws ValidationException{
		if (validator.validate(workout))
			workoutDAO.add(workout);
		else
			throw new ValidationException();
	}

	public void setWorkoutDAO(WorkoutDAO workoutDAO) {
		this.workoutDAO = workoutDAO;
	}

	public void setValidator(Validator<Workout> validator) {
		this.validator = validator;
	}	
}