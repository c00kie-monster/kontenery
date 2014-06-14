package com.kikolski.model.validator;

import com.kikolski.model.persistence.Workout;

public class WorkoutValidator implements Validator<Workout>{

	@Override
	public boolean validate(Workout object) {
		if (object == null || object.getName() == null || object.getName().trim().equals(""))
			return false;
		return true;
	}

}
