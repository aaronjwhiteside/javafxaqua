package de.zillmann.javafx.aqua.demo;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPaneBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;
import de.zillmann.javafx.aqua.AquaFx;
import de.zillmann.javafx.aqua.controls.skin.styles.ButtonType;

public class AquaSpecialControlsDemo extends Application {

    @Override public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root);
        AquaFx.style();
        stage.setScene(scene);
        stage.setTitle("AquaFX Controls");

        GridPane grid = GridPaneBuilder.create().padding(new Insets(20)).vgap(10).hgap(10).build();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.RIGHT);
        grid.getColumnConstraints().add(column1); 

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHalignment(HPos.LEFT);
        grid.getColumnConstraints().add(column2); 
        
        
        Label info = new Label("Those Controls are styled by AquaFX:");
        grid.add(info, 0, 0, 2, 1);
        GridPane.setHalignment(info, HPos.LEFT);

        Label labelb2 = new Label("Help Button:");
        grid.add(labelb2, 0, 2);
        Button b2 = new Button("?");
        AquaFx.skin(b2, ButtonType.HELP);
        grid.add(b2, 1, 2);

        Label labelb3 = new Label("Rounded Button:");
        grid.add(labelb3, 0, 3);
        Button b3 = new Button("round rect");
        AquaFx.skin(b3, ButtonType.ROUND_RECT);
        grid.add(b3, 1, 3);

        VBox box = VBoxBuilder.create().spacing(15).padding(new Insets(15)).build();
        AquaFx.setGroupBox(box);
        Label groupInfo = new Label("This is a GroupBox, which is\napplicable for all Panes\nvia AquaFX");
        box.getChildren().add(groupInfo);
        grid.add(box, 0, 5, 2, 1);

        scene.setRoot(grid);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}