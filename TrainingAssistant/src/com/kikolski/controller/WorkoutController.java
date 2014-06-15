package com.kikolski.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import com.kikolski.model.persistence.Exercise;

public class WorkoutController {
	@FXML private TextField workoutName;
	@FXML private TextArea workoutDesc;
	@FXML private ListView<Exercise> exercisesList;
	@FXML private ComboBox<String> workoutDay;
	
	@FXML private void handleCreateAction(ActionEvent event) {
		System.out.println("Tworze");
	}
}