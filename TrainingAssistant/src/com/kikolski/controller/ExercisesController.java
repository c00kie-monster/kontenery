package com.kikolski.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.kikolski.application.ContextWrapper;
import com.kikolski.model.exception.DAOException;
import com.kikolski.model.exception.ValidationException;
import com.kikolski.model.persistence.Exercise;
import com.kikolski.model.service.ExerciseService;

public class ExercisesController implements Initializable{
	@FXML private TextField newExerciseName;
	@FXML private TextArea newExerciseDesc;
	@FXML private TextField newExerciseBodyPart;
	@FXML private Button createButton;
	@FXML private ListView<Exercise> exercisesList;
	@FXML private TextField selectedExerciseBodyPart;
	@FXML private TextArea selectedExerciseDesc;
	
	private ExerciseService service = ContextWrapper.getBean(ExerciseService.class);
	private List<Exercise> exercises;
	
	@FXML
	protected void handleCreateAction(ActionEvent event) {
		Exercise exercise;
		try {
			exercise = ContextWrapper.getBean(Exercise.class);
			exercise.setDescription(newExerciseDesc.getText());
			exercise.setName(newExerciseName.getText());
			exercise.setBodyPart(newExerciseBodyPart.getText());
			service.add(exercise);
			exercises.add(exercise);
			exercisesList.getItems().add(exercise);
		} catch (ValidationException e) {
			e.printStackTrace();
		} catch (DAOException e) {

			e.printStackTrace();
		}
		showDialog();
		clearNewExerciseFields();
	}
		
	@FXML private void handleDeleteAction(ActionEvent event) {
		Exercise exercise = exercisesList.getSelectionModel().getSelectedItem();
		try {
			service.delete(exercise);
			exercises.remove(exercise);
			exercisesList.getItems().remove(exercise);
		} catch (ValidationException e) {
			e.printStackTrace();
		} catch (DAOException e) {
			
			e.printStackTrace();
		} 
	}
	
	@FXML private void handleEditAction(ActionEvent event) {
		Exercise exercise = exercisesList.getSelectionModel().getSelectedItem();
		String currentDesc = exercise.getDescription();
		String currentBodyPart = exercise.getBodyPart();
		try {
			exercise.setBodyPart(selectedExerciseBodyPart.getText());
			exercise.setDescription(selectedExerciseDesc.getText());
			service.update(exercise);
		} catch (Exception e) {
			exercise.setBodyPart(currentBodyPart);
			exercise.setDescription(currentDesc);
			e.printStackTrace();
		}
	}
	
	private void clearNewExerciseFields() {
		newExerciseBodyPart.clear();
		newExerciseDesc.clear();
		newExerciseName.clear();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		exercises = service.getAll();
		exercisesList.setItems(FXCollections.observableArrayList(exercises));
		exercisesList.getSelectionModel().selectedItemProperty().addListener(new ExerciseSelectionChangedListener());
		System.out.println(exercises.size());
		
	}
	

	public void showDialog() {
		Stage dialog = new Stage();
		dialog.initStyle(StageStyle.UNDECORATED);
		Scene scene = new Scene(new Group(new Text(25, 25, "Hello World!")));
		dialog.setScene(scene);
		dialog.show();
	}
	
	private class ExerciseSelectionChangedListener implements ChangeListener<Exercise> {
		@Override
		public void changed(ObservableValue<? extends Exercise> observable, Exercise oldValue, Exercise newValue) {
			if (newValue != null) {
				selectedExerciseBodyPart.setText(newValue.getBodyPart());
				selectedExerciseDesc.setText(newValue.getDescription());
			}
		}
	}
}
