package de.zillmann.javafx.aqua.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBuilder;
import javafx.scene.control.ContextMenuBuilder;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.HyperlinkBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleButtonBuilder;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.HTMLEditorBuilder;
import javafx.stage.Stage;
import de.zillmann.javafx.aqua.AquaFx;

public class ButtonDemo extends Application {
    final Tab tabH = new Tab();
    final Tab tabI = new Tab();

    @Override public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        ToolBar toolBar = new ToolBar();
        ColorPicker colorTB = new ColorPicker(Color.rgb(194, 222, 254));
        
        Separator seperateIt = new Separator();
        ToggleGroup toolbarGroup = new ToggleGroup();
        ToggleButton sampleButton4 = ToggleButtonBuilder.create().text("TG1").toggleGroup(toolbarGroup).selected(true).styleClass(
                "left-pill").build();
        ToggleButton sampleButton5 = ToggleButtonBuilder.create().text("TG2").toggleGroup(toolbarGroup).selected(true).styleClass(
                "center-pill").build();
        ToggleButton sampleButton6 = ToggleButtonBuilder.create().text("TG3").toggleGroup(toolbarGroup).selected(true).styleClass(
                "right-pill").build();
        Separator seperateIt2 = new Separator();
        
        Button menuPillButton1 = ButtonBuilder.create().text("PB 1").styleClass("left-pill").build();
        Button menuPillButton2 = ButtonBuilder.create().text("PB 2").styleClass("center-pill").build();
        Button menuPillButton3 = ButtonBuilder.create().text("PB 3").styleClass("right-pill").build();

//        HBox tbBox = HBoxBuilder.create().spacing(5).build();
        Button sampleButton = new Button("Button");
        ToggleButton sampleButton1 = new ToggleButton("Toggle");
        sampleButton1.setDisable(true);
        ToggleButton sampleButton2 = new ToggleButton("Toggle");
        ToggleButton sampleButton3 = ToggleButtonBuilder.create().text("Toggle2").selected(true).build();
//        tbBox.getChildren().addAll(sampleButton, sampleButton1, sampleButton2, sampleButton3);
//        toolBar.getItems().addAll(colorTB, seperateIt, sampleButton4, sampleButton5, sampleButton6, seperateIt2, tbBox, menuPillButton1, menuPillButton2, menuPillButton3);
        toolBar.getItems().addAll(colorTB, sampleButton, sampleButton1, sampleButton2, sampleButton3, seperateIt, sampleButton4, sampleButton5, sampleButton6, seperateIt2, menuPillButton1, menuPillButton2, menuPillButton3);

        
        pane.setTop(toolBar);

        /**
         * TabPane
         */
        VBox centerPane = VBoxBuilder.create().spacing(10).padding(new Insets(10)).build();
        TabPane buttonTabPane = new TabPane();

