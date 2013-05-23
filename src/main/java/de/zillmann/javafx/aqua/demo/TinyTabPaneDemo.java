package de.zillmann.javafx.aqua.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.layout.PaneBuilder;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import de.zillmann.javafx.aqua.AquaFx;
import de.zillmann.javafx.aqua.controls.skin.styles.TabPaneType;

public class TinyTabPaneDemo extends Application {

    @Override public void start(Stage stage) {
        stage.setTitle("Tiny icon-TP");
        AquaFx.styleStage(stage, StageStyle.UTILITY);
        Pane root = PaneBuilder.create().build();
        Scene scene = new Scene(root, 215, 300);

        /*
         * Tabpane section
         */
        TabPane tabPane = new TabPane();
        tabPane.setPrefWidth(218);
        AquaFx.createTabPaneStyler().setType(TabPaneType.SMALL_ICON_BUTTONS).style(tabPane);
        
        Tab tab1 = new Tab();
        Image image = new Image(AquaFx.class.getResource("demo/images/pages/pages.png").toExternalForm());
        ImageView pages = ImageViewBuilder.create().image(image).preserveRatio(true).fitHeight(16).build();
        tab1.setGraphic(pages);
        Label label = LabelBuilder.create().text("Dokument...").padding(new Insets(15)).build();
        tab1.setContent(label);
        tabPane.getTabs().add(tab1);

        Tab tab2 = new Tab();
        Image image2 = new Image(AquaFx.class.getResource("demo/images/pages/layout.png").toExternalForm());
        ImageView layout = ImageViewBuilder.create().image(image2).preserveRatio(true).fitHeight(16).build();
        tab2.setGraphic(layout);
        Label label2 = LabelBuilder.create().text("layout").padding(new Insets(15)).build();
        tab2.setContent(label2);
        tabPane.getTabs().add(tab2);

        Tab tab3 = new Tab();
        Image image3 = new Image(AquaFx.class.getResource("demo/images/pages/umbruch.png").toExternalForm());
        ImageView umbruch = ImageViewBuilder.create().image(image3).preserveRatio(true).fitHeight(16).build();
        tab3.setGraphic(umbruch);
        Label label3 = LabelBuilder.create().text("Zeilenumbruch...").padding(new Insets(15)).build();
        tab3.setContent(label3);
        tabPane.getTabs().add(tab3);
        
        Tab tab4 = new Tab();
        Image image4 = new Image(AquaFx.class.getResource("demo/images/pages/text.png").toExternalForm());
        ImageView text = ImageViewBuilder.create().image(image4).preserveRatio(true).fitHeight(16).build();
        tab4.setGraphic(text);
        Label label4 = LabelBuilder.create().text("Zeilenumbruch...").padding(new Insets(15)).build();
        tab4.setContent(label4);
        tabPane.getTabs().add(tab4);
        
        Tab tab5 = new Tab();
        Image image5 = new Image(AquaFx.class.getResource("demo/images/pages/grafik.png").toExternalForm());
        ImageView grafik = ImageViewBuilder.create().image(image5).preserveRatio(true).fitHeight(16).build();
        tab5.setGraphic(grafik);
        Label label5 = LabelBuilder.create().text("Zeilenumbruch...").padding(new Insets(15)).build();
        tab5.setContent(label5);
        tabPane.getTabs().add(tab5);
        
        Tab tab6 = new Tab();
        Image image6 = new Image(AquaFx.class.getResource("demo/images/pages/lineal.png").toExternalForm());
        ImageView lineal = ImageViewBuilder.create().image(image6).preserveRatio(true).fitHeight(16).build();
        tab6.setGraphic(lineal);
        Label label6 = LabelBuilder.create().text("Lienal lineal lineal lineal lineal...").padding(new Insets(15)).build();
        tab6.setContent(label6);
        tabPane.getTabs().add(tab6);
        
        Tab tab7 = new Tab();
        Image image7 = new Image(AquaFx.class.getResource("demo/images/pages/diagramm.png").toExternalForm());
        ImageView diagramm = ImageViewBuilder.create().image(image7).preserveRatio(true).fitHeight(16).build();
        tab7.setGraphic(diagramm);
        Label label7 = LabelBuilder.create().text("diagramm...").padding(new Insets(15)).build();
        tab7.setContent(label7);
        tabPane.getTabs().add(tab7);
        
        Tab tab8 = new Tab();
        Image image8 = new Image(AquaFx.class.getResource("demo/images/pages/verknuepfung.png").toExternalForm());
        ImageView verknuepfung = ImageViewBuilder.create().image(image8).preserveRatio(true).fitHeight(16).build();
        tab8.setGraphic(verknuepfung);
        Label label8 = LabelBuilder.create().text("verknuepfung...").padding(new Insets(15)).build();
        tab8.setContent(label8);
        tabPane.getTabs().add(tab8);
        
        Tab tab9 = new Tab();
        Image image9 = new Image(AquaFx.class.getResource("demo/images/pages/quicktime.png").toExternalForm());
        ImageView quicktime = ImageViewBuilder.create().image(image9).preserveRatio(true).fitHeight(16).build();
        tab9.setGraphic(quicktime);
        Label label9 = LabelBuilder.create().text("quicktime...").padding(new Insets(15)).build();
        tab9.setContent(label9);
        tabPane.getTabs().add(tab9);
        
        root.getChildren().add(tabPane);

        AquaFx.style();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}