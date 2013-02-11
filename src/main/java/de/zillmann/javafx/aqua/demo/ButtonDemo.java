package de.zillmann.javafx.aqua.demo;

import de.zillmann.javafx.aqua.AquaFx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ButtonDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Button b = new Button("Button");
		BorderPane pane = new BorderPane();
		pane.setCenter(b);
		
		CheckBox box = new CheckBox("Checkbox");
		pane.setBottom(box);
		
		Scene myScene = new Scene(pane);
		AquaFx.style(myScene);
		
		stage.setScene(myScene);
		stage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
