package de.zillmann.javafx.aqua.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPaneBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import de.zillmann.javafx.aqua.AquaFx;
import de.zillmann.javafx.aqua.controls.skin.styles.ButtonType;
import de.zillmann.javafx.aqua.controls.skin.styles.ControlSizeVariant;
import de.zillmann.javafx.aqua.controls.skin.styles.MacOSDefaultIcons;

public class AquaSpecialControlsDemo extends Application {

    private ObservableList<String> items = FXCollections.observableArrayList("A", "B", "C");
    
    @Override public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root);
        AquaFx.style();
        AquaFx.styleStage(stage, StageStyle.UNIFIED);
        stage.setScene(scene);
        stage.setTitle("AquaFX Controls");
        BorderPane pane = new BorderPane();
        
        GridPane grid = GridPaneBuilder.create().padding(new Insets(20)).vgap(10).hgap(10).build();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.RIGHT);
        grid.getColumnConstraints().add(column1); 
        
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHalignment(HPos.LEFT);
        grid.getColumnConstraints().add(column2); 

        /*
         * Toolbar section
         */
        ToolBar toolBar = new ToolBar();
        Button tbBack = ButtonBuilder.create().styleClass("left-pill").build();
        AquaFx.setButtonIcon(tbBack, MacOSDefaultIcons.LEFT);
        Button tbForward = ButtonBuilder.create().styleClass("right-pill").disable(true).build();
        AquaFx.setButtonIcon(tbForward, MacOSDefaultIcons.RIGHT);
        HBox separator = new HBox();
        separator.setPrefSize(15, 1);
        Button btnAll = new Button("Alle einblenden");
        HBox separator2 = new HBox();
        separator2.setPrefSize(15, 1);
        Button share = new Button();
        share.setDisable(true);
        AquaFx.setShareButton(share);
        toolBar.getItems().addAll(tbBack, tbForward, separator, btnAll, separator2, share);
        pane.setTop(toolBar);
        
        Label info = new Label("Those Controls are styled by AquaFX:");
        grid.add(info, 0, 0, 5, 1);
        GridPane.setHalignment(info, HPos.LEFT);


        
        /*
         * Different Control-sizes
         */
        Label labelb5 = new Label("regular:");
        grid.add(labelb5, 0, 2);
        Button b5 = new Button("Button");
        AquaFx.resizeControl(b5, ControlSizeVariant.REGULAR);
        grid.add(b5, 1, 2);
        ToggleButton tb5 = new ToggleButton("ToggleButton");
        AquaFx.resizeControl(tb5, ControlSizeVariant.REGULAR);
        grid.add(tb5, 2, 2);
        CheckBox cb5 = new CheckBox("CheckBox");
        cb5.setIndeterminate(true);
        AquaFx.resizeControl(cb5, ControlSizeVariant.REGULAR);
        grid.add(cb5, 3, 2);
        RadioButton rb5 = new RadioButton("RadioButton");
        AquaFx.resizeControl(rb5, ControlSizeVariant.REGULAR);
        grid.add(rb5, 4, 2);
        TextField tf5 = new TextField("TextField");
        AquaFx.resizeControl(tf5, ControlSizeVariant.REGULAR);
        grid.add(tf5, 5, 2);
        ComboBox<String> ecombo5 = new ComboBox<String>();
        ecombo5.setItems(items);
        ecombo5.setEditable(true);
        ecombo5.setPromptText("select");
        AquaFx.resizeControl(ecombo5, ControlSizeVariant.REGULAR);
        grid.add(ecombo5, 6, 2);
        ComboBox<String> combo5 = new ComboBox<String>();
        combo5.setItems(items);
        combo5.setPromptText("select");
        AquaFx.resizeControl(combo5, ControlSizeVariant.REGULAR);
        grid.add(combo5, 7, 2);
        ChoiceBox<String> choice5 = new ChoiceBox<String>();
        choice5.setItems(items);
        choice5.getSelectionModel().selectFirst();
        AquaFx.resizeControl(choice5, ControlSizeVariant.REGULAR);
        grid.add(choice5, 8, 2);
        Slider slider5 = new Slider(0, 50, 20);
        slider5.setShowTickLabels(true);
        slider5.setShowTickMarks(true);
        slider5.setMajorTickUnit(25);
        slider5.setMinorTickCount(4);
        grid.add(slider5, 9, 2);
        
        
        Label labelb6 = new Label("small:");
        AquaFx.resizeControl(labelb6, ControlSizeVariant.SMALL);
        grid.add(labelb6, 0, 3);
        Button b6 = new Button("Button");
        AquaFx.resizeControl(b6, ControlSizeVariant.SMALL);
        grid.add(b6, 1, 3);
        ToggleButton tb6 = new ToggleButton("ToggleButton");
        AquaFx.resizeControl(tb6, ControlSizeVariant.SMALL);
        grid.add(tb6, 2, 3);
        CheckBox cb6 = new CheckBox("CheckBox");
        cb6.setSelected(true);
