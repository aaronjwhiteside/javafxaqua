package de.zillmann.javafx.aqua.demo;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;
import de.zillmann.javafx.aqua.AquaFx;

public class ButtonDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane pane = new BorderPane();
		
		VBox buttonBox = VBoxBuilder.create().padding(new Insets(20, 20, 0, 40))
				.spacing(10).build();
		pane.setLeft(buttonBox);
		
		Button b1 = new Button();
		b1.setText("Default");
		b1.setDefaultButton(true);
		buttonBox.getChildren().add(b1);
		
		Button b2 = new Button();
		b2.setText("Default");
		b2.setDisable(true);
		b2.setDefaultButton(true);
		buttonBox.getChildren().add(b2);
		
		Button b3 = new Button();
		b3.setText("Normal");
		buttonBox.getChildren().add(b3);
		
		Button b4 = new Button();
		b4.setText("Normal");
		b4.setDisable(true);
		buttonBox.getChildren().add(b4);
		
		
		VBox radioButtonBox = VBoxBuilder.create().padding(new Insets(20, 20, 0, 40))
				.spacing(10).build();
		pane.setCenter(radioButtonBox);
		
		RadioButton raBu1 = new RadioButton("Normal");
		radioButtonBox.getChildren().add(raBu1);

		RadioButton raBu2 = new RadioButton("Normal");
		raBu2.setDisable(true);
		radioButtonBox.getChildren().add(raBu2);

		RadioButton raBu3 = new RadioButton("Selected");
		raBu3.setSelected(true);
		radioButtonBox.getChildren().add(raBu3);

		RadioButton raBu4 = new RadioButton("Selected");
		raBu4.setDisable(true);
		raBu4.setSelected(true);
		radioButtonBox.getChildren().add(raBu4);
		
		VBox checkBoxBox = VBoxBuilder.create().padding(new Insets(20, 20, 0, 40))
				.spacing(10).build();
		pane.setRight(checkBoxBox);

		
		CheckBox box1 = new CheckBox("Normal");
		checkBoxBox.getChildren().add(box1);
		
		CheckBox box2 = new CheckBox("Normal");
		box2.setDisable(true);
		checkBoxBox.getChildren().add(box2);
		
		CheckBox box3 = new CheckBox("Selected");
		box3.setSelected(true);
		checkBoxBox.getChildren().add(box3);

		CheckBox box4 = new CheckBox("Selected");
		box4.setSelected(true);
		box4.setDisable(true);
		checkBoxBox.getChildren().add(box4);
		
		CheckBox box5 = new CheckBox("Indeterminate");
		box5.setIndeterminate(true);
		checkBoxBox.getChildren().add(box5);

		CheckBox box6 = new CheckBox("Indeterminate");
		box6.setIndeterminate(true);
		box6.setDisable(true);
		checkBoxBox.getChildren().add(box6);
		
		
		Scene myScene = new Scene(pane, 500, 200);
		AquaFx.style(myScene);
		
		stage.setScene(myScene);
		stage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
