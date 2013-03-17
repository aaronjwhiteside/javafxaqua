package de.zillmann.javafx.aqua.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContextMenuBuilder;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleButtonBuilder;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;
import de.zillmann.javafx.aqua.AquaFx;

public class ButtonDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        VBox txts = new VBox();

        HBox textfieldBox1 = HBoxBuilder.create().spacing(10)
                .padding(new Insets(10)).build();

        TextField tf1 = new TextField("MACBOOKPRO");
        tf1.setContextMenu(ContextMenuBuilder.create()
                .items(new MenuItem("test"), new MenuItem("test")).build());
        textfieldBox1.getChildren().add(tf1);

        TextField tf2 = new TextField();
        textfieldBox1.getChildren().add(tf2);
        txts.getChildren().add(textfieldBox1);

        HBox textfieldBox2 = HBoxBuilder.create().spacing(10)
                .padding(new Insets(10)).build();

        TextField tf3 = new TextField("MACBOOKPRO");
        tf3.setDisable(true);
        tf3.setEditable(false);
        textfieldBox2.getChildren().add(tf3);

        TextField tf4 = new TextField();
        tf4.setPromptText("prompt text");
        textfieldBox2.getChildren().add(tf4);
        txts.getChildren().add(textfieldBox2);

        HBox textfieldBox3 = HBoxBuilder.create().spacing(10)
                .padding(new Insets(10)).build();

        TextField tf5 = new TextField("MACBOOKPRO");
        tf5.setEditable(false);
        textfieldBox3.getChildren().add(tf5);

        PasswordField pw1 = new PasswordField();
        pw1.setText("password");
        textfieldBox3.getChildren().add(pw1);
        txts.getChildren().add(textfieldBox3);

        VBox textareaBox = VBoxBuilder.create().spacing(10)
                .padding(new Insets(10)).build();
        TextArea area = new TextArea();
        area.setPromptText("TextArea promptText");
        area.setPrefWidth(290);
        area.setPrefHeight(50);
        textareaBox.getChildren().add(area);

        TextArea area2 = new TextArea();
        area2.setText("Disabled");
        area2.setDisable(true);
        area2.setPrefWidth(290);
        area2.setPrefHeight(50);
        textareaBox.getChildren().add(area2);
        txts.getChildren().add(textareaBox);

        ScrollBar scBar = new ScrollBar();
        txts.getChildren().add(scBar);
        pane.setTop(txts);

        VBox buttonBox = VBoxBuilder.create().padding(new Insets(10))
                .spacing(10).build();

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
        pane.setLeft(buttonBox);

        VBox radioButtonBox = VBoxBuilder.create().padding(new Insets(10))
                .spacing(10).build();

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
        pane.setCenter(radioButtonBox);

        VBox checkBoxBox = VBoxBuilder.create().padding(new Insets(10))
                .spacing(10).build();

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
        pane.setRight(checkBoxBox);

        HBox toggleButtonBox = HBoxBuilder.create().padding(new Insets(10))
                .build();

        ToggleGroup group = new ToggleGroup();

        ToggleButton tb1 = ToggleButtonBuilder.create().text("First")
                .toggleGroup(group).selected(true).styleClass("left-pill")
                .build();
        toggleButtonBox.getChildren().add(tb1);

        ToggleButton tb2 = ToggleButtonBuilder.create().text("Second")
                .toggleGroup(group).styleClass("center-pill")
                .build();
        toggleButtonBox.getChildren().add(tb2);

        ToggleButton tb3 = ToggleButtonBuilder.create().text("Third")
                .toggleGroup(group).styleClass("right-pill")
                .build();
        toggleButtonBox.getChildren().add(tb3);
        
        ToggleButton tb4 = ToggleButtonBuilder.create().text("Alone")
                .selected(true)
                .build();
        toggleButtonBox.getChildren().add(tb4);

        
        ChoiceBox<String> choices = new ChoiceBox<String>(
                FXCollections.observableArrayList("4", "10", "12"));
        choices.getSelectionModel().selectFirst();
        toggleButtonBox.getChildren().add(choices);

        ChoiceBox<String> choices2 = new ChoiceBox<String>(
                FXCollections.observableArrayList("A", "B", "C"));
        choices2.getSelectionModel().selectFirst();
        choices2.setDisable(true);
        toggleButtonBox.getChildren().add(choices2);
        pane.setBottom(toggleButtonBox);

        Scene myScene = new Scene(pane, 400, 500);
        AquaFx.style();
        stage.setScene(myScene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
