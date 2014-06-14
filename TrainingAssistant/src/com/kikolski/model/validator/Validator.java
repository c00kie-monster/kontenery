package com.kikolski.model.validator;

public interface Validator<T> {
	boolean validate(T object);
}
