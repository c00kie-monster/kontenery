package com.kikolski.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application{
	
	public static void main(String[] params) {
		ContextWrapper.initialize();
		launch(params);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("../view/MainApplication.fxml"));
        Scene scene = new Scene(root, 640, 480);
        stage.setTitle("Training Assistant");
        stage.setScene(scene);
        stage.show();
	}

}
