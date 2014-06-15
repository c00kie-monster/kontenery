package com.kikolski.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kikolski.model.dao.GenericDAO;
import com.kikolski.model.exception.DAOException;
import com.kikolski.model.exception.ValidationException;
import com.kikolski.model.persistence.Exercise;
import com.kikolski.model.validator.Validator;

public class ExerciseService {
	public static final String BEAN_ID = "exerciseService"; 
	private Validator<Exercise> exerciseValidator;
	private GenericDAO<Exercise> exerciseDAO;
	
	public void add(Exercise exercise) throws ValidationException, DAOException{
		if(exerciseValidator.validate(exercise)) 
			exerciseDAO.add(exercise);
		else 
			throw new ValidationException();
	}
	
	public List<Exercise> getAll() {
		List<Exercise> result = exerciseDAO.getAll();
		if (result == null)
			return new ArrayList<Exercise>();
		return result;
	}

	public void delete(Exercise exercise) throws ValidationException, DAOException {
		if (exercise != null)
			exerciseDAO.delete(exercise);
		else
			throw new ValidationException();
	}
	
	public void update(Exercise exercise) throws ValidationException, DAOException {
		if (exerciseValidator.validate(exercise))
			exerciseDAO.update(exercise);
		else
			throw new ValidationException();
	}
		
	public void setExerciseValidator(Validator<Exercise> exerciseValidator) {
		this.exerciseValidator = exerciseValidator;
	}

	public void setExerciseDAO(GenericDAO<Exercise> exerciseDAO) {
		this.exerciseDAO = exerciseDAO;
	}
}