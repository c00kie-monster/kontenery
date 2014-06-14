package com.kikolski.model.dao;

import java.util.List;

public interface GenericDAO<T> {
	void add(T exercise);
	List<T> getAll();
}
