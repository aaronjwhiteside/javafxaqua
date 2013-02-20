package de.zillmann.javafx.aqua.demo;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import de.zillmann.javafx.aqua.AquaFx;

public class ButtonDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		final Button b1 = new Button();
		b1.setText("Abmelden");
		b1.setDefaultButton(true);
		BorderPane pane = new BorderPane();
		pane.setTop(b1);
		
		Button b2 = new Button();
		b2.setText("Weitere Optionen ...");
		b2.setDisable(true);
		pane.setLeft(b2);
		
		Button b = new Button("Abbrechen");
		pane.setBottom(b);
		
		CheckBox box1 = new CheckBox("Checkbox 1");
		box1.setSelected(true);
		pane.setCenter(box1);
		
		CheckBox box2 = new CheckBox("Checkbox 2");
		pane.setRight(box2);
		
		Scene myScene = new Scene(pane);
		AquaFx.style(myScene);
		
		stage.setScene(myScene);
		stage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