        // Create Tabs
        Tab tabD = new Tab();
        tabD.setText("Buttons");
        VBox buttonBox = VBoxBuilder.create().padding(new Insets(10)).spacing(10).build();
        Button b1 = new Button();
        b1.setText("Default (push to enable Tab 'Progress')");
        b1.setDefaultButton(true);
        b1.setTooltip(new Tooltip("This is a ToolTip"));
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                tabI.setDisable(false);
                tabH.setDisable(false);
            }
        });
        buttonBox.getChildren().add(b1);
        Button b2 = new Button();
        b2.setText("Default");
        b2.setDisable(true);
        b2.setDefaultButton(true);
        buttonBox.getChildren().add(b2);
        Button b3 = new Button();
        b3.setText("Normal (push to disable Tab 'Progress')");
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                tabH.setDisable(true);
            }
        });
        buttonBox.getChildren().add(b3);
        Button b4 = new Button();
        b4.setText("Normal");
        b4.setDisable(true);
        buttonBox.getChildren().add(b4);
        
        Hyperlink link = new Hyperlink("Hyperlink");
        Hyperlink link2 = HyperlinkBuilder.create().text("disabled Hyperlink").disable(true).build();
        buttonBox.getChildren().add(link);
        buttonBox.getChildren().add(link2);
        ScrollBar scBar = new ScrollBar();
        buttonBox.getChildren().add(scBar);
        
        tabD.setContent(buttonBox);
        buttonTabPane.getTabs().add(tabD);

        Tab tabE = new Tab();
        tabE.setText("RadioButtons");
        VBox radioButtonBox = VBoxBuilder.create().padding(new Insets(10)).spacing(10).build();
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
        tabE.setContent(radioButtonBox);
        buttonTabPane.getTabs().add(tabE);

        Tab tabF = new Tab();
        tabF.setText("CheckBoxes");
        VBox checkBoxBox = VBoxBuilder.create().padding(new Insets(10)).spacing(10).build();
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
        tabF.setContent(checkBoxBox);
        buttonTabPane.getTabs().add(tabF);

        Tab tabG = new Tab();
        tabG.setText("Toggles & Pills");
        VBox togglesBox = VBoxBuilder.create().spacing(10).padding(new Insets(10)).build();
        HBox toggleGroupBox = HBoxBuilder.create().build();
        ToggleGroup group = new ToggleGroup();
        ToggleButton tb1 = ToggleButtonBuilder.create().text("First").toggleGroup(group).selected(true).styleClass("left-pill").build();
        toggleGroupBox.getChildren().add(tb1);
        ToggleButton tb2 = ToggleButtonBuilder.create().text("Second").toggleGroup(group).styleClass("center-pill").build();
        toggleGroupBox.getChildren().add(tb2);
        ToggleButton tb3 = ToggleButtonBuilder.create().text("Third").toggleGroup(group).styleClass("right-pill").build();
        toggleGroupBox.getChildren().add(tb3);
        togglesBox.getChildren().add(toggleGroupBox);
        ToggleButton tb4 = ToggleButtonBuilder.create().text("Alone").selected(true).build();
        togglesBox.getChildren().add(tb4);
        HBox pillButtonBox = HBoxBuilder.create().build();
        Button pb1 = new Button();
        pb1.setText("Button 1");
        pb1.setTooltip(new Tooltip("This is a ToolTip"));
        pb1.getStyleClass().add("left-pill");
        pillButtonBox.getChildren().add(pb1);
        Button pb2 = new Button();
        pb2.setText("Button 2");
        pb2.getStyleClass().add("center-pill");
        pillButtonBox.getChildren().add(pb2);
        Button pb3 = new Button();
        pb3.setText("Button 3");
        pb3.getStyleClass().add("center-pill");
        pillButtonBox.getChildren().add(pb3);
        Button pb4 = new Button();
        pb4.setText("Button 4");
        pb4.getStyleClass().add("right-pill");
        pillButtonBox.getChildren().add(pb4);
        togglesBox.getChildren().add(pillButtonBox);
        tabG.setContent(togglesBox);
        buttonTabPane.getTabs().add(tabG);

        // Tab tabH = new Tab();
        tabH.setText("Progress");
        final Float[] values = new Float[] { -1.0f, 0f, 0.6f, 1.0f };
        final ProgressBar[] pbs = new ProgressBar[values.length];
        final ProgressIndicator[] pins = new ProgressIndicator[values.length];
        final HBox hbs[] = new HBox[values.length];
        for (int i = 0; i < values.length; i++) {
            final Label label = new Label();
            label.setText("progress: " + values[i]);
            label.setPrefWidth(100d);

            final ProgressBar pb = pbs[i] = new ProgressBar();
            pb.setProgress(values[i]);

            final ProgressIndicator pin = pins[i] = new ProgressIndicator();
            pin.setProgress(values[i]);
            final HBox hb = hbs[i] = new HBox();
            hb.setSpacing(10);
            hb.setAlignment(Pos.CENTER_LEFT);
            hb.getChildren().addAll(label, pb, pin);
        }
        final VBox vb = new VBox();
        vb.setSpacing(5);
        vb.setPadding(new Insets(10));
        vb.getChildren().addAll(hbs);
        tabH.setContent(vb);
        buttonTabPane.getTabs().add(tabH);

        tabI.setText("Disabled Tab");
        tabI.setDisable(true);
        TabPane innerTabPane = new TabPane();
        Tab onlyTab = new Tab("single tab");
        innerTabPane.getTabs().add(onlyTab);
        tabI.setContent(innerTabPane);
        buttonTabPane.getTabs().add(tabI);

        centerPane.getChildren().add(buttonTabPane);
        pane.setCenter(centerPane);

        VBox bottomPane = VBoxBuilder.create().spacing(10).padding(new Insets(10)).build();
        TabPane tabPane = new TabPane();
        // tabPane.setSide(Side.RIGHT);

        Tab tabTexts = new Tab();
        tabTexts.setText("Textfield/ -area");
        VBox txts = new VBox();
        HBox textfieldBox1 = HBoxBuilder.create().spacing(10).padding(new Insets(10)).build();
        Menu item1 = new Menu("test submenu");
        MenuItem subMenuItem1 = new MenuItem("Sub Menu Item 1");
        MenuItem subMenuItem2 = new MenuItem("Sub Menu Item 2");
        MenuItem subMenuItem3 = new MenuItem("Sub Menu Item 3");
        item1.getItems().addAll(subMenuItem1, subMenuItem2, subMenuItem3);
        TextField tf1 = new TextField("Textfield");
        tf1.setContextMenu(ContextMenuBuilder.create().items(new MenuItem("test"), item1, new MenuItem("test")).build());
        textfieldBox1.getChildren().add(tf1);
        TextField tf2 = new TextField();
        textfieldBox1.getChildren().add(tf2);
        HBox textfieldBox2 = HBoxBuilder.create().spacing(10).padding(new Insets(10)).build();
        TextField tf3 = new TextField("disabled Textfield");
        tf3.setDisable(true);
        tf3.setEditable(false);
        textfieldBox2.getChildren().add(tf3);
        TextField tf4 = new TextField();
        tf4.setPromptText("prompt text");
        textfieldBox2.getChildren().add(tf4);
        txts.getChildren().add(textfieldBox2);
        HBox textfieldBox3 = HBoxBuilder.create().spacing(10).padding(new Insets(10)).build();
        TextField tf5 = new TextField("non-editable textfield");
        tf5.setEditable(false);
        textfieldBox3.getChildren().add(tf5);
        PasswordField pw1 = new PasswordField();
        pw1.setText("password");
        textfieldBox3.getChildren().add(pw1);
        txts.getChildren().add(textfieldBox3);
        VBox textareaBox = VBoxBuilder.create().spacing(10).padding(new Insets(10)).build();
        TextArea area = new TextArea();
        area.setPromptText("TextArea with promptText");
        area.setPrefWidth(290);
        area.setPrefHeight(50);
        area.setPrefColumnCount(80);
        textareaBox.getChildren().add(area);
        TextArea area2 = new TextArea();
        area2.setText("Disabled");
        area2.setDisable(true);
        area2.setPrefWidth(290);
        area2.setPrefHeight(50);
        textareaBox.getChildren().add(area2);
        txts.getChildren().add(textareaBox);
        tabTexts.setContent(txts);
        tabPane.getTabs().add(tabTexts);

        Tab tabChoiceBox = new Tab();
        tabChoiceBox.setText("Choice-/ Combo-/ Color");
        VBox collectorVBox = new VBox();
        HBox choiceBoxBox = HBoxBuilder.create().padding(new Insets(10)).spacing(10).build();
        ChoiceBox<String> choices = new ChoiceBox<String>(FXCollections.observableArrayList("4", "10", "12"));
        choices.getSelectionModel().selectFirst();
        choiceBoxBox.getChildren().add(choices);
        ChoiceBox<String> choices2 = new ChoiceBox<String>(FXCollections.observableArrayList("A", "B", "C"));
        choices2.getSelectionModel().selectFirst();
        choices2.setDisable(true);
        choiceBoxBox.getChildren().add(choices2);
        collectorVBox.getChildren().add(choiceBoxBox);
        
        ObservableList items = FXCollections.observableArrayList("A", "B", "C");
        HBox editableComboBoxBox = HBoxBuilder.create().padding(new Insets(10)).spacing(10).build();
        ComboBox combo1 = ComboBoxBuilder.create().editable(true).items(items).promptText("test").build();
        editableComboBoxBox.getChildren().add(combo1);
        ComboBox combo2 = ComboBoxBuilder.create().editable(true).items(items).promptText("test").disable(true).build();
        editableComboBoxBox.getChildren().add(combo2);
        collectorVBox.getChildren().add(editableComboBoxBox);
        HBox comboBoxBox = HBoxBuilder.create().padding(new Insets(10)).spacing(10).build();
        ComboBox combo3 = ComboBoxBuilder.create().editable(false).items(items).promptText("test").build();
        comboBoxBox.getChildren().add(combo3);
        ComboBox combo4 = ComboBoxBuilder.create().editable(false).items(items).promptText("test").disable(true).build();
        comboBoxBox.getChildren().add(combo4);
        collectorVBox.getChildren().add(comboBoxBox);
        
        HBox colorPickerBox = HBoxBuilder.create().padding(new Insets(10)).spacing(10).build();
        ColorPicker color = new ColorPicker(Color.rgb(194, 222, 254));
        colorPickerBox.getChildren().add(color);
        ColorPicker color2 = new ColorPicker(Color.rgb(194, 222, 254));
        color2.getStyleClass().add("button");
        colorPickerBox.getChildren().add(color2);
        ColorPicker color3 = new ColorPicker(Color.rgb(194, 222, 254));
        color3.getStyleClass().add("split-button");
        colorPickerBox.getChildren().add(color3);
        collectorVBox.getChildren().add(colorPickerBox);
        tabChoiceBox.setContent(collectorVBox);
        tabPane.getTabs().add(tabChoiceBox);


        Tab tabHTMLBox = new Tab();
        tabHTMLBox.setText("HTML");
        VBox htmlbox = VBoxBuilder.create().padding(new Insets(5)).build();
        HTMLEditor htmlEditor = HTMLEditorBuilder.create().prefHeight(200).prefWidth(300).build();
        htmlbox.getChildren().add(htmlEditor);
        tabHTMLBox.setContent(htmlbox);
        tabPane.getTabs().add(tabHTMLBox);

        tabPane.getSelectionModel().select(tabHTMLBox);
        bottomPane.getChildren().add(tabPane);
        pane.setBottom(bottomPane);

        Scene myScene = new Scene(pane, 650, 500);
        AquaFx.style();
        stage.setTitle("AquaFX");
        stage.setScene(myScene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
