package de.zillmann.javafx.aqua.demo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuItemBuilder;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import de.zillmann.javafx.aqua.AquaFx;
import de.zillmann.javafx.aqua.controls.skin.styles.ButtonType;
import de.zillmann.javafx.aqua.controls.skin.styles.MacOSDefaultIcons;
import de.zillmann.javafx.aqua.nativestuff.NsImageIcon;
import de.zillmann.javafx.aqua.nativestuff.NsImageIconLoader;

public class AquaNetworkDemo extends Application {
    private int sceneHeight = 588;

    @Override public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNIFIED);
        stage.setResizable(false);

        VBox mainBox = new VBox();

        ToolBar toolBar = new ToolBar();
        Button tbBack = ButtonBuilder.create().styleClass("left-pill").build();
        AquaFx.setButtonIcon(tbBack, MacOSDefaultIcons.LEFT);
        Button tbForward = ButtonBuilder.create().styleClass("right-pill").disable(true).build();
        AquaFx.setButtonIcon(tbForward, MacOSDefaultIcons.RIGHT);
        HBox separator = new HBox();
        separator.setPrefSize(15, 1);
        Button btnAll = new Button("Alle einblenden");
        toolBar.getItems().addAll(tbBack, tbForward, separator, btnAll);

        mainBox.getChildren().add(toolBar);
        /*
         * The top content
         */
        HBox header = HBoxBuilder.create().spacing(5).padding(new Insets(20, 0, 5, 0)).alignment(Pos.CENTER).build();
        Label labelSurrounding = new Label("Umgebung:");
        ChoiceBox<Object> choices = new ChoiceBox<Object>();
        choices.setItems(FXCollections.observableArrayList("Automatisch", new Separator(), "Umgebungen bearbeiten ..."));
        choices.getSelectionModel().selectFirst();
        header.getChildren().addAll(labelSurrounding, choices);
        mainBox.getChildren().add(header);

        /*
         * The left-side content
         */
        HBox content = HBoxBuilder.create().padding(new Insets(10, 10, 10, 20)).spacing(10).build();

        ListView<String> list = new ListView<String>();
        ObservableList<String> listItems = FXCollections.observableArrayList("WLAN", "Bluetooth-PAN");
        list.setItems(listItems);
        list.setPrefWidth(170);

        // Create a CellFactory for ListCells
        list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override public ListCell<String> call(ListView<String> list) {
                return new NetworkCell();
            }
        });

        content.getChildren().add(list);

        /*
         * The right-side content
         */
        GridPane grid = new GridPane();
        // grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(18, 10, 8, 15));
        AquaFx.setGroupBox(grid);

        Label labelStatus = new Label("Status:");
        GridPane.setHalignment(labelStatus, HPos.RIGHT);
        grid.add(labelStatus, 0, 0, 2, 1);
        Label labelConnected = new Label("Verbunden");
        labelConnected.setStyle("-fx-font-weight: bold;");
        grid.add(labelConnected, 2, 0);
        Button btnDisableWlan = new Button("WLAN deaktivieren");
        GridPane.setHalignment(btnDisableWlan, HPos.RIGHT);
        grid.add(btnDisableWlan, 3, 0);
        Label labelCurrent = new Label("\"WLAN\" ist mit \"PrettyFlyForAWiFi\" verbunden und \n hat die IP-Adresse 192.168.0.104.");
        labelCurrent.setStyle("-fx-font-size: 11");
        grid.add(labelCurrent, 2, 2, 3, 1);
        Label labelNetworkName = new Label("Netzwerkname:");
        GridPane.setHalignment(labelNetworkName, HPos.RIGHT);
        grid.add(labelNetworkName, 0, 3);
        ChoiceBox<Object> choicesNetwork = new ChoiceBox<Object>();
        choicesNetwork.setItems(FXCollections.observableArrayList("PrettyFlyForAWiFi", new Separator(),
                "Mit anderem Netzwerk verbinden ...", "Netzwerk anlegen"));
        choicesNetwork.getSelectionModel().selectFirst();
        GridPane.setHalignment(choicesNetwork, HPos.RIGHT);
        grid.add(choicesNetwork, 1, 3, 3, 1);
        CheckBox checkShowNew = new CheckBox("Auf neue Netzwerke hinweisen");
        checkShowNew.setSelected(true);
        grid.add(checkShowNew, 1, 4, 3, 1);
        Label labelExplanation = new Label("Bekannte Netzwerke wewrden automatisch verbunden. \n" + "Falls kein bekanntes Netzwerk vorhanden ist, werden \n" + "Sie vor dem Verbinden mit einem neuen Netzwerk \n" + "gefragt.");
        labelExplanation.setStyle("-fx-font-size: 10");
        grid.add(labelExplanation, 1, 5, 3, 1);
        VBox spacer = VBoxBuilder.create().prefHeight(140).build();
        grid.add(spacer, 0, 6);
        CheckBox chekShowState = new CheckBox("WLAN-Status in der \n" + "Menüleiste anzeigen");
        chekShowState.setSelected(true);
        GridPane.setValignment(chekShowState, VPos.TOP);
        grid.add(chekShowState, 0, 7, 2, 1);
        Button btmMore = new Button("Weitere Optionen ...");
        GridPane.setHalignment(btmMore, HPos.RIGHT);
        GridPane.setValignment(btmMore, VPos.BOTTOM);
        grid.add(btmMore, 2, 7, 2, 1);
        Button helpBtn = new Button("?");
        AquaFx.skin(helpBtn, ButtonType.HELP);
        GridPane.setValignment(helpBtn, VPos.BOTTOM);
        grid.add(helpBtn, 4, 7);

        content.getChildren().add(grid);
        mainBox.getChildren().add(content);

        /*
         * Footer
         */
        HBox footerBox = HBoxBuilder.create().spacing(5).alignment(Pos.BOTTOM_LEFT).padding(new Insets(0, 0, 5, 15)).build();
        Image image = new Image(AquaFx.class.getResource("demo/images/lock_open.png").toExternalForm());
        ImageView lockView = ImageViewBuilder.create().image(image).preserveRatio(true).fitHeight(36).build();
        footerBox.getChildren().add(lockView);
        Label info = new Label("Zum Schützen auf das Schloss klicken.");
        info.setStyle("-fx-font-size: 12");
        info.setPadding(new Insets(0, 0, 3, 0));
        footerBox.getChildren().add(info);
        mainBox.getChildren().add(footerBox);

        HBox anchorButtons = HBoxBuilder.create().spacing(15).alignment(Pos.BOTTOM_RIGHT).padding(new Insets(0, 15, 0, 0)).build();
        Button btnAssis = new Button("Assistent ...");
        anchorButtons.getChildren().add(btnAssis);
        Button btnRev = new Button("Zurücksetzen");
        btnRev.setDisable(true);
        anchorButtons.getChildren().add(btnRev);
        Button btnUse = new Button("Anwenden");
        btnUse.setDisable(true);
        anchorButtons.getChildren().add(btnUse);
        mainBox.getChildren().add(anchorButtons);

        /*
         * MenuBar
         */
        MenuBar menuBar = new MenuBar();
        Menu menuSystemPreferences = new Menu("Systemeinstellungen");
        Menu menuServices = new Menu("Dienste");
        MenuItem menuNoService = MenuItemBuilder.create().disable(true).text("Keine Dienste Verfügbar").build();
        MenuItem menuServPref = MenuItemBuilder.create().text("Dienste Enistellungen ...").build();
        menuServices.getItems().addAll(menuNoService, menuServPref);
        MenuItem menuHide = MenuItemBuilder.create().text("Sytemeinstellungen ausblenden").accelerator(
                KeyCombination.keyCombination("shortcut+H")).build();
        MenuItem menuHideOthers = MenuItemBuilder.create().text("Andere ausblenden").accelerator(
                KeyCombination.keyCombination("Alt+shortcut+H")).build();
        MenuItem menuShowAll = MenuItemBuilder.create().text("Alle einblenden").disable(true).build();
        menuSystemPreferences.getItems().addAll(new MenuItem("Über Systemeinstellungen"), new SeparatorMenuItem(), menuServices,
                new SeparatorMenuItem(), menuHide, menuHideOthers, menuShowAll, new MenuItem("Systemeinstellungen beenden"));

        Menu menuEdit = new Menu("Bearbeiten");
        menuEdit.getItems().addAll(new MenuItem("..."));

        Menu menuPreferences = new Menu("Einstellungen");
        menuPreferences.getItems().addAll(new MenuItem("..."));

        Menu menuWindow = new Menu("Fenster");
        MenuItem windowClose = MenuItemBuilder.create().text("Schließen").accelerator(KeyCombination.keyCombination("shortcut+W")).build();
        MenuItem windowDock = MenuItemBuilder.create().text("Im Dock ablegen").accelerator(
                KeyCombination.keyCombination("shortcut+M")).build();
        CheckMenuItem actual = new CheckMenuItem("Datum & Uhrzeit");
        actual.setSelected(true);
        menuWindow.getItems().addAll(windowClose, windowDock, new SeparatorMenuItem(), actual);

        Menu menuHelp = new Menu("Hilfe");
        MenuItem help = MenuItemBuilder.create().text("Systemeinstellungen-Hilfe").accelerator(
                KeyCombination.keyCombination("shortcut+?")).build();
        menuHelp.getItems().addAll(new MenuItem("Schließen"), help);

        menuBar.getMenus().addAll(menuSystemPreferences, menuEdit, menuPreferences, menuWindow, menuHelp);
        mainBox.getChildren().add(menuBar);

        Scene myScene = new Scene(mainBox, 667, sceneHeight);
        AquaFx.style();
        stage.setTitle("Netzwerk (AquaFX)");
        stage.setScene(myScene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    static class NetworkCell extends ListCell<String> {
        @Override protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null) {

                HBox cellBox = HBoxBuilder.create().alignment(Pos.CENTER_LEFT).spacing(5).padding(new Insets(2, 5, 3, 2)).build();
                ImageView dotImage;
                VBox texts = VBoxBuilder.create().alignment(Pos.CENTER_LEFT).prefWidth(95).build();
                final Label type = LabelBuilder.create().text(item).build();
                final Label legend = LabelBuilder.create().text(item).style("-fx-font-size: 11; -fx-text-fill: gray;").build();
                ImageView typeImage;

                if (item.equals("WLAN")) {
                    // Image image =
                    // Image(AquaFx.class.getResource("demo/images/dot_green.png").toExternalForm());
                    // dotImage =
                    // ImageViewBuilder.create().image(image).preserveRatio(true).fitHeight(36).build();
                    dotImage = new ImageView(NsImageIconLoader.load(NsImageIcon.STATUS_AVAILABLE));
                    legend.setText("Verbunden");
                    Image img = new Image(AquaFx.class.getResource("demo/images/wifi.png").toExternalForm());
                    typeImage = ImageViewBuilder.create().image(img).preserveRatio(true).fitHeight(32).build();
                } else {
                    dotImage = new ImageView(NsImageIconLoader.load(NsImageIcon.STATUS_PARTIALLY_AVAILABLE));
                    legend.setText("Keine IP-Adresse");
                    Image img = new Image(AquaFx.class.getResource("demo/images/bluetooth.png").toExternalForm());
                    typeImage = ImageViewBuilder.create().image(img).preserveRatio(true).fitHeight(32).build();
                }

                cellBox.getChildren().add(dotImage);
                texts.getChildren().add(type);
                texts.getChildren().add(legend);
                cellBox.getChildren().add(texts);
                cellBox.getChildren().add(typeImage);

                setGraphic(cellBox);

                selectedProperty().addListener(new ChangeListener<Boolean>() {

                    @Override public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                            Boolean newValue) {
                        if (newValue) {
                            type.setStyle("-fx-text-fill: white;");
                            legend.setStyle("-fx-font-size: 11; -fx-text-fill: white;");
                        } else {
                            type.setStyle("-fx-text-fill: black;");
                            legend.setStyle("-fx-font-size: 11; -fx-text-fill: gray;");
                        }
                    }
                });
            }

        }
    }
}
