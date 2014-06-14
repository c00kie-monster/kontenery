package com.kikolski.model.validator;

import com.kikolski.model.persistence.Exercise;

public class ExerciseValidator implements Validator<Exercise> {

	@Override
	public boolean validate(Exercise object) {
		if (object == null)
			return false;
		if (object.getName() == null || object.getName().trim().equals(""))
			return false;
		return true;
	}
	
}
