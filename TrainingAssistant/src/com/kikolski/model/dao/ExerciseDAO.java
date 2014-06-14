package com.kikolski.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.kikolski.model.persistence.Exercise;

public class ExerciseDAO extends AbstractDAO implements GenericDAO<Exercise>{
	
	private Session currentSession;
	
	@Override
	public List<Exercise> getAll() {
		currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();
		Criteria criteria = currentSession.createCriteria(Exercise.class);
		List<Exercise> exercises = (List<Exercise>) criteria.list();
		currentSession.getTransaction().commit();
		return exercises;
	}
	
	@Override
	public void add(Exercise exercise) {
		currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();
		currentSession.save(exercise);
		currentSession.getTransaction().commit();
	}
}
