package com.kikolski.model.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.kikolski.model.validation.interfaces.NotVulgarism;

@Entity
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (unique = true, nullable = false)
	@NotBlank(message = "Musisz poda� nazwe treningu")
	@NotVulgarism(message = "Brzydkie s��wko w nazwie treningu")
	private String name;
	
	@ManyToMany
	@Size(min = 1, message = "Musisz wybra� co najmniej jedno �wiczenie")
	private List<Exercise> exercises;
	
	@Column (nullable = false, length = 16)
	@NotNull (message = "Musisz wybra� dzien treningu")
	private String day;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}	
	
	@Override
	public String toString() {
		return name;
	}
}