//        cb6.setDisable(true);
        AquaFx.resizeControl(cb6, ControlSizeVariant.SMALL);
        grid.add(cb6, 3, 3);
        RadioButton rb6 = new RadioButton("RadioButton");
        AquaFx.resizeControl(rb6, ControlSizeVariant.SMALL);
        grid.add(rb6, 4, 3);
        TextField tf6 = new TextField("TextField");
        AquaFx.resizeControl(tf6, ControlSizeVariant.SMALL);
        grid.add(tf6, 5, 3);
        ComboBox<String> ecombo6 = new ComboBox<String>();
        ecombo6.setItems(items);
        ecombo6.setEditable(true);
        ecombo6.setPromptText("select");
        AquaFx.resizeControl(ecombo6, ControlSizeVariant.SMALL);
        grid.add(ecombo6, 6, 3);
        ComboBox<String> combo6 = new ComboBox<String>();
        combo6.setItems(items);
        combo6.setPromptText("select");
        AquaFx.resizeControl(combo6, ControlSizeVariant.SMALL);
        grid.add(combo6, 7, 3);
        ChoiceBox<String> choice6 = new ChoiceBox<String>();
        choice6.setItems(items);
        choice6.getSelectionModel().selectFirst();
        AquaFx.resizeControl(choice6, ControlSizeVariant.SMALL);
        grid.add(choice6, 8, 3);
        Slider slider6 = new Slider(0, 50, 20);
        slider6.setShowTickLabels(true);
        slider6.setShowTickMarks(true);
        slider6.setMajorTickUnit(25);
        slider6.setMinorTickCount(4);
        AquaFx.resizeControl(slider6, ControlSizeVariant.SMALL);
        grid.add(slider6, 9, 3);
        
        
        Label labelb7 = new Label("mini:");
        AquaFx.resizeControl(labelb7, ControlSizeVariant.MINI);
        grid.add(labelb7, 0, 4);
        Button b7 = new Button("Button");
        AquaFx.resizeControl(b7, ControlSizeVariant.MINI);
        grid.add(b7, 1, 4);
        ToggleButton tb7 = new ToggleButton("ToggleButton");
        AquaFx.resizeControl(tb7, ControlSizeVariant.MINI);
        grid.add(tb7, 2, 4);
        CheckBox cb7 = new CheckBox("CheckBox");
        cb7.setIndeterminate(true);
//      cb7.setDisable(true);
        AquaFx.resizeControl(cb7, ControlSizeVariant.MINI);
        grid.add(cb7, 3, 4);
        RadioButton rb7 = new RadioButton("RadioButton");
        AquaFx.resizeControl(rb7, ControlSizeVariant.MINI);
        grid.add(rb7, 4, 4);
        TextField tf7 = new TextField("TextField");
        AquaFx.resizeControl(tf7, ControlSizeVariant.MINI);
        grid.add(tf7, 5, 4);
        ComboBox<String> ecombo7 = new ComboBox<String>();
        ecombo7.setItems(items);
        ecombo7.setEditable(true);
        ecombo7.setPromptText("select");
        AquaFx.resizeControl(ecombo7, ControlSizeVariant.MINI);
        grid.add(ecombo7, 6, 4);
        ComboBox<String> combo7 = new ComboBox<String>();
        combo7.setItems(items);
        combo7.setPromptText("select");
        AquaFx.resizeControl(combo7, ControlSizeVariant.MINI);
        grid.add(combo7, 7, 4);
        ChoiceBox<String> choice7 = new ChoiceBox<String>();
        choice7.setItems(items);
        choice7.getSelectionModel().selectFirst();
        AquaFx.resizeControl(choice7, ControlSizeVariant.MINI);
        grid.add(choice7, 8, 4);
        Slider slider7 = new Slider(0, 50, 20);
        slider7.setShowTickLabels(true);
        slider7.setShowTickMarks(true);
        slider7.setMajorTickUnit(25);
        slider7.setMinorTickCount(4);
        AquaFx.resizeControl(slider7, ControlSizeVariant.MINI);
        grid.add(slider7, 9, 4);
        
        /*
         * a GroupBox
         */
        VBox box = VBoxBuilder.create().spacing(15).padding(new Insets(15)).build();
        AquaFx.setGroupBox(box);
        Label groupInfo = new Label("This is a GroupBox, which is applicable for all Panes\nvia AquaFX");
        box.getChildren().add(groupInfo);
        grid.add(box, 0, 5, 6, 3);
        
        /*
         * Special Controls
         */
        Label labelb2 = new Label("Help Button:");
        GridPane.setHalignment(labelb2, HPos.RIGHT);
        grid.add(labelb2, 6, 5);
        Button b2 = new Button("?");
        AquaFx.skin(b2, ButtonType.HELP);
        grid.add(b2, 7, 5);

        Label labelb3 = new Label("Rounded Button:");
        GridPane.setHalignment(labelb3, HPos.RIGHT);
        grid.add(labelb3, 6, 6);
        Button b3 = new Button("round rect");
        AquaFx.skin(b3, ButtonType.ROUND_RECT);
        grid.add(b3, 7, 6);

        Label labelb4 = new Label("Share Button:");
        GridPane.setHalignment(labelb4, HPos.RIGHT);
        grid.add(labelb4, 6, 7);
        Button b4 = new Button();
        AquaFx.setShareButton(b4);
        grid.add(b4, 7, 7);

        pane.setCenter(grid);
        scene.setRoot(pane);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}