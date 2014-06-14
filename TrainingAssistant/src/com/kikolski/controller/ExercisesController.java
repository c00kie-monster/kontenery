package com.kikolski.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ExercisesController {
	@FXML private TextField newExerciseName;
	@FXML private TextField newExerciseDesc;
	@FXML private TextField newExerciseBodyPart;
	@FXML private Button createButton;
	
	@FXML protected void handleCreateAction(ActionEvent event) {
		newExerciseName.setText("It Works!");
	}
}
