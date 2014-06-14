package com.kikolski.model.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exercise implements Serializable{
	private static final long serialVersionUID = 9134143186434079669L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	
	@Column (unique = true, nullable = false, length=16)
	private String name;
	
	@Column (nullable = false, length=16)
	private String bodyPart;
	
	private String description;
		
	public Exercise() {
		
	}
	
	public Exercise(String name, String bodyPart) {
		this(name, bodyPart, "");
	}
	
	public Exercise(String name, String bodyPart, String description){
		this.name = name;
		this.bodyPart = bodyPart;
		this.description = description;
	}
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return id + " | " +  name + " | " + description;
	}
}