package de.zillmann.javafx.aqua.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxBuilder;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceBoxBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.layout.PaneBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import de.zillmann.javafx.aqua.AquaFx;
import de.zillmann.javafx.aqua.controls.skin.styles.TabPaneType;

public class IconTabPaneDemo extends Application {

    @Override public void start(Stage stage) {
        stage.setTitle("icon-TP");
        AquaFx.styleStage(stage, StageStyle.UNIFIED);
        Pane root = PaneBuilder.create().build();
        Scene scene = new Scene(root);

        /*
         * Tabpane section
         */
        TabPane tabPane = new TabPane();
        AquaFx.createTabPaneStyler().setType(TabPaneType.ICON_BUTTONS).style(tabPane);

        Tab tab1 = new Tab("Allgemein");
        Image image = new Image(AquaFx.class.getResource("demo/images/preferences/allgemein.png").toExternalForm());
        ImageView pages = ImageViewBuilder.create().image(image).preserveRatio(true).fitHeight(36).build();
        tab1.setGraphic(pages);
        Label label = LabelBuilder.create().text("Allgemein...").padding(new Insets(15)).build();
        tab1.setContent(label);
        tabPane.getTabs().add(tab1);

        Tab tab2 = new Tab("Etiketten");
        Image image2 = new Image(AquaFx.class.getResource("demo/images/preferences/labels.png").toExternalForm());
        ImageView layout = ImageViewBuilder.create().image(image2).preserveRatio(true).fitHeight(36).build();
        tab2.setGraphic(layout);
        Label label2 = LabelBuilder.create().text("Etiketten").padding(new Insets(15)).build();
        tab2.setContent(label2);
        tabPane.getTabs().add(tab2);

        Tab tab3 = new Tab("Seitenleiste");
        Image image3 = new Image(AquaFx.class.getResource("demo/images/preferences/seitenleiste.png").toExternalForm());
        ImageView umbruch = ImageViewBuilder.create().image(image3).preserveRatio(true).fitHeight(36).build();
        tab3.setGraphic(umbruch);
        Label label3 = LabelBuilder.create().text("seitenleiste...").padding(new Insets(15)).build();
        tab3.setContent(label3);
        tabPane.getTabs().add(tab3);

        Tab tab4 = new Tab("Erweitert");
        Image image4 = new Image(AquaFx.class.getResource("demo/images/preferences/einstellungen.png").toExternalForm());
        ImageView text = ImageViewBuilder.create().image(image4).preserveRatio(true).fitHeight(36).build();
        tab4.setGraphic(text);

        VBox vbox = VBoxBuilder.create().padding(new Insets(20, 20, 18, 20)).spacing(8).build();

        CheckBox box1 = CheckBoxBuilder.create().text("Alle Dateinamensuffixe einblenden").build();
        CheckBox box2 = CheckBoxBuilder.create().text("Vor dem Ändern eines Suffixes nachfragen").selected(true).build();
        CheckBox box3 = CheckBoxBuilder.create().text("Vor dem Entleeren des Papierkorbs nachfragen").selected(true).build();
        CheckBox box4 = CheckBoxBuilder.create().text("Papierkorb sicher entleeren").build();

        Label info = LabelBuilder.create().text("Bei Suchvorgängen:").padding(new Insets(9, 0, 0, 0)).build();

        ObservableList<String> items = FXCollections.observableArrayList("Diesen Mac durchsuchen", "Aktuellen Ordner durchsuchen",
                "Letzten Suchbereich verwenden");
        ChoiceBox<String> choice = ChoiceBoxBuilder.create(String.class).items(items).translateX(20).build();
        choice.getSelectionModel().selectFirst();
        vbox.getChildren().addAll(box1, box2, box3, box4, info, choice);

        tab4.setContent(vbox);
        tabPane.getTabs().add(tab4);

        root.getChildren().add(tabPane);

        AquaFx.style();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}