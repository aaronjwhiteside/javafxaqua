package de.zillmann.javafx.aqua.demo;

import de.zillmann.javafx.aqua.AquaFx;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;

public class ShutdownDialogDemo extends Application {

	public static void main(String[] args) {
		ShutdownDialogDemo.launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane borderPane = new BorderPane();

		Image image = new Image(AquaFx.class.getResource("demo/images/bild.png")
				.toExternalForm());

		ImageView iv = ImageViewBuilder.create().image(image).build();
		BorderPane.setMargin(iv, new Insets(18));
		borderPane.setLeft(iv);

		VBox vbox = VBoxBuilder.create().padding(new Insets(20, 20, 0, 40))
				.spacing(10).build();
		Label title = LabelBuilder.create()
				.text("Möchten Sie den Computer jetzt ausschalten?")
				.style("-fx-font-weight: bold").build();
		vbox.getChildren().add(title);

		Label info = LabelBuilder
				.create()
				.text("Wenn Sie keine Auswahl treffen, wird der Computer in 43 Sekunden automatisch ausgeschaltet.")
				.style("-fx-font-size : 0.8em").wrapText(true).build();
		VBox.setMargin(info, new Insets(14, 0, 0, 0));
		vbox.getChildren().add(info);

		CheckBox checkBox = CheckBoxBuilder.create()
				.text("Beim nächsten Anmelden alle Fenster wieder öffnen")
				.allowIndeterminate(false).build();
		vbox.getChildren().add(checkBox);

		borderPane.setCenter(vbox);

		HBox hbox = HBoxBuilder.create().alignment(Pos.CENTER_RIGHT)
				.padding(new Insets(19)).spacing(12).build();

		Button cancel = new Button();
		cancel.setText("Abbrechen");
		cancel.setCancelButton(true);
		hbox.getChildren().add(cancel);

		Button off = new Button();
		off.setText("Ausschalten");
		off.setDefaultButton(true);
		hbox.getChildren().add(off);

		borderPane.setBottom(hbox);

		Scene myScene = new Scene(borderPane, 470, 172);
		AquaFx.style();
		stage.setResizable(false);
		stage.setScene(myScene);
		stage.show();
	}

}
